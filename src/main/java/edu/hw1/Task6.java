package edu.hw1;

import java.util.Arrays;
import java.util.Comparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("hideutilityclassconstructor")
public class Task6 {

    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("magicnumber")
    public static int countK(Integer num) {
        if (!isValidNumber(num)) {
            return -1;
        }
        int ans = 0;
        Integer num3 = num;
        while (true) {
            ans++;
            int num2 = ascendingOrder(num3);
            int num1 = descendingOrder(num3);
            LOGGER.info(num + " : " + num1 + " - " + num2 + " = " + (num1 - num2));
            num3 = num1 - num2;
            if (num3.equals(6174)) {
                return ans;
            }
        }
    }

    @SuppressWarnings("magicnumber")
    static boolean isValidNumber(Integer num) {
        String res = num.toString();
        if (res.length() != 4) {
            return false;
        }
        boolean ok = false;
        for (int i = 0; i < res.length(); i++) {
            for (int j = 0; j < res.length(); j++) {
                if (res.charAt(i) != res.charAt(j)) {
                    ok = true;
                }
            }
        }
        return ok;
    }

    @SuppressWarnings("magicnumber")
    static Integer ascendingOrder(Integer cur) {
        LOGGER.info("Получили число :" + cur);
        Integer[] nums = new Integer[4];
        int k = 0;
        Integer num = cur;
        for (int i = 0; i < 4; i++) {
            nums[k] = num % 10;
            k++;
            num /= 10;
        }
        Arrays.sort(nums);
        k = 1;
        Integer ans = 0;
        for (int i = 3; i >= 0; i--) {
            ans += k * nums[i];
            k *= 10;
        }
        LOGGER.info("Ответ " + ans);
        return ans;
    }

    @SuppressWarnings("magicnumber")
    static Integer descendingOrder(Integer cur) {
        Integer num = cur;
        LOGGER.info("Получили число " + num);
        Integer[] nums = new Integer[4];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            nums[k] = num % 10;
            k++;
            num /= 10;
        }
        Arrays.sort(nums, Comparator.reverseOrder());
        k = 1;
        Integer ans = 0;
        for (int i = 3; i >= 0; i--) {
            ans += k * nums[i];
            k *= 10;
        }
        LOGGER.info("Число в убывающем порядке: " + ans);
        return ans;
    }
}
