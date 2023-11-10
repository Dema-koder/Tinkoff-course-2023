package edu.hw5;

import java.util.regex.Pattern;

@SuppressWarnings("hideutilityclassconstructor")
public class Task5 {
    public static boolean isValidNumber(String number) {
        return Pattern.matches("^[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$", number);
    }
}
