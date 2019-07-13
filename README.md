# Overview
Converts Nepali Date (Bikram Sambat (BS)) provided to English equivalent date (AD).


Nepali Calendar does not have constant month days as English date has. It keeps on changing we can not create any algorithm and find what will be days for certain Nepali year and month. I hope some Panchang maker might come with infinite calendar years for Nepali Calendar. For now, we have to use lookup table when converting Nepali date to English date.

We have to find mapping of first day of Bikram Sambat (BS)'s year to equivalent Gregorian date. Do this for every Nepali year you want to convert e.g. 2001 Baisakh 1 "13-Apr-1944" ......... .... 2068 Baisakh 1 "14-Apr-2011"

To know all the number of days in each month
Following URLs can be helpful. 

* http://nepalicalendar.rat32.com/
* http://www.nepalicalendar.com/
* http://nepalipatro.com.np/
* http://www.ashesh.com.np/nepali-calendar

Steps involved in BS to AD conversion: 
1. If we need to convert 2001 Ashar 6, find number of days elapsed since start of Bikram Sambat year(2001 Baisakh 1).
      1. Ashar is 3rd month(Baisakh, Jestha, Ashar) of BS as depicted in table. So number of days passed is 31+31+6-1 = 67(number of days in Baisakh+number of days in Jestha+month_of_day-1). Where month_of_day is day of month which needs conversion. 1 is subtracted as Baisakh 1 has already included.
      2. Add number of days elapsed to Gregorian equivalent date (13 April 1944) eg (13 April 1944)+67=19 June 1944. Which is correctly converted Gregorian date of 2001 Ashar 6.

About Bikram Sambat: 
* https://en.wikipedia.org/wiki/Bikram_Sambat

# Technical 
This is Maven project. Import project in your favourite IDE using pom.xml. 

# Use 
## AD to BS conversion sample
        DateConverter dc = new DateConverter();
        System.out.println(dc.convertAdToBs("20-06-1982"));

 ## BS to AD conversion sample
        DateConverter dc = new DateConverter();
        System.out.println(dc.convertBsToAd("06-03-2038"));
        
 ## Run Maven goal below for demo 
        
        mvn exec:java


# Run instructions 
    
Generate JAR
    
    mvn clean package  
    
Run only test 
    
    mvn test 
     
Execute class 
    
    java -jar target/NepaliDateConverter-1.0-SNAPSHOT.jar 
or 
   
    mvn exec:java
    
# Usage instructions 
    mvn clean install 
 
Use installed jar in .m2 folder as  a dependency  