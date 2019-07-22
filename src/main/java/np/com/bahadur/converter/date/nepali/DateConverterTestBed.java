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
    private static Logger logger = LoggerFactory.getLogger(DateConverterTestBed.class);

    public static void main(String[] args) throws Exception {
        logger.info("*******************************************************************************************");
        logger.info("BS to AD Converter supports {} - {} "
                , Lookup.lookupNepaliYearStart,
                (Lookup.lookupNepaliYearStart + Lookup.monthDays.size() - 1));
        logger.info("Further Nepali years can be added looking up online calendar. Add lookup in Lookup.java.");
        logger.info("One English equivalent date and ");
        logger.info("number of days in each Nepali month for each Nepali Year is needed as a lookup.");
        logger.info("**************************************************************************************");
        logger.info("");

        // AD to BS conversion sample
        DateConverter dc = new DateConverter();
        String adDate = "20-06-1982";
        if (logger.isInfoEnabled())
            logger.info("AD {} = BS {}", adDate, dc.convertAdToBs(adDate));

        if (logger.isInfoEnabled()) {
            adDate = "17-10-1981";
            logger.info("AD {} = BS {}", adDate, dc.convertAdToBs(adDate));
        }
        // BS to AD conversion sample
        String bsDate = "06032039";
        logger.info("AD {} = BS {} \n", dc.convertBsToAd(bsDate), bsDate);


        /// BS to AD conversion manual prompt
        while (true) {
            logger.info("Provide Bikram Sambat Input Date {}?", DateConverter.DEFAULT_FORMAT);
            Scanner s;
            Date ad;
            s = new Scanner(System.in);
            try {
                bsDate = s.next();
                if (dc.matchFormat(bsDate)) {
                    ad = dc.convertBsToAd(bsDate);
                    DateFormat df = new SimpleDateFormat("MMM/dd/yyyy");
                    if (logger.isInfoEnabled())
                        logger.info(" {}  BS is conversion of {} AD ", bsDate, df.format(ad));
                } else {
                    logger.error("Incorrect Bikram Sambat date format.");
                }
            } catch (Exception e) {
                logger.error("error occurred", e);
            }
            System.out.print("Do you want to retry?  Y/N: ");
            String retry = s.next();
            if (!retry.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }
}
