package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    @DisplayName("first test")
    void firstTest() {
        var ans = Task3.parseDate("2020-10-10");
        assertEquals(Optional.of(LocalDate.of(2020, 10, 10)), ans);
    }

    @Test
    @DisplayName("second test")
    void secondTest() {
        var ans = Task3.parseDate("2020-12-2");
        assertEquals(Optional.of(LocalDate.of(2020, 12, 2)), ans);
    }

    @Test
    @DisplayName("third test")
    void thirdTest() {
        var ans = Task3.parseDate("1/3/1976");
        assertEquals(Optional.of(LocalDate.of(1976, 3, 1)), ans);
    }

    @Test
    @DisplayName("fourth test")
    void fourthTest() {
        var ans = Task3.parseDate("1/3/20");
        assertEquals(Optional.of(LocalDate.of(2020, 3, 1)), ans);
    }

    @Test
    @DisplayName("fifth test")
    void fifthTest() {
        var ans = Task3.parseDate("today");
        assertEquals(Optional.of(LocalDate.now()), ans);
    }

    @Test
    @DisplayName("sixth test")
    void sixthTest() {
        var ans = Task3.parseDate("tomorrow");
        assertEquals(Optional.of(LocalDate.now().plusDays(1)), ans);
    }

    @Test
    @DisplayName("seventh test")
    void seventhTest() {
        var ans = Task3.parseDate("yesterday");
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), ans);
    }

    @Test
    @DisplayName("eighth test")
    void eighthTest() {
        var ans = Task3.parseDate("1 day ago");
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), ans);
    }
}
