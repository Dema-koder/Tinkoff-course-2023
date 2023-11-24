package edu.hw7;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.concurrent.Executors;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @RepeatedTest(100)
    public void testThreadCounter() {
        int n = 1000;
        Task1 task = new Task1(n);

        assertEquals(n, Task1.threadCounter());
    }
}
