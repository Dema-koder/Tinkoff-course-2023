package edu.project1;

import org.jetbrains.annotations.NotNull;

public sealed interface Request {
    @NotNull void message(char[] word);

    record Defeat() implements Request {
        @Override
        public @NotNull void message(char[] word) {
            ;
            System.out.println("Слово: " + String.valueOf(word) + '\n' + "Не угадал, ошибок " +
                Game.getUser().getDoneMistakes() + " из " + Game.getMaxAttempts() + '\n' + "Вы проиграли!");
        }
    }

    record Win() implements Request {
        @Override
        public @NotNull void message(char[] word) {
            System.out.println("Слово: " + String.valueOf(word) + '\n' + "Вы выиграли!");
        }
    }

    record SuccessfulRequest() implements Request {
        @Override
        public @NotNull void message(char[] word) {
            System.out.println("Слово: " + String.valueOf(word) + '\n' + "Угадал!\n");
        }
    }

    record FailedRequest() implements Request {
        @Override
        public @NotNull void message(char[] word) {
            System.out.println("Слово: " + String.valueOf(word) + '\n' + "Не угадал, ошибок " +
                Game.getUser().getDoneMistakes() + " из " + Game.getMaxAttempts() + ".\n");
        }
    }

    record Break() implements Request {
        @Override
        public @NotNull void message(char[] word) {
            System.out.println("Завершение игры");
        }
    }
}
