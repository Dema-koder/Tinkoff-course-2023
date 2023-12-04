package edu.hw7;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OneThreadPiCalculationTest {
    @RepeatedTest(100)
    public void testPiCalculation() {
        OneThreadPiCalculation calculator = new OneThreadPiCalculation();
        long n = 1000000;

        double pi = calculator.piCalculation(n);

        assertEquals(Math.PI, pi, 0.01, "Значение числа π должно быть близко к " + Math.PI);
    }
}
