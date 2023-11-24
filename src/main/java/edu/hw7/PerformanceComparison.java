package edu.hw7;

public class PerformanceComparison {
    public static void main(String[] args) {
        long pointsNumber = 10_000_000;
        for (int i = 0; i < 3; i++) {
            long start, end;
            var oneThread = new OneThreadPiCalculation();
            start = System.currentTimeMillis();
            double firstPi = oneThread.piCalculation(pointsNumber);
            end = System.currentTimeMillis();
            System.out.println(
                "Время работы однопопточной программы для количества точек = " + pointsNumber + " : " +
                    (end - start));
            System.out.println("Вычесленное значение числа пи: " + firstPi);
            pointsNumber *= 10;
        }
        System.out.println();
        for (int numThreads = 1; numThreads <= 6; numThreads++) {
            long start, end;
            pointsNumber = 10_000_000;

            for (int i = 0; i < 3; i++) {
                System.out.println("Количество точек: " + pointsNumber);
                start = System.currentTimeMillis();
                double secondPi = MultiThreadingPiCalculation.piCalculation(pointsNumber, numThreads);
                end = System.currentTimeMillis();
                System.out.println(
                    "Время работы " + numThreads + "-поточной программы : " +
                        (end - start));
                System.out.println("Вычесленное значение числа пи: " + secondPi);
                pointsNumber *= 10;
            }
            System.out.println();
        }
    }
}
