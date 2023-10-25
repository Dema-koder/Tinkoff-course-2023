package edu.project1;

@SuppressWarnings("regexpsinglelinejava")
record Win() implements Request {
    @Override
    public void message(char[] word) {
        System.out.println("Слово: " + String.valueOf(word) + '\n' + "Вы выиграли!");
    }
}
