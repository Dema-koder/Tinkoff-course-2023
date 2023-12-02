package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    @DisplayName("Main Test")
    void averageTimeTest() {
        String ans = Task1.averageTime(List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        ));
        assertEquals("3ч 40м", ans);
    }

    @Test
    @DisplayName("Некорректные строки")
    void incorrectStringsTest() {
        String ans = Task1.averageTime(List.of(
            "2020-03-12, 25:67 - 2020-03-kslclksmcls"
        ));
    }
}
