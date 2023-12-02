package edu.hw5;

import java.util.regex.Pattern;

@SuppressWarnings("hideutilityclassconstructor")
public class Task6 {
    public static boolean isSubstring(String s, String t) {
        return Pattern.matches(".*" + String.join(".*", s.split("")), t);
    }
}
