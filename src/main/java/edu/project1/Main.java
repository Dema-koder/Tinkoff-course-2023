package edu.project1;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.rules();
        while (true) {
            char letter = game.getchar();
            Request request = game.makeRequest(letter);
            request.message(game.getState());
            game.checkRequestType(request);
        }
    }
}
