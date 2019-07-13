/*
 * @(#)DateConverter.java	 09/11/2010
 *
 *
 */
package np.com.bahadur.converter.date.nepali;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Class has functionality to convert bikram sambat to Gregorian(AD) date
 *
 * @author bahadur baniya
 */
public class DateConverter {
    static final String DEFAULT_FORMAT = "ddMMyyyy";
    private static Logger logger = LoggerFactory.getLogger(DateConverter.class);
    private String format;
    private String separator;

    public DateConverter() {
        this(DEFAULT_FORMAT);
    }

    /**
     * @param format date format
     */
    private DateConverter(String format) {
        this(format, null);
    }

    private DateConverter(String format, String separator) {
        if (format.equals(DEFAULT_FORMAT)) {
            this.format = format;
        } else {
            throw new InvalidDateFormat(
                    "Nepali date to Gregorian Date converter only supports "
                            + DEFAULT_FORMAT);
        }

    }

    /**
     * converts nepali Bikram Sambat date to Gregorian date
     *
     * @param bsDate nepali date
     * @return english date
     */
    Date convertBsToAd(String bsDate) {
        int bsYear;
        int bsMonth;
        int bsDayOfMonth;

        if (separator == null) {
            if (!matchFormat(bsDate)) {
                throw new InvalidDateFormat("incorrect date format  " + format
                        + " date provided was " + bsDate);
            }
            bsDayOfMonth = Integer.parseInt(bsDate.substring(0, 2));
            bsMonth = Integer.parseInt(bsDate.substring(2, 4));
            bsYear = Integer.parseInt(bsDate.substring(4));
        } else {
            String[] bsDates = bsDate.split(separator);
            bsYear = Integer.parseInt(bsDates[0]);
            bsMonth = Integer.parseInt(bsDates[1]);
            bsDayOfMonth = Integer.parseInt(bsDates[2]);
        }

        int lookupIndex = getLookupIndex(bsYear);
        if (validateBsDate(bsYear, bsMonth, bsDayOfMonth)) {
            return convertBsToAd(bsMonth, bsDayOfMonth, lookupIndex);
        } else {
            throw new IllegalStateException("invalid BS date");
        }

    }

    /**
     * Converts Gregorian date to Bikram Sambat date
     *
     * @param adDate english date format string
     * @return Bikram Sambat date - String type dd-MM-yyyy. There would be 1 digit month and day of month.
     */
    String convertAdToBs(String adDate) throws ParseException {
        String[] getCurrentYear = adDate.split("-");

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date current = df.parse(adDate);
        Date start = null;
        long equBs = Lookup.lookupNepaliYearStart;
        Integer[] monthDay = null;
        for (int i = 0; i < Lookup.lookup.size(); i++) {
            String[] getStartYear = Lookup.lookup.get(i)[0].split("-");
            if (getStartYear[2].equals(getCurrentYear[2])) {
                DateFormat df1 = new SimpleDateFormat("dd-MMM-yyyy");
                start = df1.parse(Lookup.lookup.get(i)[0]);
                monthDay = Lookup.monthDays.get(i);
                equBs += i;
                if (start.getTime() >= current.getTime()) {
                    start = df1.parse(Lookup.lookup.get(i - 1)[0]);
                    equBs -= 1;
                }
            }
        }
        long diff = current.getTime() - start.getTime();
        long difference = diff / (1000 * 60 * 60 * 24);
        int nepYear = (int) equBs;
        int nepMonth = 0;
        int nepDay = 1;
        int daysInMonth;
        while (difference != 0) {
            if (difference >= 0) {
                daysInMonth = monthDay[nepMonth];
                nepDay++;
                if (nepDay > daysInMonth) {
                    nepMonth++;
                    nepDay = 1;
                }
                if (nepMonth >= 12) {
                    nepYear++;
                    nepMonth = 0;
                }
                difference--;
            }
        }

        nepMonth += 1;
        return nepYear + "-" + nepMonth + "-" + nepDay;

    }

    /**
     * converts nepali bikram sambat date to Gregorian date
     *
     * @param bsMonth      nepali date month
     * @param bsDayOfMonth nepali date day of month
     * @param lookupIndex  index to look number of days in month
     * @return english date
     */
    private Date convertBsToAd(int bsMonth, int bsDayOfMonth,
                               int lookupIndex) {
        // number of days
        // passed
        // since
        // start of year
        // 1 is decreased as year start day has already included
        int numberOfDaysPassed = bsDayOfMonth - 1;
        for (int i = 0; i <= bsMonth - 2; i++) {
            numberOfDaysPassed += Lookup.monthDays.get(lookupIndex)[i];
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
            c1.setTime(sdf.parse(Lookup.lookup.get(lookupIndex)[0]));
        } catch (ParseException e) {
            logger.error("error", e);
        }
        c1.add(Calendar.DATE, numberOfDaysPassed);
        return c1.getTime();
    }

    /**
     * validates nepali date
     *
     * @param bsYear       nepali date year part
     * @param bsMonth      nepali date month part
     * @param bsDayOfMonth nepali date day of month
     * @return boolean returns false  if there is no lookup for provided year ,
     */
    private boolean validateBsDate(int bsYear, int bsMonth, int bsDayOfMonth) {
        if (bsYear < Lookup.lookupNepaliYearStart) {
            throw new DateRangeNotSupported("Bikam Sambat is earlier than supported date");
        } else if (bsYear > (Lookup.lookupNepaliYearStart + Lookup.monthDays.size() - 1)) {
            throw new DateRangeNotSupported("Bikram Sambat is later than supported date");
        } else {
            logger.debug("debug: converter supports  year {} ", bsYear);
            if (bsMonth >= 1 && bsMonth <= 12) {
                logger.debug("debug: month between 1 and 12");
                int dayOfMonth = Lookup.monthDays.get(getLookupIndex(bsYear))[bsMonth - 1];
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
