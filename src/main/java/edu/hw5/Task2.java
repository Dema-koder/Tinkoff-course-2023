package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("hideutilityclassconstructor")
public class Task2 {
    private static final int INTERESTED_DAY = 13;

    public static List<String> allFridaysThirteenth(int year) {
        LocalDate current = LocalDate.of(year, Month.JANUARY, 1);
        LocalDate newYear = LocalDate.of(year + 1, Month.JANUARY, 1);
        List<String> answer = new ArrayList<>();
        while (current.isBefore(newYear)) {
            if (isFridayThirteenth(current)) {
                answer.add(current.toString());
            }
            current = current.plusDays(1);
        }
        return answer;
    }

    private static boolean isFridayThirteenth(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == INTERESTED_DAY;
    }

    public static LocalDate nextFridayThirteenth(LocalDate date) {
        return date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY))
            .with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY));
    }
}
