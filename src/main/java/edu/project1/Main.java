package edu.project1;

@SuppressWarnings("hideutilityclassconstructor")
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
