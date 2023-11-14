package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    @DisplayName("Проверяем корректность конвертирования")
    void convertToRomanTest() {
        Task4 task = new Task4();
        assertEquals("II", task.convertToRoman(2));
        assertEquals("XII", task.convertToRoman(12));
        assertEquals("XVI", task.convertToRoman(16));
        assertThrows(IllegalArgumentException.class, () -> {
            task.convertToRoman(123242);
        });
    }

    @Test
    @DisplayName("Проверка проверки корректности)")
    void checkTest() {
        Task4 task = new Task4();
        assertTrue(task.checkArabianNumber("1234"));
        assertFalse(task.checkArabianNumber("12345"));
        assertFalse(task.checkArabianNumber("ABCD"));
        assertFalse(task.checkArabianNumber("12d4"));
    }
}
