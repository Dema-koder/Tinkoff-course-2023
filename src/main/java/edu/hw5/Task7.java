package edu.hw5;

import java.util.regex.Pattern;

@SuppressWarnings("hideutilityclassconstructor")
public class Task7 {
    public static boolean isValidString1(String string) {
        return Pattern.matches("^[01]{2}0[01]*$", string);
    }

    public static boolean isValidString2(String string) {
        return Pattern.matches("^(0|1)[01]*\\1$", string);
    }

    public static boolean isValidString3(String string) {
        return Pattern.matches("^[01]{1,3}$", string);
    }
}
