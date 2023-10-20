package edu.project1;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("regexpsinglelinejava")
public class Game {
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

    public static String getAnswer() {
        return answer;
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

    protected boolean updateState(char letter) {
        boolean check = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == letter) {
                state[i] = letter;
                check = true;
            }
        }
        return check;
    } // написал тесты

    private String letterRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Угадай букву: ");
        String line = new String();
        try {
            line = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Завершение игры!");
            System.exit(0);
        }
        return line;
    } // не понятно как тестить

    protected boolean checkLetter(char letter) {
        if (letter < 'a' || letter > 'z') {
            return false;
        }
        return true;
    } // нет смысла тестить

    public static void rules() {
        System.out.print(
            "Перед вами игра виселица. Вам нужно угадать слово из " + answer.length()
                + " букв.\nСлово состоит только из строчных анлийсксих букв.\n"
                + "Ваша задача вводить по одному строчному символу английского алфавита.\n"
                + "Если вы введете больше 1 символа то игра завершится.\n"
                + "Если вы введете какой либо другой символ игра завершится.\n"
                + "Также вы можете завершить игру нажав команду Ctrl+D.\nУдачи!\n\n");
    } // простой функционал, не надо тестить

    public Request getChar() {
        String line = letterRequest();
        if (line.length() > 1) {
            return new Request.Repeat();
        }
        if (!checkLetter(line.charAt(0))) {
            return new Request.Repeat();
        }
        return makeRequest(line.charAt(0));
    } // простой функционал основаный на других функциях, нет смысла тестить

    protected Request makeRequest(char letter) {
        boolean check = updateState(letter);
        boolean isEnd = (Arrays.toString(state)).contains(String.valueOf('*'));
        if (!check) {
            user.doMistake();
        }
        if (isEnd && user.getDoneMistakes() == maxAttempts) {
            return new Request.Defeat();
        }
        if (check && !isEnd) {
            return new Request.Win();
        }
        if (check && isEnd) {
            return new Request.SuccessfulRequest();
        }
        return new Request.FailedRequest();
    } // написал тесты

    public void checkRequestType(Request request) {
        if (request instanceof Request.Win || request instanceof Request.Defeat) {
            System.exit(0);
        }
    } // простой функционал, можно не тестить
}
