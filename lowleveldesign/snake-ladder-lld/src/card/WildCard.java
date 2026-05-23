package card;

import model.Game;
import model.Player;

public interface WildCard {
    void execute(Game game, Player player);
    String getName();
}