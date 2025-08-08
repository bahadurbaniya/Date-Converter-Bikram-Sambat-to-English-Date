/*
 * @(#)Lookup.java	 09/11/2010
 *
 *
 */
package np.com.bahadur.converter.date.nepali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class has a mapping from Bikram Sambat to Gregorian date
 * Current mapping is in range of 1970-2100
 * If you need extension in date range,
 * add more  dates referring to sites mentioned in README.md.
 * <p>
 * todo  it would be better if these lookup tables could be maintained in XML or JSON or in memory database.
 * </p>
 * <p>
 * There are certain year where there is not 365 days per year, verify these year with other calendar.
 * </p>
 */
public class Lookup {
    /**
     * Bikram Sambat new year equivalent Gregorian date
     * <p>
     * TODO map would be good format for faster calculation.
     */
    static ArrayList<String> adEquivalentDatesForNewNepaliYear = new ArrayList<>();
    /*
     * lookup table starting year
     */
    static int lookupNepaliYearStart = 1970;
    /*
     * number of days in each Nepali month for subsequent years we need to extend this
     * year adding more entries
     *  * TODO map would be good format for faster calculation and readability
     */
    static Map<Integer, Byte[]> numberOfDaysInNepaliMonth = new HashMap<>();

    static {
        //todo create some csv or sort sort of external collaborative data others can update who does not know java
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1913");// 1970 Baisakh 1 english equivalent date
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1914");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1915");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1916");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1917");
        adEquivalentDatesForNewNepaliYear.add("12-Apr-1918");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1919");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1920");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1921");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1922");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1923");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1924");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1925");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1926");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1927");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1928");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1929");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1930");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1931");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1932");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1933");// 1990 Baisakh 1
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1934");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1935");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1936");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1937");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1938");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1939");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1940");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1941");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1942");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1943");// 2000 Baisakh 1
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1944");// 2001 Baisakh 1
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1945");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1946");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1947");// 2004
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1948");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1949");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1950");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1951");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1952");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1953");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1954");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1955");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1956");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1957");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1958");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1959");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1960");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1961");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1962");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1963");// 2020
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1964");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1965");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1966");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1967");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1968");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1969");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1970");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1971");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1972");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1973");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1974");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1975");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1976");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1977");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1978");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1979");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1980");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1981");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1982");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1983");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1984");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1985");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1986");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1987");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1988");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1989");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1990");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1991");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1992");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1993");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1994");// 2051
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1995");// 2052
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1996");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-1997");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1998");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-1999");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2000");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2001");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2002");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2003");// 2060
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2004");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2005");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2006");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2007");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2008");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2009");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2010");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2011");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2012");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2013");// 2070
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2014");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2015");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2016");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2017");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2018");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2019");
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2020");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2021");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2022");
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2023");// 2080
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2024");// 2081
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2025");// 2082
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2026");// 2083
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2027");// 2084
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2028");// 2085
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2029");// 2086
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2030");// 2087
        adEquivalentDatesForNewNepaliYear.add("15-Apr-2031");// 2088
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2032");// 2089
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2033");// 2090
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2034");// 2091
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2035");// 2092
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2036");// 2093
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2037");// 2094
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2038");// 2095
        adEquivalentDatesForNewNepaliYear.add("15-Apr-2039");// 2096
        adEquivalentDatesForNewNepaliYear.add("13-Apr-2040");// 2097
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2041");// 2098
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2042");// 2099
        adEquivalentDatesForNewNepaliYear.add("14-Apr-2043");// 2100 BS 
    }

    private Lookup() {
    }

    static {
        //number after // is Nepali year
        numberOfDaysInNepaliMonth.put(1970, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1970
        numberOfDaysInNepaliMonth.put(1971, new Byte[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29,
                30, 30});// 1971
        numberOfDaysInNepaliMonth.put(1972, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});// 1972
        numberOfDaysInNepaliMonth.put(1973, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});// 1973
        numberOfDaysInNepaliMonth.put(1974, new Byte[]{31, 31, 32, 30, 31, 31, 30, 29, 30, 29,
                30, 30});// 1974
        numberOfDaysInNepaliMonth.put(1975, new Byte[]{31, 31, 32, 32, 30, 31, 30, 29, 30, 29,
                30, 30});// 1975
        numberOfDaysInNepaliMonth.put(1976, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});// 1976
        numberOfDaysInNepaliMonth.put(1977, new Byte[]{30, 32, 31, 32, 31, 31, 29, 30, 29, 30,
                29, 31});// 1977
        numberOfDaysInNepaliMonth.put(1978, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1978
        numberOfDaysInNepaliMonth.put(1979, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 1979
        numberOfDaysInNepaliMonth.put(1980, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});// 1980
        numberOfDaysInNepaliMonth.put(1981, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});// 1981
        numberOfDaysInNepaliMonth.put(1982, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1982
        numberOfDaysInNepaliMonth.put(1983, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 1983
        numberOfDaysInNepaliMonth.put(1984, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});// 1984
        numberOfDaysInNepaliMonth.put(1985, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});// 1985
        numberOfDaysInNepaliMonth.put(1986, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1986
        numberOfDaysInNepaliMonth.put(1987, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 1987
        numberOfDaysInNepaliMonth.put(1988, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});// 1988
        numberOfDaysInNepaliMonth.put(1989, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1989
        numberOfDaysInNepaliMonth.put(1990, new Byte[]{30, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1990
        numberOfDaysInNepaliMonth.put(1991, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 1991
        numberOfDaysInNepaliMonth.put(1992, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 30});// 1992
        numberOfDaysInNepaliMonth.put(1993, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1993
        numberOfDaysInNepaliMonth.put(1994, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1994
        numberOfDaysInNepaliMonth.put(1995, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1995
        numberOfDaysInNepaliMonth.put(1996, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1996
        numberOfDaysInNepaliMonth.put(1997, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1997
        numberOfDaysInNepaliMonth.put(1998, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1998
        numberOfDaysInNepaliMonth.put(1999, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1999
        numberOfDaysInNepaliMonth.put(2000, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                29, 31});// 2000
        numberOfDaysInNepaliMonth.put(2001, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2001
        numberOfDaysInNepaliMonth.put(2002, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 2002 366 days
        numberOfDaysInNepaliMonth.put(2003, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31}); //2003
        numberOfDaysInNepaliMonth.put(2004, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2005, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30}); //2005
        numberOfDaysInNepaliMonth.put(2006, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2007, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2008, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                29, 31});
        numberOfDaysInNepaliMonth.put(2009, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2010, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30}); //2010
        numberOfDaysInNepaliMonth.put(2011, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2012, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2013, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2014, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2015, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31}); //2015
        numberOfDaysInNepaliMonth.put(2016, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2017, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2018, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2019, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2020, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30}); //2020
        numberOfDaysInNepaliMonth.put(2021, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2022, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2023, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2024, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2025, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2025
        numberOfDaysInNepaliMonth.put(2026, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2027, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2028, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2029, new Byte[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2030, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31}); //2030
        numberOfDaysInNepaliMonth.put(2031, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2032, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2033, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2034, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2035, new Byte[]{30, 32, 31, 32, 31, 31, 29, 30, 30, 29,
                29, 31}); //2035
        numberOfDaysInNepaliMonth.put(2036, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2036
        numberOfDaysInNepaliMonth.put(2037, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2038, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2039, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});//2039
        numberOfDaysInNepaliMonth.put(2040, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2041, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30}); // 2041
        numberOfDaysInNepaliMonth.put(2042, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2043, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2044, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2045, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2046, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2047, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2048, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2048
        numberOfDaysInNepaliMonth.put(2049, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2050, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2051, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2052, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2052
        numberOfDaysInNepaliMonth.put(2053, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30}); //2053
        numberOfDaysInNepaliMonth.put(2054, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2055, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2056, new Byte[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2057, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2058, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2059, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2060, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 2060
        numberOfDaysInNepaliMonth.put(2061, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2062, new Byte[]{30, 32, 31, 32, 31, 31, 29, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2063, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2064, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2065, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2066, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                29, 31});
        numberOfDaysInNepaliMonth.put(2067, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2068, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2069, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2070, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});// 2070
        numberOfDaysInNepaliMonth.put(2071, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2072, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2073, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2074, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2075, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2076, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2077, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2078, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2079, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2080, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});// 2080
        numberOfDaysInNepaliMonth.put(2081, new Byte[]{31, 31, 32, 32, 31, 30, 30, 30, 29, 30,
                30, 31});// 2081
        numberOfDaysInNepaliMonth.put(2082, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2082
        numberOfDaysInNepaliMonth.put(2083, new Byte[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30,
                30, 30});// 2083
        numberOfDaysInNepaliMonth.put(2084, new Byte[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30,
                30, 30});// 2084
        numberOfDaysInNepaliMonth.put(2085, new Byte[]{31, 32, 31, 32, 31, 31, 30, 30, 29, 30,
                30, 30});// 2085
        numberOfDaysInNepaliMonth.put(2086, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2086
        numberOfDaysInNepaliMonth.put(2087, new Byte[]{31, 31, 32, 31, 31, 31, 30, 30, 29, 30,
                30, 30});// 2087
        numberOfDaysInNepaliMonth.put(2088, new Byte[]{30, 31, 32, 32, 30, 31, 30, 30, 29, 30,
                30, 30});// 2088
        numberOfDaysInNepaliMonth.put(2089, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2089
        numberOfDaysInNepaliMonth.put(2090, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2090
        numberOfDaysInNepaliMonth.put(2091, new Byte[]{31, 31, 32, 31, 31, 31, 30, 30, 29, 30,
                30, 30});// 2091
        numberOfDaysInNepaliMonth.put(2092, new Byte[]{31, 31, 32, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2092
        numberOfDaysInNepaliMonth.put(2093, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2093
        numberOfDaysInNepaliMonth.put(2094, new Byte[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30,
                30, 30});// 2094
        numberOfDaysInNepaliMonth.put(2095, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 30,
                30, 30});// 2095
        numberOfDaysInNepaliMonth.put(2096, new Byte[]{30, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 2096
        numberOfDaysInNepaliMonth.put(2097, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2097
        numberOfDaysInNepaliMonth.put(2098, new Byte[]{31, 31, 32, 31, 31, 31, 29, 30, 29, 30,
                30, 31});// 2098
        numberOfDaysInNepaliMonth.put(2099, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 29, 30,
                30, 30});// 2099
        numberOfDaysInNepaliMonth.put(2100, new Byte[]{31, 32, 31, 32, 30, 31, 30, 29, 30, 29,
                30, 30});// 2100 BS 
    }

}
