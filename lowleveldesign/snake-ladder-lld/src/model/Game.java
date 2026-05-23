package model;

import state.GameState;

import java.util.*;

public class Game {

    private final Queue<Player> players;
    private final Board board;
    private final Dice dice;

    private GameState state;

    private final Map<Player, Boolean> snakeProtection = new HashMap<>();
    private final Map<Player, Boolean> doubleDice = new HashMap<>();

    public Game(List<Player> playerList, Board board, Dice dice) {
        this.players = new LinkedList<>(playerList);
        this.board = board;
        this.dice = dice;
        this.state = GameState.NOT_STARTED;
    }

    public void start() {
        state = GameState.IN_PROGRESS;

        while (state == GameState.IN_PROGRESS) {

            Player current = players.poll();

            int value = dice.roll();

            if (doubleDice.getOrDefault(current, false)) {
                value *= 2;
                doubleDice.put(current, false);
            }

            System.out.println(current.getName() + " rolled " + value);

            int nextPos = current.getPosition() + value;

            if (nextPos <= board.getSize()) {
                current.setPosition(nextPos);

                Jump jump = board.getJump(nextPos);

                if (jump != null) {

                    if (jump instanceof Snake &&
                        snakeProtection.getOrDefault(current, false)) {

                        System.out.println(current.getName() +
                                " skipped snake using card");

                        snakeProtection.put(current, false);

                    } else {
                        current.setPosition(jump.getEnd());
                    }
                }

                System.out.println(current.getName()
                        + " moved to "
                        + current.getPosition());

                if (current.getPosition() == board.getSize()) {
                    System.out.println(current.getName() + " won!");
                    state = GameState.FINISHED;
                    return;
                }
            }

            players.offer(current);
        }
    }

    public void setSnakeProtection(Player player, boolean value) {
        snakeProtection.put(player, value);
    }

    public void setDoubleDice(Player player, boolean value) {
        doubleDice.put(player, value);
    }
}