package edu.project1;

@SuppressWarnings("regexpsinglelinejava")
record FailedRequest() implements Request {
    @Override
    public void message(char[] word) {
        System.out.println("Слово: " + String.valueOf(word) + '\n' + "Не угадал, ошибок "
            + Game.getUser().getDoneMistakes() + " из " + Game.getMaxAttempts() + ".\n");
    }
}
