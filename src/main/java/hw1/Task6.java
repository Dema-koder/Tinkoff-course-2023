package hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Comparator;

public class Task6 {

    private static final Logger LOGGER = LogManager.getLogger();

    public static int countK(Integer num) {
        if (!isValidNumber(num))
            return -1;
        int ans = 0;
        while (true) {
            ans++;
            int num2 = ascendingOrder(num);
            int num1 = descendingOrder(num);
            LOGGER.info(num + " : " + num1 + " - " + num2 + " = " + (num1 - num2));
            num = num1 - num2;
            if (num.equals(6174))
                return ans;
        }
    }

    static boolean isValidNumber(Integer num) {
        String res = num.toString();
        if (res.length() != 4)
            return false;
        boolean ok = false;
        for (int i = 0; i < res.length(); i++)
            for (int j = 0; j < res.length(); j++)
                if (res.charAt(i) != res.charAt(j))
                    ok = true;
        return ok;
    }

    static Integer ascendingOrder(Integer num) {
        LOGGER.info("Получили число " + num);
        Integer[] nums = new Integer[4];
        int k = 0;
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

    static Integer descendingOrder(Integer num) {
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
