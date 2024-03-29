# README

## Build Tracker
[![Java CI](https://github.com/bahadurbaniya/Date-Converter-Bikram-Sambat-to-English-Date/actions/workflows/maven.yml/badge.svg)](https://github.com/bahadurbaniya/Date-Converter-Bikram-Sambat-to-English-Date/actions/workflows/maven.yml)

## Overview
Converts Nepali Date (Bikram Sambat (BS)) provided to English equivalent date(AD)/Gregorian Date.

Nepali calendar does not have constant month lengths like the English calendar. The number of days in a month keeps changing, so we cannot create an algorithm to find the number of days in a particular Nepali month and year. I hope that a Nepali Calendar maker can create an infinite calendar for the Nepali calendar. For now, we have to use a lookup table when converting Nepali dates to English dates.

We have to find mapping of first day of Bikram Sambat (BS)'s year to equivalent Gregorian date. Do this for every Nepali year you want to convert e.g. 2001 Baisakh 1 "13-Apr-1944" ……… …. 2068 Baisakh 1 "14-Apr-2011"

To know all the number of days in each month Following URLs can be helpful.

- http://nepalicalendar.rat32.com/
- http://www.nepalicalendar.com/
- http://nepalipatro.com.np/
- http://www.ashesh.com.np/nepali-calendar

Steps involved in BS to AD conversion:
1. If we need to convert 2001 Ashar 6, find number of days elapsed since start of Bikram Sambat year(2001 Baisakh 1).

2. Ashar is 3rd month(Baisakh, Jestha, Ashar) of BS as depicted in table. So number of days passed is 31+31+6-1 = 67(number of days in Baisakh+number of days in Jestha+month_of_day-1). Where month_of_day is day of month which needs conversion. 1 is subtracted as Baisakh 1 has already included.

3. Add number of days elapsed to Gregorian equivalent date (13 April 1944) eg (13 April 1944)+67=19 June 1944. Which is correctly converted Gregorian date of 2001 Ashar 6.

About Bikram Sambat: * https://en.wikipedia.org/wiki/Bikram_Sambat

## Questions

```bash
Why Nepali year 1974 has total days 364 instead of 365 days?
Why Nepali year 1976 has total days 366 instead of 365 days?
Why Nepali year 1984 has total days 366 instead of 365 days?
Why Nepali year 1988 has total days 366 instead of 365 days?
Why Nepali year 1990 has total days 364 instead of 365 days?
Why Nepali year 2003 has total days 366 instead of 365 days?
Why Nepali year 2007 has total days 366 instead of 365 days?
Why Nepali year 2011 has total days 366 instead of 365 days?
Why Nepali year 2015 has total days 366 instead of 365 days?
Why Nepali year 2019 has total days 366 instead of 365 days?
Why Nepali year 2023 has total days 366 instead of 365 days?
Why Nepali year 2026 has total days 366 instead of 365 days?
Why Nepali year 2030 has total days 366 instead of 365 days?
Why Nepali year 2034 has total days 366 instead of 365 days?
Why Nepali year 2038 has total days 366 instead of 365 days?
Why Nepali year 2042 has total days 366 instead of 365 days?
Why Nepali year 2046 has total days 366 instead of 365 days?
Why Nepali year 2050 has total days 366 instead of 365 days?
Why Nepali year 2054 has total days 366 instead of 365 days?
Why Nepali year 2057 has total days 366 instead of 365 days?
Why Nepali year 2061 has total days 366 instead of 365 days?
Why Nepali year 2065 has total days 366 instead of 365 days?
Why Nepali year 2069 has total days 366 instead of 365 days?
Why Nepali year 2073 has total days 366 instead of 365 days?
Why Nepali year 2077 has total days 366 instead of 365 days?
Why Nepali year 2081 has total days 366 instead of 365 days?
Why Nepali year 2082 has total days 366 instead of 365 days?
Why Nepali year 2085 has total days 367 instead of 365 days?
Why Nepali year 2086 has total days 366 instead of 365 days?
Why Nepali year 2087 has total days 366 instead of 365 days?
Why Nepali year 2089 has total days 366 instead of 365 days?
Why Nepali year 2090 has total days 366 instead of 365 days?
Why Nepali year 2091 has total days 366 instead of 365 days?
Why Nepali year 2092 has total days 366 instead of 365 days?
Why Nepali year 2093 has total days 366 instead of 365 days?
Why Nepali year 2095 has total days 366 instead of 365 days?
Why Nepali year 2096 has total days 364 instead of 365 days?
Why Nepali year 2097 has total days 366 instead of 365 days?
Why Nepali year 2098 has total days 366 instead of 365 days?
```

## Technical

This is Maven project. Import project in your favourite IDE using pom.xml.

## Run Instructions

Run only tests
```bash
$ mvn test
```
Run main class ```np.com.bahadur.converter.date.nepali.DateConverterTestBed.main``` with command below
```bash
$ mvn exec:java
```

## Usage Instruction

1. > JDK_Version >= JDK 1.8

### Manual Installation

1. Clone https://github.com/bahadurbaniya/Date-Converter-Bikram-Sambat-to-English-Date/

2. Run command below to install jar locally in maven repository mvn clean install

3. Now code could be used as shown below on Sample Code to use library


### Use JAR deployed in GitHub Packages

1. AR is also hosted on https://github.com/bahadurbaniya/Date-Converter-Bikram-Sambat-to-English-Date/packages/ Follow instructions from here and here to use GitHub Packages.
2. After following step 1, JAR should be in "%USERPROFILE%\.m2\repository\np\com\bahadur\converter\date\nepali\NepaliEnglishDateConverter\0.0.1\NepaliEnglishDateConverter-0.0.1.jar" (Windows) "~\.m2\repository\np\com\bahadur\converter\date\nepali\NepaliEnglishDateConverter\0.0.1\NepaliEnglishDateConverter-0.0.1.jar" (Linux).
3. Now code could be used as shown below on [Sample Code to use library](#sample-code-to-use-library)

## Sample Code to use library

Write following code in project that wants to use jar imported/generated.

1. Use installed JAR in maven .m2 folder as a dependency, adding dependency below

```bash
<dependency>
    <groupId>np.com.bahadur.converter.date.nepali</groupId>
    <artifactId>NepaliEnglishDateConverter</artifactId>
    <version>0.0.1</version>
   </dependency>
```

### AD to BS conversion sample
```bash
DateConverter dc = new DateConverter();
System.out.println(dc.convertAdToBs("20-06-1982"));
```


### BS to AD conversion sample

```bash
DateConverter dc = new DateConverter();
System.out.println(dc.convertBsToAd("06-03-2038"));
```
