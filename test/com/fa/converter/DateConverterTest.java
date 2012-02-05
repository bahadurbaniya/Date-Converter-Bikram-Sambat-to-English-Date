/**
 * 
 */
package com.fa.converter;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bahadur Baniya
 * 
 */
public class DateConverterTest {
    DateConverter dc;
    static Logger logger = LoggerFactory.getLogger(DateConverterTest.class);

    public DateConverterTest() {
	dc = new DateConverter();
    }

    @Test
    public void test() {

	Calendar c = Calendar.getInstance();
	c.clear();
	c.set(1982, 05, 20); // 1982 june 20 -- 05 is june as 0 is january

	assertEquals(c.getTime(), dc.convertBsToAd("06032039"));

	c.set(2001, 01, 13);
	assertEquals(c.getTime(), dc.convertBsToAd("02112057"));
	// c.set(2011,6,13);
	// assertEquals(c.getTime(), dc.convertBsToAd("29032068"));

	// assertEquals(c, dc.convertBsToAd("06032039"));
    }

    @Test(expected = InvalidDateFormat.class)
    public void incorrectDateFormat() {
	dc.convertBsToAd("290320104");
    }

    @Test(expected = CustomerDiedException.class)
    public void testCustomerDied() {
	dc.convertBsToAd("29031000");
    }

    @Test(expected = CustomerYetToBornException.class)
    public void testCustomerYetoBorn() {
	dc.convertBsToAd("29032200");
    }

    /** test number of days in nepali year should be 365 */
    @Test
    public void testValidNumberOfDaysInYear() {
	int index = 0;
	for (Integer[] days : Lookup.monthDays) {
	    logger.debug("index " + index++);
	    int day = 0;
	    for (int day2 : days) {
		day += day2;
	    }
	    assertEquals(365, day);
	}
    }
}
