package edu.project1;

public class UserInfo {
    private static final int ALPHABET = 26;
    private static int doneAttempts;
    private static int doneMistakes;
    private static char[] letters;

    public int getDoneMistakes() {
        return doneMistakes;
    }

    public UserInfo() {
        letters = new char[ALPHABET];
        doneMistakes = 0;
        doneAttempts = 0;
    }

    public void doMistake() {
        doneMistakes++;
    }

    public void newLetter(char letter) {
        letters[doneAttempts] = letter;
        doneAttempts++;
    }
}
