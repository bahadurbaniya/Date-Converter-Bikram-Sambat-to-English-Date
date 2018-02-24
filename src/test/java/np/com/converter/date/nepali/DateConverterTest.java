/**
 *
 */
package np.com.converter.date.nepali;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bahadur Baniya
 */
public class DateConverterTest {
    DateConverter dc;
    static Logger logger = LoggerFactory.getLogger(DateConverterTest.class);

    public DateConverterTest() {
        dc = new DateConverter();
    }

    @Test
    public void testBsToAd() {

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


    @Test
    public void testAdToBs() throws ParseException{
        assertEquals("2039-3-6", dc.convertAdToBs("20-06-1982"));


        assertEquals("2074-11-11", dc.convertAdToBs("23-02-2018"));



        assertEquals("2041-1-28", dc.convertAdToBs("10-05-1984"));
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

    /**
     * test number of days in nepali year should be 365.
     * Some year has 364 -367 days.
     */
    @Test
    public void testValidNumberOfDaysInYear() {
        int index = 0;
        for (Integer[] days : Lookup.monthDays) {
            logger.debug("index " + index++);
            int numberOfDaysInYear = 0;
            for (int day : days) {

                numberOfDaysInYear += day;
            }
            logger.debug("total days " + numberOfDaysInYear);

            assertTrue("was not equal. number of days in one of the year " + Integer.toString(numberOfDaysInYear), numberOfDaysInYear >= 364  && numberOfDaysInYear <= 367 );

        }
    }
}
