package np.com.bahadur.converter.date.nepali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    /**
     * Regression test for corrupted Bikram Sambat month-length and AD-new-year
     * anchor tables in {@link Lookup}.
     * <p>
     * Each case below was previously RED (off by -2/-1/+1 days) because the
     * hardcoded {@code numberOfDaysInNepaliMonth} table had transcription
     * errors in 26 BS years and {@code adEquivalentDatesForNewNepaliYear} had
     * 2 wrong anchors (BS1975, BS2092). The expected AD dates are the official
     * Nepal Calendar Committee values (as shipped by the {@code nepali_datetime}
     * 1.0.8.5 Python package). Before the table fix these assertions failed;
     * after the fix they must pass.
     */
    @Test
    void testBsToAdOfficialCalendarRegression() {
        Calendar c = Calendar.getInstance();

        // BS 2085-06-01 -> 2028-09-16 (was 2028-09-17, +1)
        c.clear();
        c.set(2028, Calendar.SEPTEMBER, 16);
        assertEquals(c.getTime(), dc.convertBsToAd("01062085"));

        // BS 2092-01-01 -> 2035-04-15 (was 2035-04-13, -2; anchor-table error)
        c.clear();
        c.set(2035, Calendar.APRIL, 15);
        assertEquals(c.getTime(), dc.convertBsToAd("01012092"));

        // BS 1975-06-01 -> 1918-09-17 (was 1918-09-15, -2; anchor-table error)
        c.clear();
        c.set(1918, Calendar.SEPTEMBER, 17);
        assertEquals(c.getTime(), dc.convertBsToAd("01061975"));

        // BS 1975-05-01 -> 1918-08-17 (was 1918-08-16, -1)
        c.clear();
        c.set(1918, Calendar.AUGUST, 17);
        assertEquals(c.getTime(), dc.convertBsToAd("01051975"));

        // BS 2081-12-01 -> 2025-03-14 (was 2025-03-15, +1)
        c.clear();
        c.set(2025, Calendar.MARCH, 14);
        assertEquals(c.getTime(), dc.convertBsToAd("01122081"));

        // BS 2086-02-01 -> 2029-05-14 (was 2029-05-15, +1)
        c.clear();
        c.set(2029, Calendar.MAY, 14);
        assertEquals(c.getTime(), dc.convertBsToAd("01022086"));

        // BS 2089-02-01 -> 2032-05-14 (was 2032-05-15, +1)
        c.clear();
        c.set(2032, Calendar.MAY, 14);
        assertEquals(c.getTime(), dc.convertBsToAd("01022089"));

        // BS 2098-12-01 -> 2042-03-14 (was 2042-03-15, +1)
        c.clear();
        c.set(2042, Calendar.MARCH, 14);
        assertEquals(c.getTime(), dc.convertBsToAd("01122098"));

        // Reality anchors that were already correct and must stay correct.
        // BS 2081-01-01 -> 2024-04-13 (New Year 2081 BS, 2024-04-13).
        c.clear();
        c.set(2024, Calendar.APRIL, 13);
        assertEquals(c.getTime(), dc.convertBsToAd("01012081"));

        // BS 2079-01-01 -> 2022-04-14.
        c.clear();
        c.set(2022, Calendar.APRIL, 14);
        assertEquals(c.getTime(), dc.convertBsToAd("01012079"));
    }

    /**
     * Reverse-direction regression: AD -> BS for the previously-RED anchors.
     */
    @Test
    void testAdToBsOfficialCalendarRegression() throws ParseException {
        // 2028-09-16 -> BS 2085-6-1
        assertEquals("2085-6-1", dc.convertAdToBs("16-09-2028"));
        // 2035-04-15 -> BS 2092-1-1 (anchor-table error year)
        assertEquals("2092-1-1", dc.convertAdToBs("15-04-2035"));
        // 1918-09-17 -> BS 1975-6-1 (anchor-table error year)
        assertEquals("1975-6-1", dc.convertAdToBs("17-09-1918"));
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


    @Nested
    @DisplayName("Testing for 2082BS")
    class TestFor2082BS {
        @Test
        @DisplayName("English date conversion should return the specified nepali dates which are based from a physical calendar")
        void testFor2082() throws ParseException {
            assertEquals("2082-1-16", dc.convertAdToBs("29-04-2025"));
            assertEquals("2082-2-16", dc.convertAdToBs("30-05-2025"));
            assertEquals("2082-3-16", dc.convertAdToBs("30-06-2025"));
            assertEquals("2082-4-16", dc.convertAdToBs("01-08-2025"));
            assertEquals("2082-4-16", dc.convertAdToBs("01-08-2025"));
            assertEquals("2082-5-16", dc.convertAdToBs("01-09-2025"));
            assertEquals("2082-6-16", dc.convertAdToBs("02-10-2025"));
            assertEquals("2082-7-16", dc.convertAdToBs("02-11-2025"));
            assertEquals("2082-8-16", dc.convertAdToBs("02-12-2025"));
            assertEquals("2082-9-16", dc.convertAdToBs("31-12-2025"));
            assertEquals("2082-10-16", dc.convertAdToBs("30-01-2026"));
            assertEquals("2082-11-16", dc.convertAdToBs("28-02-2026"));
            assertEquals("2082-12-16", dc.convertAdToBs("30-03-2026"));
        }

    }

}
