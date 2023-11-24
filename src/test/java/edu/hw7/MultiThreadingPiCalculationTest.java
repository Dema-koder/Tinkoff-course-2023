package edu.hw7;

import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

class MultiThreadingPiCalculationTest {
    @RepeatedTest(100)
    public void testPiCalculation() {
        MultiThreadingPiCalculation calculator = new MultiThreadingPiCalculation();
        long totalPoints = 1000000;
        int threadsNumber = 4;
        double expectedPi = Math.PI;

        double pi = calculator.piCalculation(totalPoints, threadsNumber);

        assertEquals(expectedPi, pi, 0.01);
    }
}
