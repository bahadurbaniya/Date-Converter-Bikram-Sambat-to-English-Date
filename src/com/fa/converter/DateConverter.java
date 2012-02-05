/*
 * @(#)DateConverter.java	 09/11/2010
 *
 *
 */
package com.fa.converter;

import static com.fa.converter.Lookup.lookup;
import static com.fa.converter.Lookup.lookupNepaliYearStart;
import static com.fa.converter.Lookup.monthDays;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class has functionlity to convert bikram sambat to Gregorian(AD) date
 * 
 * @author bahadur baniya
 * 
 */
public class DateConverter {
    static Logger logger = LoggerFactory.getLogger(DateConverter.class);
    String format;
    public static final String DEFAULT_FORMAT = "ddMMyyyy";
    private String separator;

    public DateConverter() {
	this(DEFAULT_FORMAT);
    }

    /**
     * @param format
     */
    private DateConverter(String format) throws InvalidDateFormat {
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
     * converts nepali bikram sambat date to Gregorian date
     * 
     * @param bsDate
     * @return
     */
    public Date convertBsToAd(String bsDate) {
	int bsYear = 0, bsMonth = 0, bsDayOfMonth = 0;

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
	    return convertBsToAd(bsDate, bsMonth, bsDayOfMonth, lookupIndex);
	} else {
	    throw new IllegalStateException("invalid BS date");
	}

    }

    /**
     * converts nepali bikram sambat date to Gregorian date
     * 
     * @param bsDate
     * @param bsMonth
     * @param bsDayOfMonth
     * @param lookupIndex
     * @return
     */
    private Date convertBsToAd(String bsDate, int bsMonth, int bsDayOfMonth,
	    int lookupIndex) {
	int numberOfDaysPassed = bsDayOfMonth - 1;// number of days
						  // passed
						  // since
						  // start of year
	// 1 is decreased as year start day has already included
	for (int i = 0; i <= bsMonth - 2; i++) {
	    numberOfDaysPassed += monthDays.get(lookupIndex)[i];
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
	String DATE_FORMAT = "dd-MMM-yyyy";
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
		DATE_FORMAT);
	sdf.setLenient(false);
	Calendar c1 = Calendar.getInstance();
	try {
	    c1.setTime(sdf.parse(lookup.get(lookupIndex)[0]));
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	c1.add(Calendar.DATE, numberOfDaysPassed);
	return c1.getTime();
    }

    /**
     * validates nepali year
     * 
     * 
     * 
     * @param bsYear
     * @param bsMonth
     * @param bsDayOfMonth
     * @return boolean if there is no lookup for provided year , false is
     *         returned
     */
    private boolean validateBsDate(int bsYear, int bsMonth, int bsDayOfMonth) {
	if (bsYear < lookupNepaliYearStart) {
	    throw new CustomerDiedException();
	} else if (bsYear > (lookupNepaliYearStart + monthDays.size() - 1)) {
	    throw new CustomerYetToBornException();
	}
	if (lookupNepaliYearStart <= bsYear
		&& bsYear <= (lookupNepaliYearStart + monthDays.size() - 1)) {
	    logger.debug("debug: converter supports  year " + bsYear);
	    if (bsMonth >= 1 && bsMonth <= 12) {
		logger.debug("debug: month between 1 and 12");
		int dayOfMonth = monthDays.get(getLookupIndex(bsYear))[bsMonth - 1];
		logger.debug("debug:total days in month " + dayOfMonth);
		if (bsDayOfMonth <= dayOfMonth) {
		    return true;
		} else {
		    logger.warn("invalid day of month " + bsDayOfMonth
			    + " for year " + bsYear + " and month " + bsMonth);
		    throw new InvalidBsDayOfMonthException(
			    "invalid day of month " + bsDayOfMonth
				    + " for year " + bsYear + " and month "
				    + bsMonth);
		}
	    }
	}
	return false;
    }

    /**
     * gets array lookup index in lookup datastructure
     * 
     * 
     * @param bsYear
     * @return
     */
    private int getLookupIndex(int bsYear) {
	logger.debug("lookup index " + (bsYear - lookupNepaliYearStart));
	return bsYear - lookupNepaliYearStart;
    }

    /**
     * confirms whether date format is valid or not. date format should be
     * mm-dd-yyyy
     * 
     * @param bsDate
     * @return
     */
    public boolean matchFormat(String bsDate) {
	if (format.equals("ddMMyyyy")) {
	    logger.debug("date format wants to test is " + format
		    + " real text is " + bsDate);
	    Pattern p = Pattern.compile("\\d{2}\\d{2}\\d{4}");
	    return p.matcher(bsDate).matches();
	} else {
	    logger.debug("date format is " + format);
	    return Pattern.matches("\\d{2}-\\d{2}-\\d{4}", bsDate);
	}
    }
}
