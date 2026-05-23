package card;

import model.Game;
import model.Player;

public class SkipSnakeCard implements WildCard {

    @Override
    public void execute(Game game, Player player) {
        game.setSnakeProtection(player, true);
    }

    @Override
    public String getName() {
        return "Skip Snake Card";
    }
}