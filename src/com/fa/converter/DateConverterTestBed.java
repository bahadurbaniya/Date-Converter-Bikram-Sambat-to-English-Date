package com.fa.converter;
/*
 * @(#)DateConverterTest.java	 09/11/2010
 *
 *
 */
import static com.fa.converter.Lookup.lookupNepaliYearStart;
import static com.fa.converter.Lookup.monthDays;

import java.util.Date;
import java.util.Scanner;


/**
 * Class tests bikram sambat to gregorian date converter functionalities
 * @author bahadur baniya
 * 
 */
public class DateConverterTestBed {
	public static void main(String[] args) {
		System.out.println("*******************************");
		System.out.println(" BS to AD Converter supports "
				+ lookupNepaliYearStart + "-"
				+ (lookupNepaliYearStart + monthDays.size() - 1));
		System.out
				.println("We can add further nepali years looking up online calendar. ");
		System.out.println("We need only equivalent one english date and ");
		System.out
				.println("nepali month days for each nepali Year as a lookup");
		System.out.println("*******************************");
		while (true) {
			System.out.println("Provide BS input date in mm-dd-yyyy ");
			Scanner s;
			String bsDate;
			Date ad;
			s = new Scanner(System.in);
			try {
				bsDate = s.next();
				DateConverter dc = new DateConverter();
				if (dc.matchFormat(bsDate)) {
					ad = dc.convertBsToAd(bsDate);
					System.out.println(bsDate + " BS : " + ad + " AD");
				}else{
					System.err.println("incorrect BS date format");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to retry?Y/[*]");
			String retry = s.next();
			if (!retry.equalsIgnoreCase("Y")) {
				break;
			}
		}
	}
}
