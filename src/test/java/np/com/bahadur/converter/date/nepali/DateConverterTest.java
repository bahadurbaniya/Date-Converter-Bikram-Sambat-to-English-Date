package np.com.bahadur.converter.date.nepali;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class DateConverterTest {
    private static Logger logger = LoggerFactory.getLogger(DateConverterTest.class);
    private DateConverter dc;

    DateConverterTest() {
        dc = new DateConverter();
    }

    @Test
    void testBsToAd() {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(1982, Calendar.JUNE, 20); // 1982 june 20 -- 05 is june as 0 is january

        assertEquals(c.getTime(), dc.convertBsToAd("06032039"));

        c.set(2001, Calendar.FEBRUARY, 13);
        assertEquals(c.getTime(), dc.convertBsToAd("02112057"));

        c.set(2011, Calendar.JULY, 13);
        assertEquals(c.getTime(), dc.convertBsToAd("29032068"));
    }

    @Test
    void testAdToBs() throws ParseException {
        assertEquals("2039-3-6", dc.convertAdToBs("20-06-1982"));

        assertEquals("2074-11-11", dc.convertAdToBs("23-02-2018"));

        assertEquals("2041-1-28", dc.convertAdToBs("10-05-1984"));
    }


    @Test
    void incorrectDateFormat() {
        assertThrows(InvalidDateFormatException.class, () -> dc.convertBsToAd("290320104"));
    }

    @Test
    void testDateNotSupported() {
        assertThrows(DateRangeNotSupported.class, () -> dc.convertBsToAd("29031000"));
    }

    @Test
    void testDateRangeNotSupported() {
        assertThrows(DateRangeNotSupported.class, () -> dc.convertBsToAd("29032200"));
    }

    /**
     * test number of days in nepali year should be 365.
     * Some nepalese calendar year has 364 -367 days.
     */
    @Test
    void testValidNumberOfDaysInYear() {
        int index = 0;
        for (Integer[] days : Lookup.monthDays) {
            logger.debug("index {}", index++);
            int numberOfDaysInYear = 0;
            for (int day : days) {
                numberOfDaysInYear += day;
            }
            logger.debug("total days {}", numberOfDaysInYear);
            // interesting thing: number of days  nepalese calendar year can have days between 364 to 367 days.
            assertTrue(numberOfDaysInYear >= 364 && numberOfDaysInYear <= 367);
        }
    }

    /**
     * test there is no bug  https://github.com/bahadurbaniya/Date-Converter-Bikram-Sambat-to-English-Date/issues/9
     */
    @Test
    void testAdToBsBug() throws ParseException {
        // २०३८ कार्तिक १ - 1981 October 17
        assertEquals("2038-7-1", dc.convertAdToBs("17-10-1981"));
    }


}
