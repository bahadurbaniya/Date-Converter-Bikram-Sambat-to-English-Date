/*
 * @(#)DateConverter.java	 09/11/2010
 *
 *
 */
package np.com.bahadur.converter.date.nepali;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Class has functionality to convert Bikram Sambat to Gregorian(AD) date
 */
public class DateConverter {
    static final String DEFAULT_FORMAT = "ddMMyyyy";
    private static Logger logger = LoggerFactory.getLogger(DateConverter.class);
    /**
     * date input format for conversion
     */
    private String format;
    /**
     * separate character to separate day of month, month, and year
     */
    private char separator;

    public DateConverter() {
        this(DEFAULT_FORMAT);
    }

    /**
     * @param format date format
     */
    private DateConverter(String format) {
        this(format, Character.MIN_VALUE);
    }

    private DateConverter(String format, char separator) {
        this.format = format;
        this.separator = separator;
        if (!format.equals(DEFAULT_FORMAT)) {
            throw new InvalidDateFormatException(
                    "Nepali date to Gregorian Date converter only supports "
                            + DEFAULT_FORMAT);
        }
    }

    /**
     * Converts Nepali Bikram Sambat date to Gregorian date
     *
     * @param bsDate nepali date
     * @return english date
     */
    Date convertBsToAd(String bsDate) {
        int bsYear;
        int bsMonth;
        int bsDayOfMonth;

        if (separator == Character.MIN_VALUE) {
            if (!matchFormat(bsDate)) {
                throw new InvalidDateFormatException("incorrect date format  " + format
                        + " date provided was " + bsDate);
            }
            bsDayOfMonth = Integer.parseInt(bsDate.substring(0, 2));
            bsMonth = Integer.parseInt(bsDate.substring(2, 4));
            bsYear = Integer.parseInt(bsDate.substring(4));
        } else {
            String[] bsDates = bsDate.split(String.valueOf(separator));
            bsYear = Integer.parseInt(bsDates[0]);
            bsMonth = Integer.parseInt(bsDates[1]);
            bsDayOfMonth = Integer.parseInt(bsDates[2]);
        }


        if (validateBsDate(bsYear, bsMonth, bsDayOfMonth)) {
            return convertBsToAd(bsMonth, bsDayOfMonth, bsYear);
        } else {
            throw new IllegalStateException("invalid BS date");
        }

    }

    /**
     * Converts Gregorian date to Bikram Sambat date
     *
     * @param adDate english date format string "dd-MM-yyyy"
     * @return Bikram Sambat date - String type yyyy-MM-dd. There would be 1 digit month and day of month.
     */
    String convertAdToBs(String adDate) throws ParseException {
        String[] adDateParts = adDate.split("-");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate inputAdDate = LocalDate.parse(adDate, formatter);
        LocalDate lookupNearestAdDate = null;
        int equivalentNepaliYear = Lookup.lookupNepaliYearStart;
        Byte[] monthDay = null;

        // todo use +57 years addition logic to make calculation faster
        for (int i = 0; i < Lookup.adEquivalentDatesForNewNepaliYear.size(); i++) {
            String[] adEquivalentDateForNewNepaliYear = Lookup.adEquivalentDatesForNewNepaliYear.get(i).split("-");
            if (adEquivalentDateForNewNepaliYear[2].equals(adDateParts[2])) {
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                lookupNearestAdDate = LocalDate.parse(Lookup.adEquivalentDatesForNewNepaliYear.get(i), formatter1);
                monthDay = Lookup.numberOfDaysInNepaliMonth.get(i + Lookup.lookupNepaliYearStart);
                equivalentNepaliYear += i;
                if (inputAdDate.isBefore(lookupNearestAdDate)) {
                    if (i == 0) {
                        throw new DateRangeNotSupported("Date supplied before supported date.");
                    }
                    lookupNearestAdDate = LocalDate.parse(Lookup.adEquivalentDatesForNewNepaliYear.get(i - 1), formatter1);
                    equivalentNepaliYear -= 1;
                    monthDay = Lookup.numberOfDaysInNepaliMonth.get(i + Lookup.lookupNepaliYearStart - 1);
                }
            }
        }
        assert lookupNearestAdDate != null;
        //Positive day difference
        long difference = ChronoUnit.DAYS.between(lookupNearestAdDate, inputAdDate);

        int nepMonth = 0;
        int nepDay = 1;
        int daysInMonth;
        while (difference != 0) {
            if (difference >= 0) {
                //number of days in  Nepali months
                daysInMonth = monthDay[nepMonth];
                nepDay++;
                if (nepDay > daysInMonth) {
                    nepMonth++;
                    nepDay = 1;
                }
                if (nepMonth >= 12) {
                    equivalentNepaliYear++;
                    nepMonth = 0;
                }
                difference--;
            }
        }
//month index is initialised as 0 so increasing by 1
        nepMonth += 1;
        return equivalentNepaliYear + "-" + nepMonth + "-" + nepDay;
    }

