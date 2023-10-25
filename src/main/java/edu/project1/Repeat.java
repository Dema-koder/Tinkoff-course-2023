package edu.project1;

@SuppressWarnings("regexpsinglelinejava")
record Repeat() implements Request {
    @Override
    public void message(char[] word) {
        System.out.println("Строка не корректна!\n");
    }
}
