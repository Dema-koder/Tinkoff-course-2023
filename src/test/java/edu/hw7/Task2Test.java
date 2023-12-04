package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("Main test")
    void test1() {
        var ans = Task2.multiThreadingFactorial(6);
        assertEquals(720, ans);
    }
}
