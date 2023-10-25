package edu.project1;

public class UserInfo {
    private static int doneMistakes;

    public int getDoneMistakes() {
        return doneMistakes;
    }

    public UserInfo() {
        doneMistakes = 0;
    }

    public void doMistake() {
        doneMistakes++;
    }
}
