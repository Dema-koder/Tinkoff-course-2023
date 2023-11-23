package edu.hw7;

import java.util.stream.LongStream;

@SuppressWarnings("hideutilityclassconstructor")
public class Task2 {
    public static long multiThreadingFactorial(int n) {
        return LongStream.rangeClosed(1, n)
            .parallel().reduce(1, (a, b) -> a * b);
    }
}
