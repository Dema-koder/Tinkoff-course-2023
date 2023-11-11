package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @Test
    void isValidString1Test() {
        var ans = Task8.isValidString1("000");
        assertTrue(ans);
    }

    @Test
    void isValidString2Test() {
        var ans = Task8.isValidString2("010");
        var ans2 = Task8.isValidString2("1000");
        assertTrue(ans2);
        assertTrue(ans);
    }

    @Test
    void isValidString3Test() {
        var ans = Task8.isValidString3("0000001");
        assertTrue(ans);
    }

    @Test
    void isValidString4Test() {
        var ans = Task8.isValidString4("110");
        assertTrue(ans);
    }

    @Test
    void isValidString5Test() {
        var ans = Task8.isValidString5("11111");
        assertTrue(ans);
    }

    @Test
    void isValidString6Test() {
        var ans = Task8.isValidString6("00010");
        assertTrue(ans);
    }

    @Test
    void isValidString7Test() {
        var ans = Task8.isValidString7("1010010101000010101010000010001");
        assertTrue(ans);
    }
}
