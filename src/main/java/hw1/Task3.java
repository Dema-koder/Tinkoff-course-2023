package hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("Read the input data");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Long[] arr1 = new Long[n];
        for (int i = 0; i < n; i++)
            arr1[i] = scanner.nextLong();
        int m = scanner.nextInt();
        Long[] arr2 = new Long[m];
        for (int i = 0; i < m; i++)
            arr2[i] = scanner.nextLong();
        LOGGER.info("Answer: " + isNested(arr1, arr2));
    }

    static Long minOfArray(Long[] arr) {
        LOGGER.info("Find minimum in " + Arrays.toString(arr));
        long ans = Long.MAX_VALUE;
        for (Long aLong : arr) ans = Math.min(ans, aLong);
        LOGGER.info("Minimum is equal " + ans);
        return ans;
    }

    static Long maxOfArray(Long[] arr) {
        LOGGER.info("Find maximum in " + Arrays.toString(arr));
        long ans = Long.MIN_VALUE;
        for (Long aLong : arr) ans = Math.max(ans, aLong);
        LOGGER.info("Maximum is equal " + ans);
        return ans;
    }

    static boolean isNested(Long[] arr1, Long[] arr2) {
        return minOfArray(arr1) > minOfArray(arr2) && maxOfArray(arr1) < maxOfArray(arr2);
    }
}
