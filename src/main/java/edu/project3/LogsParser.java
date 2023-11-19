package edu.project3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"multiplestringliterals", "magicnumber"})
public class LogsParser {
    private final static String IP_ADDRESS_PATTERN = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";
    private final static String ANY_STRING_PATTERN = ".*?";
    private final static String STATUS_PATTERN = "[1-5]\\d{2}";
    private final static String BYTES_COUNT_PATTERN = "\\d{1,}";
    private final static String DATE_TIME_PATTERN = "dd/MMM/yyyy:HH:mm:ss xxxx";
    private static String generatedPattern = null;

    private LogsParser() {
    }

    private static String generateLogPattern() {
        if (generatedPattern != null) {
            return generatedPattern;
        }

        generatedPattern = "^"
            + "(" + IP_ADDRESS_PATTERN + ")"
            + " - "
            + "(" + ANY_STRING_PATTERN + ")"
            + " "
            + "\\[(" + ANY_STRING_PATTERN + ")\\]"
            + " "
            + "\"(" + ANY_STRING_PATTERN + ")\""
            + " "
            + "(" + STATUS_PATTERN + ")"
            + " "
            + "(" + BYTES_COUNT_PATTERN + ")"
            + " "
            + "\"(" + ANY_STRING_PATTERN + ")\""
            + " "
            + "\"(" + ANY_STRING_PATTERN + ")\""
            + "$";

        return generatedPattern;
    }

    public static LogString parseString(@NotNull String logString, String source) {
        Matcher matcher = Pattern.compile(generateLogPattern()).matcher(logString);

        if (!matcher.find()) {
            return null;
        }

        return new LogString(
            source,
            matcher.group(1),
            matcher.group(2),
            LocalDateTime.from(DateTimeFormatter
                .ofPattern(DATE_TIME_PATTERN)
                .localizedBy(Locale.ENGLISH)
                .parse(matcher.group(3))),
            matcher.group(4),
            Integer.parseInt(matcher.group(5)),
            Integer.parseInt(matcher.group(6)),
            matcher.group(7),
            matcher.group(8)
        );
    }
}
