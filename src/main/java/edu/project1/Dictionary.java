package edu.project1;

import java.util.Random;

public class Dictionary {

    private static final int NUMBER_OF_WORDS = 10;
    private static String[] dictionary =
        {"hello", "world", "table", "week", "home", "work", "project", "flash", "smoke", "team"};

    public Dictionary() {
    }

    public String getWord() {
        Random random = new Random();
        return dictionary[Math.abs(random.nextInt()) % NUMBER_OF_WORDS];
    }
}

