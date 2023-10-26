package edu.project1;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"regexpsinglelinejava", "multiplestringliterals"})
public sealed interface Request
    permits Request.Defeat, Request.FailedRequest, Request.Repeat, Request.SuccessfulRequest, Request.Win {
    void message(char[] word);

    record Defeat() implements Request {
        @Override
        public @NotNull void message(char[] word) {
            System.out.println("Слово: " + String.valueOf(word) + '\n' + "Не угадал, ошибок "
                + Game.getUser().getDoneMistakes() + " из " + Game.getMaxAttempts() + '\n' + "Вы проиграли!");
        }
    }

    record FailedRequest() implements Request {
        @Override
        public void message(char[] word) {
            System.out.println("Слово: " + String.valueOf(word) + '\n' + "Не угадал, ошибок "
                + Game.getUser().getDoneMistakes() + " из " + Game.getMaxAttempts() + ".\n");
        }
    }

    record Repeat() implements Request {
        @Override
        public void message(char[] word) {
            System.out.println("Строка не корректна!\n");
        }
    }

    record SuccessfulRequest() implements Request {
        @Override
        public void message(char[] word) {
            System.out.println("Слово: " + String.valueOf(word) + '\n' + "Угадал!\n");
        }
    }

    record Win() implements Request {
        @Override
        public void message(char[] word) {
            System.out.println("Слово: " + String.valueOf(word) + '\n' + "Вы выиграли!");
        }
    }
}
