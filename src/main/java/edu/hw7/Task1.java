package edu.hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("hideutilityclassconstructor")
public class Task1 {
    public static AtomicInteger counter = new AtomicInteger(0);

    public static int threadCounter(int n) {
        List<Thread> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(new Thread(() -> counter.incrementAndGet()));
            lst.getLast().start();
        }
        try {
            for (Thread thread : lst) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return counter.get();
    }
}
