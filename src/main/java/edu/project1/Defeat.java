package edu.project1;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("regexpsinglelinejava")
record Defeat() implements Request {
    @Override
    public @NotNull void message(char[] word) {
        System.out.println("Слово: " + String.valueOf(word) + '\n' + "Не угадал, ошибок "
            + Game.getUser().getDoneMistakes() + " из " + Game.getMaxAttempts() + '\n' + "Вы проиграли!");
    }
}
