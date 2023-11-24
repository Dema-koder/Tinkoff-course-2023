package edu.hw7;

import java.util.concurrent.ThreadLocalRandom;

public class OneThreadPiCalculation {

    double piCalculation(long n) {
        int totalPoints = 0;
        int pointsInsideCircle = 0;
        while (totalPoints < n) {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();
            double dist = Math.sqrt(x * x + y * y);
            if (dist <= 1) {
                pointsInsideCircle++;
            }
            totalPoints++;
        }
        return 4.0 * pointsInsideCircle / totalPoints;
    }
}
