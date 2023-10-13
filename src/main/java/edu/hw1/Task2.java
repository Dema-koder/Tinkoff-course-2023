package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"uncommentedmain", "hideutilityclassconstructor"})
public class Task2 {
    private static final Integer DIGIT_BASE = 10;
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long num = scanner.nextLong();
        LOGGER.info("Read the number " + num);
        LOGGER.info(countDigits(num));
    }

    static int countDigits(Long num) {
        LOGGER.info("Take the number " + num);
        Long num2 = Math.abs(num);
        int count = 0;
        while (num2 > 0) {
            count++;
            num2 /= DIGIT_BASE;
        }
        return count;
    }
}
