package np.com.bahadur.converter.date.nepali;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Map;

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
        //first argument nepali date, second english date 
        
        assertEquals("2039-3-6", dc.convertAdToBs("20-06-1982"));


        assertEquals("2041-1-28", dc.convertAdToBs("10-05-1984"));

      
        //  २०६३ फागुन ७ 19 February , 2007
        assertEquals("2063-11-7", dc.convertAdToBs("19-02-2007"));

        assertEquals("2074-11-11", dc.convertAdToBs("23-02-2018"));

        // https://nepalipatro.com.np/calendar/bs/2083-04-19
         assertEquals("2083-4-19", dc.convertAdToBs("04-08-2026")); 
        //  From https://nepalipatro.com.np/calendar/bs/2090-01-30  
        assertEquals("2099-12-30", dc.convertAdToBs("13-04-2043"));
         //  From https://nepalipatro.com.np/calendar/bs/2099-12-30  
      
    }


    @Test
    void testAdToBsBugFix() throws ParseException {
        //12 Feb 1997 - 1 Falgun 2053  --- error giving 2053 Magh 30
        assertEquals("2053-11-1", dc.convertAdToBs("12-02-1997"));
    }


    @Test
    void testAdToBsBugEdgeCases() throws ParseException {
        assertEquals("1970-1-1", dc.convertAdToBs("13-04-1913"));
        assertEquals("1970-12-30", dc.convertAdToBs("12-04-1914"));
        assertEquals("1971-1-1", dc.convertAdToBs("13-04-1914"));
    }

    @Test
    void incorrectDateFormat() {
        assertThrows(InvalidDateFormatException.class, () -> dc.convertBsToAd("290320104"));
    }

    @Test
    void testDateNotSupported() {
        assertThrows(DateRangeNotSupported.class, () -> dc.convertBsToAd("29031000"));
        assertThrows(DateRangeNotSupported.class, () -> dc.convertBsToAd("21011000"));
    }

    @Test
    void testDateRangeNotSupported() {
        assertThrows(DateRangeNotSupported.class, () -> dc.convertBsToAd("29032200"));
    }


    @Test
    void testDateRangeNotSupported1() {
        assertThrows(DateRangeNotSupported.class, () -> dc.convertBsToAd("29031969"));
    }


    // could not calculate  as there is no lookup
    @Test
    void testAdDateRangeBeforeSupportedDate() {
        assertThrows(DateRangeNotSupported.class, () -> dc.convertAdToBs("12-04-1913"));
    }


    // could not calculate  as there is no lookup
    @Test
    void testAdDateLaterThanSupportedDate() {
        assertThrows(AssertionError.class, () -> dc.convertAdToBs("12-04-3000"));
    }

    /**
     * test number of days in nepali year should be 365.
     * Some nepalese calendar year has 364 -367 days.
     */
    @Test
    void testValidNumberOfDaysInYear() {
        int index = 0;
        Map<Integer, Byte[]> numberOfDaysInNepaliMonth = Lookup.numberOfDaysInNepaliMonth;

        numberOfDaysInNepaliMonth.forEach((nepaliYear, days) -> {

            // logger.debug("index {}", index++);
            int numberOfDaysInYear = 0;
            for (byte day : days) {
                numberOfDaysInYear += day;
            }

            if (numberOfDaysInYear != 365) {
                logger.warn("Why Nepali year {} has total days {} instead of 365 days?", nepaliYear, numberOfDaysInYear);
            }
            // interesting thing: number of days in  nepalese calendar year can have days between 364 to 367 days.
            assertTrue(numberOfDaysInYear >= 364 && numberOfDaysInYear <= 367);

        });


    }

    /**
     * Confirm there is no bug  https://github.com/bahadurbaniya/Date-Converter-Bikram-Sambat-to-English-Date/issues/9
     */
    @Test
    void testAdToBsBug() throws ParseException {
        // २०३८ कार्तिक १ - 1981 October 17
        assertEquals("2038-7-1", dc.convertAdToBs("17-10-1981"));
    }

    @Test
    void testNumberOfYears() throws ParseException {
        assertEquals(131, Lookup.numberOfDaysInNepaliMonth.size());
        assertEquals(131, Lookup.adEquivalentDatesForNewNepaliYear.size());

    }


}
