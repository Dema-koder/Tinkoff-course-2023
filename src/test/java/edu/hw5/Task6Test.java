package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    void correctTest() {
        var ans = Task6.isSubstring("abc", "ajksndbksmkdc");
        assertTrue(ans);
    }

    @Test
    void incorrectTest() {
        var ans = Task6.isSubstring("abc", "kacnlkcsdsacd");
        assertFalse(ans);
    }
}
