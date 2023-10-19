package edu.project1;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.rules();
        while (true) {
            Request request = game.getChar();
            request.message(game.getState());
            game.checkRequestType(request);
        }
    }
}
