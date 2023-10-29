package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    void addTest() {
        int mx = 0;
        Random random = new Random();
        Task6 task = new Task6();
        for (int i = 0; i < 10; i++) {
            int cur = Math.abs(random.nextInt() % 100);
            task.add(new Stock(cur));
            mx = Math.max(cur, mx);
        }
        assertEquals(mx, task.mostValuableStock().getPrice());
    }

    @Test
    void removeTest() {
        Stock[] array =
            {new Stock(12), new Stock(32), new Stock(432), new Stock(23), new Stock(56), new Stock(23), new Stock(65)};
        Task6 task = new Task6();
        for (var to : array) {
            task.add(to);
        }
        assertEquals(432, task.mostValuableStock().getPrice());
        task.remove(array[2]);
        assertEquals(65, task.mostValuableStock().getPrice());
        task.remove(array[0]);
        assertEquals(65, task.mostValuableStock().getPrice());
    }
}
