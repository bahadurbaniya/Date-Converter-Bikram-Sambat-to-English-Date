package np.com.bahadur.converter.date.nepali;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * Class tests Bikram Sambat to gregorian date converter functionality
 * todo move it to tests instead of manual ones.
 */
public class DateConverterTestBed {
    private static Logger logger = LoggerFactory.getLogger(DateConverter.class);

    public static void main(String[] args) throws Exception {
        System.out.println("*******************************************************************************************");
        System.out.println("BS to AD Converter supports "
                + Lookup.lookupNepaliYearStart + "-"
                + (Lookup.lookupNepaliYearStart + Lookup.monthDays.size() - 1));
        System.out
                .println("Further Nepali years can be added looking up online calendar. Add lookup in Lookup.java.");
        System.out.println("One English equivalent date and ");
        System.out
                .println("number of days in each Nepali month for each Nepali Year is needed as a lookup.");
        System.out.println("**************************************************************************************");
        System.out.println("");

        // AD to BS conversion sample
        DateConverter dc = new DateConverter();
        String adDate = "20-06-1982";
        System.out.printf("AD %s = BS %s \n",adDate, dc.convertAdToBs(adDate));

        // BS to AD conversion sample
        String bsDate =  "06032039";
        System.out.printf("AD %s = BS %s \n",dc.convertBsToAd(bsDate),bsDate);


        /// BS to AD conversion manual prompt
        while (true) {
            System.out.print(String.format("Provide Bikram Sambat Input Date (%s) ? ", DateConverter.DEFAULT_FORMAT));
            Scanner s;
            Date ad;
            s = new Scanner(System.in);
            try {
                bsDate = s.next();
                if (dc.matchFormat(bsDate)) {
                    ad = dc.convertBsToAd(bsDate);
                    DateFormat df = new SimpleDateFormat("MMM/dd/yyyy");

                    System.out.println(bsDate + " BS is conversion of  " + df.format(ad) + " AD");
                } else {
                    logger.error("Incorrect Bikram Sambat date format.");
                }
            } catch (Exception e) {
                logger.error("error occurred", e);
            }
            System.out.print("Do you want to retry?  Y/N : ");
            String retry = s.next();
            if (!retry.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }
}
