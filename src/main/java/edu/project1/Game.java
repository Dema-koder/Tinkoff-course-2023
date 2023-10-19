package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    //public static final Logger LOGGER = LogManager.getLogger();
    private static final Scanner scanner = new Scanner(System.in);
    private static final int DEFAULT_ATTEMPTS_NUMBER = 5;
    private static Dictionary dictionary = new Dictionary();
    private static UserInfo user;
    private static char[] state;
    private static String answer;
    private static int maxAttempts;

    public Game() {
        maxAttempts = DEFAULT_ATTEMPTS_NUMBER;
        answer = dictionary.getWord();
        user = new UserInfo();
        state = new char[answer.length()];
        Arrays.fill(state, '*');
    }

    public static void rules() {
        System.out.print(
            "Перед вами игра виселица. Вам нужно угадать слово из " + answer.length() +
                " букв.\nСлово состоит только из строчных анлийсксих букв.\n" +
                "Ваша задача вводить по одному строчному символу английского алфавита.\n" +
                "Если вы введете больше 1 символа то игра завершится.\n" +
                "Если вы введете какой либо другой символ игра завершится.\n" +
                "Также вы можете завершить игру нажав команду Ctrl+D.\nУдачи!\n\n");
    }

    public static int getMaxAttempts() {
        return maxAttempts;
    }

    public static UserInfo getUser() {
        return user;
    }

    public char[] getState() {
        return state;
    }

    private String letterRequest() {
        System.out.print("Угадай букву: ");
        String letter = "scd";
        if (!scanner.hasNextLine()) {
            return letter;
        }
        letter = scanner.nextLine();
        return letter;
    }

    public char getchar() {
        String line = letterRequest();
        if (line.length() > 1) {
            return 'Q';
        }
        return line.charAt(0);
    }

    public boolean checkLetter(char letter) {
        if (letter < 'a' || letter > 'z') {
            return false;
        }
        return true;
    }

    private boolean isEnd() {
        for (int i = 0; i < state.length; i++) {
            if (state[i] == '*') {
                return false;
            }
        }
        return true;
    }

    private boolean isMistake(char letter) {
        boolean check = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == letter) {
                state[i] = letter;
                check = true;
            }
        }
        if (check == false) {
            user.doMistake();
        }
        return check;
    }

    public Request makeRequest(char letter) {
        boolean check = isMistake(letter);
        if (!checkLetter(letter)) {
            return new Request.Break();
        }
        if (!isEnd() && user.getDoneMistakes() == maxAttempts) {
            return new Request.Defeat();
        }
        if (check && isEnd()) {
            return new Request.Win();
        }
        if (check && !isEnd()) {
            return new Request.SuccessfulRequest();
        }
        return new Request.FailedRequest();
    }

    public void checkRequestType(Request request) {
        if (request instanceof Request.Break || request instanceof Request.Win || request instanceof Request.Defeat) {
            System.exit(0);
        }
    }
}
