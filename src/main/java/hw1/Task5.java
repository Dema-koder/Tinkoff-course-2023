package hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task5 {

    private static final Logger LOGGER = LogManager.getLogger();

    public static boolean isPalindromeDescendant(Integer num) {
        while (true) {
            if (!isValidNumber(num)) {
                LOGGER.error("This is not palindrome descendant");
                return false;
            }
            if (isPalindrome(num))
                return true;
            num = buildNewNumber(num);
        }
    }

    static boolean isValidNumber(Integer num) {
        LOGGER.info("Check that " + num + " is valid number");
        String s = num.toString();
        if (s.length() % 2 == 1)
            return false;
        return true;
    }

    static boolean isPalindrome(Integer num) {
        LOGGER.info("Check the number: " + num + " on palindrome");
        String s = num.toString();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                LOGGER.error("Not palindrome");
                return false;
            }
            i++; j--;
        }
        LOGGER.info("Correct palindrome");
        return true;
    }

    static Integer buildNewNumber(Integer num) {
        LOGGER.info("Build new number from number " + num);
        String s = num.toString();
        String t = new String();
        for (int i = 0; i < s.length(); i+=2) {
            int x = s.charAt(i) - '0';
            int y = s.charAt(i + 1) - '0';
            Integer sum = x + y;
            String nw = sum.toString();
            t += nw;
        }
        LOGGER.info("New number: " + t);
        Integer ans = Integer.parseInt(t);
        return ans;
    }
}
