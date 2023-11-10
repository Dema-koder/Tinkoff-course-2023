package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void correctNumberTest() {
        var ans = Task5.isValidNumber("О777ОО177");
        assertTrue(ans);
    }

    @Test
    void correctNumberTest1() {
        var ans = Task5.isValidNumber("А123ВЕ777");
        assertTrue(ans);
    }

    @Test
    void incorrectNumberTest() {
        var ans = Task5.isValidNumber("123АВЕ777");
        assertFalse(ans);
    }

    @Test
    void incorrectNumberTest1() {
        var ans = Task5.isValidNumber("А123ВГ77");
        assertFalse(ans);
    }

    @Test
    void incorrectNumberTest2() {
        var ans = Task5.isValidNumber("А123ВЕ7777");
        assertFalse(ans);
    }
}
