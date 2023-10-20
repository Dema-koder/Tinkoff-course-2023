package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.hw2.Expr.*;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    @DisplayName("Проверка экспоненты")
    void exponentTest() {
        Expr exponent = new Exponent(3, 4);
        assertEquals(81, exponent.evaluate());
    }

    @Test
    @DisplayName("Проверка суммы")
    void additionTest() {
        Expr addition = new Addition(5, 6);
        assertEquals(11, addition.evaluate());
    }

    @Test
    @DisplayName("Проверка отрицательного числа")
    void negateTest() {
        Expr negate = new Negate(8);
        assertEquals(-8, negate.evaluate());
    }

    @Test
    @DisplayName("Проверка умножения")
    void multiplicationTest() {
        Expr multiplication = new Multiplication(4, 5);
        assertEquals(20, multiplication.evaluate());
    }
}
