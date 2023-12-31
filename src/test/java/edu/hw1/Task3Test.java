package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static edu.hw1.Task3.isNested;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    @DisplayName("Проверка вложенности")
    void isNestedTest() {
        for (int j = 0; j < 1000; j++) {
            Random random = new Random();
            long leftBorder1 = random.nextLong(10000);
            long rightBorder1 = random.nextLong(1000000) + leftBorder1;
            int n = random.nextInt(5) + 2;
            Long[] arr1 = new Long[n];
            arr1[0] = leftBorder1;
            arr1[1] = rightBorder1;
            for (int i = 2; i < n; i++) {
                arr1[i] = leftBorder1 + random.nextLong(rightBorder1 - leftBorder1);
            }

            long leftBorder2 = random.nextLong(10000);
            long rightBorder2 = random.nextLong(1000000) + leftBorder2;
            int m = random.nextInt(5) + 2;
            Long[] arr2 = new Long[m];
            arr2[0] = leftBorder2;
            arr2[1] = rightBorder2;
            for (int i = 2; i < m; i++) {
                arr2[i] = leftBorder2 + random.nextLong(rightBorder2 - leftBorder2);
            }

            assertEquals(((leftBorder1 > leftBorder2) && (rightBorder2 > rightBorder1)), isNested(arr1, arr2));
        }
    }
}
