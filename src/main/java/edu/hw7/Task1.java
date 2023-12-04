package edu.hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("hideutilityclassconstructor")
public class Task1 {
    private static int n;

    public Task1(int n) {
        this.n = n;
    }

    public static int threadCounter() {
        AtomicInteger counter = new AtomicInteger(0);
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
