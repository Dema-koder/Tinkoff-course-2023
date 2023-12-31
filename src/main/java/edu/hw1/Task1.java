package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"hideutilityclassconstructor", "constantname", "uncommentedmain", "returncount"})
public class Task1 {
    private static final long QUANTITY_SEC_IN_MIN = 60;
    private static final Integer NEEDED_LEN = 2;
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        LOGGER.info("Read the string: " + str);
        LOGGER.info("Answer: " + minutesToSeconds(str));
    }

    static boolean checkCorrectnessOfString(String str) {
        LOGGER.info("Check correctness of the string: " + str);
        String[] parseString = str.split(":");
        if (parseString.length != NEEDED_LEN) {
            LOGGER.error("No colon or many of them");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            }
            if (str.charAt(i) != ':') {
                LOGGER.error("The string contains incorrect characters");
                return false;
            }
        }
        if (Long.parseLong(parseString[1]) > QUANTITY_SEC_IN_MIN) {
            LOGGER.error("Incorrect quantity of seconds");
            return false;
        }
        Long mx = (Long.MAX_VALUE - Long.parseLong(parseString[1])) / QUANTITY_SEC_IN_MIN;
        String mxStr = mx.toString();
        if ((parseString[0].length() > mxStr.length())
            || (parseString[0].length() == mxStr.length() && parseString[0].compareTo(mxStr) > 0)) {
            LOGGER.error("Quantity of seconds is higher than variable type long");
            return false;
        }
        LOGGER.info("The string is correct");
        return true;
    }

    static long minutesToSeconds(String s) {
        if (!checkCorrectnessOfString(s)) {
            LOGGER.error("Incorrect string");
            return -1;
        }
        String[] parseString = s.split(":");
        long minutes = Long.parseLong(parseString[0]);
        long seconds = Long.parseLong(parseString[1]);
        return minutes * QUANTITY_SEC_IN_MIN + seconds;
    }
}
