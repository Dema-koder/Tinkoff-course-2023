package edu.hw3;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("hideutilityclassconstructor")
public class Task1 {
    private static Map<Character, Character> atbash = new HashMap();

    private static void createMap() {
        for (char i = 'a'; i <= 'z'; i++) {
            atbash.put(i, (char) ('z' - i + 'a'));
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            atbash.put(i, (char) ('Z' - i + 'A'));
        }
    }

    private static boolean checkMap() {
        if (atbash.containsKey('z') && atbash.containsKey('Z')) {
            return false;
        }
        return true;
    }

    public static String encrypt(String line) {
        if (checkMap()) {
            createMap();
        }
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (atbash.containsKey(cur)) {
                cur = atbash.get(cur);
            }
            chars[i] = cur;
        }
        String ans = new String(chars);
        return ans;
    }
}
