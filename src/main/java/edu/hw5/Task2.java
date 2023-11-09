package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
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
            if (current.getDayOfWeek() == DayOfWeek.FRIDAY && current.getDayOfMonth() == INTERESTED_DAY) {
                answer.add(current.toString());
            }
            current = current.plusDays(1);
        }
        return answer;
    }
}
