package hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Task4 {
    private static final Logger LOGGER = LogManager.getLogger();

    static String fixString(String str) {
        char[] charArr = str.toCharArray();
        for (int i = 0; i < str.length(); i+=2) {
            if (i != str.length() - 1) {
                char temp = charArr[i];
                charArr[i] = charArr[i + 1];
                charArr[i + 1] = temp;
            }
        }
        String ans = new String(charArr);
        return ans;
    }
}
