package edu.hw5;

import java.util.regex.Pattern;

@SuppressWarnings("hideutilityclassconstructor")
public class Task4 {
    public static boolean isValidPassword(String password) {
        return Pattern.matches(".*[~!@#$%^&*|].*", password);
    }
}
