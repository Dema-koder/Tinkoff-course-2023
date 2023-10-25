package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("Проверка наличия символа в строке ответа")
    void updateStateTest() {
        Game game = new Game();
        String answer = game.getAnswer();
        for (char i = 'a'; i <= 'z'; i++) {
            if (answer.contains(String.valueOf(i))) {
                assertTrue(game.updateState(i));
            } else {
                assertFalse(game.updateState(i));
            }
        }
    }

    @Test
    @DisplayName("FailedRequest")
    void failedRequestTest() {
        for (char i = 'a'; i <= 'z'; i++) {
            Game game = new Game();
            String answer = game.getAnswer();
            if (!answer.contains(String.valueOf(i))) {
                assertEquals(new Request.FailedRequest(), game.makeRequest(i));
            }
        }
    }

    @Test
    @DisplayName("SuccessfulRequest")
    void successfulRequestTest() {
        for (char i = 'a'; i <= 'z'; i++) {
            Game game = new Game();
            String answer = game.getAnswer();
            if (answer.contains(String.valueOf(i))) {
                assertEquals(new Request.SuccessfulRequest(), game.makeRequest(i));
            }
        }
    }

    @Test
    @DisplayName("win")
    void winTest() {
        Game game = new Game();
        String answer = game.getAnswer();
        int k = answer.length();
        char letter = 'Q';
        for (char i = 'a'; i <= 'z'; i++) {
            if (answer.contains(String.valueOf(i))) {
                int cur = 0;
                for (int j = 0; j < answer.length(); j++) {
                    if (answer.charAt(j) == i) {
                        cur++;
                    }
                }
                if (cur == k) {
                    letter = i;
                    break;
                } else {
                    k -= cur;
                    game.updateState(i);
                }
            }
        }
        assertEquals(new Request.Win(), game.makeRequest(letter));
    }

    @Test
    @DisplayName("Defeat")
    void defeatTest() {
        Game game;
        String answer;
        while (true) {
            game = new Game();
            answer = game.getAnswer();
            if (answer.length() <= 5) {
                break;
            }
        }
        int maxAttempts = game.getMaxAttempts();
        char letter = 'Q';
        for (char i = 'a'; i <= 'z'; i++) {
            if (!answer.contains(String.valueOf(i))) {
                if (maxAttempts == 1) {
                    letter = i;
                    break;
                }
                game.makeRequest(i);
                maxAttempts--;
            }
        }
        assertEquals(new Request.Defeat(), game.makeRequest(letter));
    }
}
