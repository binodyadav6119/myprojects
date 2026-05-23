package card;

import model.Game;
import model.Player;

public class DoubleDiceCard implements WildCard {

    @Override
    public void execute(Game game, Player player) {
        game.setDoubleDice(player, true);
    }

    @Override
    public String getName() {
        return "Double Dice Card";
    }
}