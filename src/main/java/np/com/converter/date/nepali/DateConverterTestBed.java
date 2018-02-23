package np.com.converter.date.nepali;
/*
 * @(#)DateConverterTest.java	 09/11/2010
 *
 *
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * Class tests Bikram Sambat to gregorian date converter functionalities
 * @author bahadur baniya
 * 
 */
public class DateConverterTestBed {
	public static void main(String[] args) {
		System.out.println("**************************************************************");
		System.out.println(" BS to AD Converter supports "
				+ Lookup.lookupNepaliYearStart + "-"
				+ (Lookup.lookupNepaliYearStart + Lookup.monthDays.size() - 1));
		System.out
				.println("We can add further nepali years looking up online calendar. ");
		System.out.println("We need only equivalent one english date and ");
		System.out
				.println("nepali month days for each nepali Year as a lookup");
		System.out.println("***********************************************************************");
		while (true) {
			System.out.print(String.format("Provide Bikram Sambat Input Date (%s) ? ",DateConverter.DEFAULT_FORMAT));
			Scanner s;
			String bsDate;
			Date ad;
			s = new Scanner(System.in);
			try {
				bsDate = s.next();
				DateConverter dc = new DateConverter();
				if (dc.matchFormat(bsDate)) {
					ad = dc.convertBsToAd(bsDate);
					DateFormat df = new SimpleDateFormat("MMM/dd/yyyy");

					System.out.println(bsDate + " BS is conversion of  " + df.format(ad) + " AD");
				}else{
					System.err.println("Incorrect Bikram Sambat date format");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print("Do you want to retry?  Y/[*]: ");
			String retry = s.next();
			if (!retry.equalsIgnoreCase("Y")) {
				break;
			}
		}
	}
}
