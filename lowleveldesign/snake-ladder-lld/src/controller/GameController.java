package controller;

import model.Game;

public class GameController {

    private final Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void startGame() {
        game.start();
    }
}