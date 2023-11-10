package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void correctPasswordTest() {
        var ans = Task4.isValidPassword("user@username");
        assertTrue(ans);
    }

    @Test
    void incorrectPasswordTest() {
        var ans = Task4.isValidPassword("userusername");
        assertFalse(ans);
    }
}
