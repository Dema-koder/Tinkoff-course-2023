package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void isValidString1Test() {
        var ans = Task7.isValidString1("0000000");
        assertTrue(ans);
    }

    @Test
    void isValidString2Test() {
        var ans = Task7.isValidString2("0000000");
        assertTrue(ans);
    }

    @Test
    void isValidString3Test() {
        var ans = Task7.isValidString3("00");
        assertTrue(ans);
    }
}
