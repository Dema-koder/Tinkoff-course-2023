package edu.hw1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("hideutilityclassconstructor")
public class Task3 {
    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        LOGGER.info("Read the input data");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Long[] arr1 = new Long[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextLong();
        }
        int m = scanner.nextInt();
        Long[] arr2 = new Long[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextLong();
        }
        LOGGER.info("Answer: " + isNested(arr1, arr2));
    }

    static boolean isNested(Long[] arr1, Long[] arr2) {
        Long minOfArray1 = Arrays.stream(arr1).min(Comparator.naturalOrder()).get();
        Long minOfArray2 = Arrays.stream(arr2).min(Comparator.naturalOrder()).get();
        Long maxOfArray1 = Arrays.stream(arr1).max(Comparator.naturalOrder()).get();
        Long maxOfArray2 = Arrays.stream(arr2).max(Comparator.naturalOrder()).get();
        return minOfArray1 > minOfArray2 && maxOfArray1 < maxOfArray2;
    }
}
