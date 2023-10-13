package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static edu.hw1.Task2.countDigits;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("Корректность подсчета количества цифр")
    void countDigitsTest() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            Long cur = random.nextLong();
            int answer = cur.toString().length();
            if (cur < 0)
                answer--;
            assertEquals(answer, countDigits(cur));
        }
    }
}
