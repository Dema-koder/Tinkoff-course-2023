package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("hideutilityclassconstructor")
public class Task3 {
    private static final String[] YEAR_FORMATS = {"yyyy", "yyy", "yy", "y"};
    private static final String[] MONTH_FORMATS = {"MM", "M"};
    private static final String[] DAY_FORMATS = {"dd", "d"};

    private static Optional<LocalDate> parser(String dateFormat, String request) {
        Optional<LocalDate> answer;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            answer = Optional.of(LocalDate.parse(request, formatter));
            return answer;
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static Optional<LocalDate> parseDate(String string) {
        Handler firstFormatHandler = new FirstFormatHandler();
        Handler secondFormatHandler = new SecondFormatHandler();
        Handler thirdFormatHandler = new ThirdFormatHandler();
        Handler fourthFormatHandler = new FourthFormatHandler();

        firstFormatHandler.setNext(secondFormatHandler);
        secondFormatHandler.setNext(thirdFormatHandler);
        thirdFormatHandler.setNext(fourthFormatHandler);

        return firstFormatHandler.handleRequest(string);
    }

    private static abstract class Handler {
        protected Handler next;

        public void setNext(Handler next) {
            this.next = next;
        }

        public abstract Optional<LocalDate> handleRequest(String request);
    }

    private static class FirstFormatHandler extends Handler {
        public Optional<LocalDate> handleRequest(String request) {
            Optional<LocalDate> answer = null;
            for (var year : YEAR_FORMATS) {
                for (var month : MONTH_FORMATS) {
                    for (var day : DAY_FORMATS) {
                        String dateFormat = year + "-" + month + "-" + day;
                        answer = parser(dateFormat, request);
                        if (!answer.isEmpty()) {
                            return answer;
                        }
                    }
                }
            }
            return next.handleRequest(request);
        }
    }

    private static class SecondFormatHandler extends Handler {
        public Optional<LocalDate> handleRequest(String request) {
            Optional<LocalDate> answer = null;
            for (var year : YEAR_FORMATS) {
                for (var month : MONTH_FORMATS) {
                    for (var day : DAY_FORMATS) {
                        String dateFormat = day + "/" + month + "/" + year;
                        answer = parser(dateFormat, request);
                        if (answer.isPresent()) {
                            return answer;
                        }
                    }
                }
            }
            return next.handleRequest(request);
        }
    }

    private static class ThirdFormatHandler extends Handler {
        public Optional<LocalDate> handleRequest(String request) {
            switch (request) {
                case "today":
                    return Optional.of(LocalDate.now());
                case "yesterday":
                    return Optional.of(LocalDate.now().minusDays(1));
                case "tomorrow":
                    return Optional.of(LocalDate.now().plusDays(1));
                default:
                    return next.handleRequest(request);
            }
        }
    }

    private static class FourthFormatHandler extends Handler {
        public Optional<LocalDate> handleRequest(String request) {
            Pattern pattern = Pattern.compile("^(\\d{1,}) day[s]? ago$");
            Matcher matcher = pattern.matcher(request);
            if (matcher.find()) {
                var days = Integer.parseInt(matcher.group(1));
                return Optional.of(LocalDate.now().minusDays(days));
            }
            return Optional.empty();
        }
    }

}