    /**
     * Converts nepali bikram sambat date to Gregorian date
     *
     * @param nepaliMonth      nepali date month
     * @param nepaliDayOfMonth nepali date day of month
     * @param nepaliYear       index to look number of days in month
     * @return english date
     */
    private Date convertBsToAd(int nepaliMonth, int nepaliDayOfMonth,
                               int nepaliYear) {
        // number of days
        // passed
        // since
        // start of year
        // 1 is decreased as year start day has already included
        int numberOfDaysPassed = nepaliDayOfMonth - 1;
        for (int i = 0; i <= nepaliMonth - 2; i++) {
            numberOfDaysPassed += Lookup.numberOfDaysInNepaliMonth.get(nepaliYear)[i];
        }
        // From look up table we need to find corresponding english date
        // for
        // nepali new year
        // we need to add number of days passed from new year to english
        // date
        // which will find
        // corresponding english date
        // we need what starts
        // where...
        String dateFormat = "dd-MMM-yyyy";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                dateFormat);
        sdf.setLenient(false);
        Calendar c1 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(Lookup.adEquivalentDatesForNewNepaliYear.get(getLookupIndex(nepaliYear))));
        } catch (ParseException e) {
            logger.error("error", e);
        }
        c1.add(Calendar.DATE, numberOfDaysPassed);
        return c1.getTime();
    }

    /**
     * Validates nepali date
     *
     * @param bsYear       nepali date year part
     * @param bsMonth      nepali date month part
     * @param bsDayOfMonth nepali date day of month
     * @return boolean returns false  if there is no lookup for provided year ,
     */
    private boolean validateBsDate(int bsYear, int bsMonth, int bsDayOfMonth) {
        if (bsYear < Lookup.lookupNepaliYearStart) {
            throw new DateRangeNotSupported("Bikam Sambat is earlier than supported date");
        } else if (bsYear > (Lookup.lookupNepaliYearStart + Lookup.numberOfDaysInNepaliMonth.size() - 1)) {
            throw new DateRangeNotSupported("Bikram Sambat is later than supported date");
        } else {
            logger.debug("debug: converter supports  year {} ", bsYear);
            if (bsMonth >= 1 && bsMonth <= 12) {
                logger.debug("debug: month between 1 and 12");
                int dayOfMonth = Lookup.numberOfDaysInNepaliMonth.get(bsYear)[bsMonth - 1];
                logger.debug("debug:total days in month {} ", dayOfMonth);
                if (bsDayOfMonth <= dayOfMonth) {
                    return true;
                } else {
                    String message = String.format("invalid day of month  %d for year  %d  and month  %d ", bsDayOfMonth, bsYear, bsMonth);
                    logger.warn(message);
                    throw new InvalidBsDayOfMonthException(
                            message);
                }
            }
        }
        return false;
    }

    /**
     * gets array lookup index in lookup datastructure
     *
     * @param bsYear nepali year
     * @return index where year is
     */
    private int getLookupIndex(int bsYear) {
        logger.debug("lookup index {} ", (bsYear - Lookup.lookupNepaliYearStart));
        return bsYear - Lookup.lookupNepaliYearStart;
    }

    /**
     * confirms whether date format is valid or not. date format should be
     * mm-dd-yyyy
     *
     * @param bsDate nepali date
     * @return true if format matches
     */
    boolean matchFormat(String bsDate) {
        if (format.equals(DEFAULT_FORMAT)) {
            logger.debug("date format want to test is {} real text is {}", format, bsDate);
            Pattern p = Pattern.compile("\\d{2}\\d{2}\\d{4}");
            return p.matcher(bsDate).matches();
        } else {
            logger.debug("date format is {}", format);
            return Pattern.matches("\\d{2}-\\d{2}-\\d{4}", bsDate);
        }
    }
}
