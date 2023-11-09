package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("hideutilityclassconstructor")
public class Task1 {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int SECONDS_IN_MIN = 3600;
    private static final int MINUTES_IN_HOUR = 60;

    public static String averageTime(List<String> periods) {
        List<Duration> durations = periods.stream()
            .map(period -> period.split(" - "))
            .filter(period -> isValidFormat(period[0]) && isValidFormat(period[1]))
            .map(period -> new LogDuration(parser(period[0]), parser(period[1])))
            .map(period -> Duration.between(period.begin, period.end))
            .collect(Collectors.toList());
        long average = countAverage(durations);
        long hours = Duration.ofMillis(average).getSeconds() / SECONDS_IN_MIN;
        long minutes = Duration.ofMillis(average).toMinutes() % MINUTES_IN_HOUR;
        return (Long.toString(hours) + "ч " + Long.toString(minutes) + 'м');
    }

    private static long countAverage(List<Duration> durations) {
        if (durations.isEmpty()) {
            return 0;
        }
        long total = 0;
        for (var duration : durations) {
            total += duration.toMillis();
        }
        return total / durations.size();
    }

    private static LocalDateTime parser(String time) {
        LocalDateTime answer = null;
        try {
            answer = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm"));
        } catch (Exception e) {
            LOGGER.error("Некорректный формат вывода: " + time);
            System.exit(0);
        }
        return answer;
    }

    private static boolean isValidFormat(String moment) {
        Pattern data = Pattern.compile("\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");
        Pattern time = Pattern.compile("([01][0-9]|2[0-4]):([0-5][0-9])");
        Matcher matcher = data.matcher(moment);
        Matcher matcher1 = time.matcher(moment);
        return matcher.find() && matcher1.find();
    }

    private static class LogDuration {
        LocalDateTime begin;
        LocalDateTime end;

        LogDuration(LocalDateTime begin, LocalDateTime end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
