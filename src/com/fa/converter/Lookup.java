/*
 * @(#)Lookup.java	 09/11/2010
 *
 *
 */
package com.fa.converter;

import java.util.ArrayList;

/**
 * <code>Lookup<code> is a simple  class which has mapping from Bikram Sambat to Gregorian date  
 * Current mapping is in range of 1970-2100
 * If you need extension in date range,
 * add more referring <a href='http://www.ashesh.com.np/nepali-calendar/?'>Bikram Sambat Calendar.
 * Which has 1970-2100 bikram sambat date range
 * @todo it would be better if these lookup tables could be maintained in xml file
 * There are certain year where there is not 365 days per year, verify these year with other calendar
 * 
 * @author bahadur baniya
 */
public class Lookup {
    /*
     * lookup table starting year
     */
    public static int lookupNepaliYearStart = 1970;
    /**
     * Bikram Sambat new year equivalent Gregorian date
     */
    public static ArrayList<String[]> lookup = new ArrayList<String[]>();
    static {
	lookup.add(new String[] { "13-Apr-1913" });// 1970 Baisakh 1
	lookup.add(new String[] { "13-Apr-1914" });
	lookup.add(new String[] { "13-Apr-1915" });
	lookup.add(new String[] { "13-Apr-1916" });
	lookup.add(new String[] { "13-Apr-1917" });
	lookup.add(new String[] { "12-Apr-1918" });
	lookup.add(new String[] { "13-Apr-1919" });
	lookup.add(new String[] { "13-Apr-1920" });
	lookup.add(new String[] { "13-Apr-1921" });
	lookup.add(new String[] { "13-Apr-1922" });
	lookup.add(new String[] { "13-Apr-1923" });
	lookup.add(new String[] { "13-Apr-1924" });
	lookup.add(new String[] { "13-Apr-1925" });
	lookup.add(new String[] { "13-Apr-1926" });
	lookup.add(new String[] { "13-Apr-1927" });
	lookup.add(new String[] { "13-Apr-1928" });
	lookup.add(new String[] { "13-Apr-1929" });
	lookup.add(new String[] { "13-Apr-1930" });
	lookup.add(new String[] { "13-Apr-1931" });
	lookup.add(new String[] { "13-Apr-1932" });
	lookup.add(new String[] { "13-Apr-1933" });// 1990 Baisakh 1
	lookup.add(new String[] { "13-Apr-1934" });
	lookup.add(new String[] { "13-Apr-1935" });
	lookup.add(new String[] { "13-Apr-1936" });
	lookup.add(new String[] { "13-Apr-1937" });
	lookup.add(new String[] { "13-Apr-1938" });
	lookup.add(new String[] { "13-Apr-1939" });
	lookup.add(new String[] { "13-Apr-1940" });
	lookup.add(new String[] { "13-Apr-1941" });
	lookup.add(new String[] { "13-Apr-1942" });
	lookup.add(new String[] { "14-Apr-1943" });// 2000 Baisakh 1
	lookup.add(new String[] { "13-Apr-1944" });// 2001 Baisakh 1
	lookup.add(new String[] { "13-Apr-1945" });
	lookup.add(new String[] { "13-Apr-1946" });
	lookup.add(new String[] { "14-Apr-1947" });// 2004
	lookup.add(new String[] { "13-Apr-1948" });
	lookup.add(new String[] { "13-Apr-1949" });
	lookup.add(new String[] { "13-Apr-1950" });
	lookup.add(new String[] { "14-Apr-1951" });
	lookup.add(new String[] { "13-Apr-1952" });
	lookup.add(new String[] { "13-Apr-1953" });
	lookup.add(new String[] { "13-Apr-1954" });
	lookup.add(new String[] { "14-Apr-1955" });
	lookup.add(new String[] { "13-Apr-1956" });
	lookup.add(new String[] { "13-Apr-1957" });
	lookup.add(new String[] { "13-Apr-1958" });
	lookup.add(new String[] { "14-Apr-1959" });
	lookup.add(new String[] { "13-Apr-1960" });
	lookup.add(new String[] { "13-Apr-1961" });
	lookup.add(new String[] { "13-Apr-1962" });
	lookup.add(new String[] { "14-Apr-1963" });// 2020
	lookup.add(new String[] { "13-Apr-1964" });
	lookup.add(new String[] { "13-Apr-1965" });
	lookup.add(new String[] { "13-Apr-1966" });
	lookup.add(new String[] { "14-Apr-1967" });
	lookup.add(new String[] { "13-Apr-1968" });
	lookup.add(new String[] { "13-Apr-1969" });
	lookup.add(new String[] { "14-Apr-1970" });
	lookup.add(new String[] { "14-Apr-1971" });
	lookup.add(new String[] { "13-Apr-1972" });
	lookup.add(new String[] { "13-Apr-1973" });
	lookup.add(new String[] { "14-Apr-1974" });
	lookup.add(new String[] { "14-Apr-1975" });
	lookup.add(new String[] { "13-Apr-1976" });
	lookup.add(new String[] { "13-Apr-1977" });
	lookup.add(new String[] { "14-Apr-1978" });
	lookup.add(new String[] { "14-Apr-1979" });
	lookup.add(new String[] { "13-Apr-1980" });
	lookup.add(new String[] { "13-Apr-1981" });
	lookup.add(new String[] { "14-Apr-1982" });
	lookup.add(new String[] { "14-Apr-1983" });
	lookup.add(new String[] { "13-Apr-1984" });
	lookup.add(new String[] { "13-Apr-1985" });
	lookup.add(new String[] { "14-Apr-1986" });
	lookup.add(new String[] { "14-Apr-1987" });
	lookup.add(new String[] { "13-Apr-1988" });
	lookup.add(new String[] { "13-Apr-1989" });
	lookup.add(new String[] { "14-Apr-1990" });
	lookup.add(new String[] { "14-Apr-1991" });
	lookup.add(new String[] { "13-Apr-1992" });
	lookup.add(new String[] { "13-Apr-1993" });
	lookup.add(new String[] { "14-Apr-1994" });// 2051
	lookup.add(new String[] { "14-Apr-1995" });// 2052
	lookup.add(new String[] { "13-Apr-1996" });
	lookup.add(new String[] { "13-Apr-1997" });
	lookup.add(new String[] { "14-Apr-1998" });
	lookup.add(new String[] { "14-Apr-1999" });
	lookup.add(new String[] { "13-Apr-2000" });
	lookup.add(new String[] { "14-Apr-2001" });
	lookup.add(new String[] { "14-Apr-2002" });
	lookup.add(new String[] { "14-Apr-2003" });// 2060
	lookup.add(new String[] { "13-Apr-2004" });
	lookup.add(new String[] { "14-Apr-2005" });
	lookup.add(new String[] { "14-Apr-2005" });
	lookup.add(new String[] { "14-Apr-2007" });
	lookup.add(new String[] { "13-Apr-2008" });
	lookup.add(new String[] { "14-Apr-2009" });
	lookup.add(new String[] { "14-Apr-2010" });
	lookup.add(new String[] { "14-Apr-2011" });
	lookup.add(new String[] { "13-Apr-2012" });
	lookup.add(new String[] { "14-Apr-2013" });// 2070
	lookup.add(new String[] { "14-Apr-2014" });
	lookup.add(new String[] { "14-Apr-2015" });
	lookup.add(new String[] { "13-Apr-2016" });
	lookup.add(new String[] { "14-Apr-2017" });
	lookup.add(new String[] { "14-Apr-2018" });
	lookup.add(new String[] { "14-Apr-2019" });
	lookup.add(new String[] { "13-Apr-2020" });
	lookup.add(new String[] { "14-Apr-2021" });
	lookup.add(new String[] { "14-Apr-2022" });
	lookup.add(new String[] { "14-Apr-2023" });// 2080
	lookup.add(new String[] { "13-Apr-2024" });// 2081
	lookup.add(new String[] { "14-Apr-2025" });// 2082
	lookup.add(new String[] { "14-Apr-2026" });// 2083
	lookup.add(new String[] { "14-Apr-2027" });// 2084
	lookup.add(new String[] { "13-Apr-2028" });// 2085
	lookup.add(new String[] { "14-Apr-2029" });// 2086
	lookup.add(new String[] { "14-Apr-2030" });// 2087
	lookup.add(new String[] { "15-Apr-2031" });// 2088
	lookup.add(new String[] { "14-Apr-2032" });// 2089
	lookup.add(new String[] { "14-Apr-2033" });// 2090
	lookup.add(new String[] { "14-Apr-2034" });// 2091
	lookup.add(new String[] { "13-Apr-2035" });// 2092
	lookup.add(new String[] { "14-Apr-2036" });// 2093
	lookup.add(new String[] { "14-Apr-2037" });// 2094
	lookup.add(new String[] { "14-Apr-2038" });// 2095
	lookup.add(new String[] { "15-Apr-2039" });// 2096
	lookup.add(new String[] { "13-Apr-2040" });// 2097
	lookup.add(new String[] { "14-Apr-2041" });// 2098
	lookup.add(new String[] { "14-Apr-2042" });// 2099
	lookup.add(new String[] { "14-Apr-2043" });// 2100
    };
    /*
     * number of days in each month for subsequent years we need to extend this
     * year adding more entries
     */
    public static ArrayList<Integer[]> monthDays = new ArrayList<Integer[]>();
    static {
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1970
	monthDays.add(new Integer[] { 31, 31, 32, 31, 32, 30, 30, 29, 30, 29,
		30, 30 });// 1971
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 30 });// 1972
	monthDays.add(new Integer[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });// 1973
	monthDays.add(new Integer[] { 31, 31, 32, 30, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1974
	monthDays.add(new Integer[] { 31, 31, 32, 32, 30, 31, 30, 29, 30, 29,
		30, 30 });// 1975
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });// 1976
	monthDays.add(new Integer[] { 30, 32, 31, 32, 31, 31, 29, 30, 29, 30,
		29, 31 });// 1977
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1978
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });// 1979
	monthDays.add(new Integer[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });// 1980
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
		30, 30 });// 1981
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1982
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });// 1983
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });// 1984
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
		30, 30 });// 1985
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1986
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });// 1987
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });// 1988
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1989
	monthDays.add(new Integer[] { 30, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1990
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });// 1991
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 30 });// 1992
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1993
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1994
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1995
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1996
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1997
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1998
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });// 1999
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		29, 31 });// 2000
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 2001
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });// 2002 366 days
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 2025
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 32, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 30, 32, 31, 32, 31, 31, 29, 30, 30, 29,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 2036
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 }); // 2041
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 2048
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });// 2052
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 32, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });// 2060
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 30, 32, 31, 32, 31, 31, 29, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
		30, 30 });// 2070
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		29, 31 });
	monthDays.add(new Integer[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
		30, 30 });
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
		30, 30 });// 2080
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2081
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2082
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2083
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2084
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 31, 30, 30, 29, 30,
		30, 30 });// 2085
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2086
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 30, 29, 30,
		30, 30 });// 2087
	monthDays.add(new Integer[] { 30, 31, 32, 32, 30, 31, 30, 30, 29, 30,
		30, 30 });// 2088
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2089
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2090
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 30, 29, 30,
		30, 30 });// 2091
	monthDays.add(new Integer[] { 31, 31, 32, 32, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2092
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2093
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2094
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 30,
		30, 30 });// 2095
	monthDays.add(new Integer[] { 30, 31, 32, 32, 31, 30, 30, 29, 30, 29,
		30, 30 });// 2096
	monthDays.add(new Integer[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
		30, 30 });// 2097
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 29, 30, 29, 30,
		30, 31 });// 2098
	monthDays.add(new Integer[] { 31, 31, 32, 31, 31, 31, 30, 29, 29, 30,
		30, 30 });// 2099
	monthDays.add(new Integer[] { 31, 32, 31, 32, 30, 31, 30, 29, 30, 29,
		30, 30 });// 2100
    };
}
