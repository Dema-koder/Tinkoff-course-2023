package edu.hw1;

import edu.hw1.Task6;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    @DisplayName("Основной функционал")
    void countKTEst() {
        assertEquals(3, Task6.countK(3524));
    }

    @Test
    @DisplayName("Возрасатющий порядок")
    void ascendingOrderTest() {
        assertEquals(378, Task6.ascendingOrder(8073));
        assertEquals(1234, Task6.ascendingOrder(4231));
    }

    @Test
    @DisplayName("Убывающий порядок")
    void descendingOrderTEst() {
        assertEquals(8730, Task6.descendingOrder(7038));
        assertEquals(4321, Task6.descendingOrder(3241));
    }

    @Test
    @DisplayName("Провекра корректности числа")
    void isValidNumberTest() {
        assertEquals(false, Task6.isValidNumber(6666));
        assertEquals(true, Task6.isValidNumber(1234));
        assertEquals(false, Task6.isValidNumber(12345));
    }
}
