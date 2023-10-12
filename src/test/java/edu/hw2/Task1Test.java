package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    @DisplayName("Проверка экспоненты")
    void exponentTest() {
        Expr exponent = new Expr.Exponent(3, 4);
        assertEquals(81, exponent.evaluate());
    }
}
