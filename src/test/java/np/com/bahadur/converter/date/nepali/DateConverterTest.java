package np.com.bahadur.converter.date.nepali;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Bahadur Baniya
 */
public class DateConverterTest {
    private static Logger logger = LoggerFactory.getLogger(DateConverterTest.class);
    private DateConverter dc;

    public DateConverterTest() {
        dc = new DateConverter();
    }

    @Test
    public void testBsToAd() {

        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(1982, Calendar.JUNE, 20); // 1982 june 20 -- 05 is june as 0 is january

        assertEquals(c.getTime(), dc.convertBsToAd("06032039"));

        c.set(2001, Calendar.FEBRUARY, 13);
        assertEquals(c.getTime(), dc.convertBsToAd("02112057"));
        // c.set(2011,6,13);
        // assertEquals(c.getTime(), dc.convertBsToAd("29032068"));

        // assertEquals(c, dc.convertBsToAd("06032039"));
    }

    @Test
    public void testAdToBs() throws ParseException {
        assertEquals("2039-3-6", dc.convertAdToBs("20-06-1982"));

        assertEquals("2074-11-11", dc.convertAdToBs("23-02-2018"));

        assertEquals("2041-1-28", dc.convertAdToBs("10-05-1984"));
    }


    @Test(expected = InvalidDateFormat.class)
    public void incorrectDateFormat() {
        dc.convertBsToAd("290320104");
    }

    @Test(expected = DateRangeNotSupported.class)
    public void testCustomerDied() {
        dc.convertBsToAd("29031000");
    }

    @Test(expected = DateRangeNotSupported.class)
    public void testDateRangeNotSupported() {
        dc.convertBsToAd("29032200");
    }

    /**
     * test number of days in nepali year should be 365.
     * Some year has 364 -367 days.
     */
    @Test
    public void testValidNumberOfDaysInYear() {
        int index = 0;
        for (Integer[] days : Lookup.monthDays) {
            logger.debug("index {}", index++);
            int numberOfDaysInYear = 0;
            for (int day : days) {
                numberOfDaysInYear += day;
            }
            logger.debug("total days {}", numberOfDaysInYear);
            assertTrue("was not equal. number of days in one of the year " + numberOfDaysInYear, numberOfDaysInYear >= 364 && numberOfDaysInYear <= 367);

        }
    }
}
