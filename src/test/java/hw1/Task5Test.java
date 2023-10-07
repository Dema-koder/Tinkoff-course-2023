package hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import static hw1.Task5.buildNewNumber;
import static hw1.Task5.isPalindrome;
import static hw1.Task5.isValidNumber;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    @DisplayName("Основной функционал")
    void isPalindromeDescendantTest() {
        assertEquals(true, Task5.isPalindromeDescendant(11211230));
        assertEquals(true, Task5.isPalindromeDescendant(13001120));
    }

    @Test
    @DisplayName("Проверка на корректность числа")
    void isValidNumberTest() {
        Integer num = 5;
        assertEquals(false, isValidNumber(num));
    }

    @Test
    @DisplayName("Проверка на палиндром")
    void isPalindromeTest() {
        for (int j = 0; j < 1000; j++) {
            Random random = new Random();
            Integer num = random.nextInt(10000);
            String s = num.toString();
            char[] t = new char[s.length()];
            for (int i = s.length() - 1; i >= 0; i--)
                t[s.length() - 1 - i] = s.charAt(i);
            String tt = new String(t);
            String res = s + tt;
            num = Integer.parseInt(res);
            assertEquals(true, isPalindrome(num));
        }
    }

    @Test
    @DisplayName("Проверка корректности нового построенного числа")
    void buildNewNumberTest() {
        Integer num = 999999;
        Integer res = 181818;
        assertEquals(res, buildNewNumber(num));
    }
}
