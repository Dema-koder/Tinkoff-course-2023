package hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Task4 {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        LOGGER.info("Read string " + str);
        LOGGER.info("Result string: " + fixString(str));
    }

    static String fixString(String str) {
        char[] charArr = str.toCharArray();
        for (int i = 0; i < str.length(); i+=2) {
            if (i != str.length() - 1) {
                char temp = charArr[i];
                charArr[i] = charArr[i + 1];
                charArr[i + 1] = temp;
            }
        }
        String ans = charArr.toString();
        return ans;
    }
}
