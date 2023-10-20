package edu.project1;

@SuppressWarnings("regexpsinglelinejava")
record SuccessfulRequest() implements Request {
    @Override
    public void message(char[] word) {
        System.out.println("Слово: " + String.valueOf(word) + '\n' + "Угадал!\n");
    }
}
