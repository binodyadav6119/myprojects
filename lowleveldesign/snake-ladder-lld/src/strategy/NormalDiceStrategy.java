package strategy;

import java.util.Random;

public class NormalDiceStrategy implements DiceRollStrategy {

    private final Random random = new Random();

    @Override
    public int roll(int diceCount) {
        int sum = 0;

        for (int i = 0; i < diceCount; i++) {
            sum += random.nextInt(6) + 1;
        }

        return sum;
    }
}