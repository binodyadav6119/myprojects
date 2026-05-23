package model;

import strategy.DiceRollStrategy;

public class Dice {

    private final int count;
    private final DiceRollStrategy strategy;

    public Dice(int count, DiceRollStrategy strategy) {
        this.count = count;
        this.strategy = strategy;
    }

    public int roll() {
        return strategy.roll(count);
    }
}