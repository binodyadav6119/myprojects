import card.DoubleDiceCard;
import card.SkipSnakeCard;
import controller.GameController;
import factory.JumpFactory;
import model.*;
import strategy.NormalDiceStrategy;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(100);

        board.addJump(JumpFactory.createJump("SNAKE", 99, 10));
        board.addJump(JumpFactory.createJump("SNAKE", 70, 55));

        board.addJump(JumpFactory.createJump("LADDER", 3, 40));
        board.addJump(JumpFactory.createJump("LADDER", 20, 75));

        Dice dice = new Dice(1, new NormalDiceStrategy());

        Player p1 = new Player("1", "Binod");
        Player p2 = new Player("2", "Alex");

        Game game = new Game(
                List.of(p1, p2),
                board,
                dice
        );

        p1.getInventory().addCard(new SkipSnakeCard());
        p1.getInventory().addCard(new DoubleDiceCard());

        p1.getInventory().useCard(0).execute(game, p1);

        GameController controller = new GameController(game);

        controller.startGame();
    }
}