package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("First test")
    void firstTest() {
        var ans = Task2.allFridaysThirteenth(2024);
        assertEquals(List.of("2024-09-13", "2024-12-13"), ans);
    }

    @Test
    @DisplayName("Second test")
    void secondTest() {
        var ans = Task2.allFridaysThirteenth(1925);
        assertEquals(List.of("1925-02-13", "1925-03-13", "1925-11-13"), ans);
    }

    @Test
    @DisplayName("Third test")
    void thirdTest() {
        var ans = Task2.nextFridayThirteenth(LocalDate.of(2024, 9,11));
        assertEquals(LocalDate.of(2024, 9, 13), ans);
    }
}
