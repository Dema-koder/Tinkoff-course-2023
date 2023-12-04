package edu.hw7;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings({"hideutilityclassconstructor", "magicnumber"})
public class MultiThreadingPiCalculation {
    private static Thread[] threads;

    public static double piCalculation(long totalPoints, int threadsNumber) {
        AtomicLong pointsInsideCircle = new AtomicLong(0);
        threads = new Thread[threadsNumber];
        for (int i = 0; i < threadsNumber; i++) {
            threads[i] = new Thread(() -> {

                long pointsPerThread = totalPoints / threadsNumber;
                int pointsInsideCirclePerThread = 0;

                for (int j = 0; j < pointsPerThread; j++) {
                    double x = ThreadLocalRandom.current().nextDouble();
                    double y = ThreadLocalRandom.current().nextDouble();

                    double distance = Math.sqrt(x * x + y * y);

                    if (distance <= 1) {
                        pointsInsideCirclePerThread++;
                    }
                }

                synchronized (MultiThreadingPiCalculation.class) {
                    pointsInsideCircle.addAndGet(pointsInsideCirclePerThread);
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }

        return 4.0 * pointsInsideCircle.get() / totalPoints;
    }
}
