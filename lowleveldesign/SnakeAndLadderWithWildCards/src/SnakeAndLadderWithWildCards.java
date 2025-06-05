import java.util.*;

// Entity representing a Board Cell (can contain Snake, Ladder, or Wild Card)
class Cell {
    int position;
    WildCard wildCard;
    SpecialMove specialMove;

    public Cell(int position) {
        this.position = position;
    }
}

// Entity for Players
class Player {
    String name;
    int position;

    public Player(String name) {
        this.name = name;
        this.position = 0; // Start from position 0
    }
}

// Dice class to roll numbers between 1 and 6
class Dice {
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1;
    }
}

// Abstract WildCard class (Strategy Pattern)
abstract class WildCard {
    abstract void applyEffect(Player player, Game game);
}

// Concrete Wild Card Implementations
class ExtraTurnWildCard extends WildCard {
    @Override
    void applyEffect(Player player, Game game) {
        System.out.println(player.name + " gets an extra turn!");
        game.playTurn(player); // Reinvoke play turn
    }
}

class SwapPositionWildCard extends WildCard {
    @Override
    void applyEffect(Player player, Game game) {
        List<Player> players = game.getPlayers();
        Player randomPlayer = players.get(new Random().nextInt(players.size()));
        if (!randomPlayer.equals(player)) {
            System.out.println(player.name + " swaps position with " + randomPlayer.name);
            int temp = player.position;
            player.position = randomPlayer.position;
            randomPlayer.position = temp;
        }
    }
}

// Factory Pattern for Wild Cards
class WildCardFactory {
    public static WildCard createWildCard() {
        Random random = new Random();
        int type = random.nextInt(2); // Two types: ExtraTurn and SwapPosition
        return (type == 0) ? new ExtraTurnWildCard() : new SwapPositionWildCard();
    }
}

// Special Moves (Strategy Pattern)
interface SpecialMove {
    void execute(Player player, Game game);
}

class Ladder implements SpecialMove {
    private final int jump;

    public Ladder(int jump) {
        this.jump = jump;
    }

    @Override
    public void execute(Player player, Game game) {
        System.out.println(player.name + " climbs a ladder! Moving up " + jump + " positions.");
        player.position += jump;
    }
}

class Snake implements SpecialMove {
    private final int slide;

    public Snake(int slide) {
        this.slide = slide;
    }

    @Override
    public void execute(Player player, Game game) {
        System.out.println(player.name + " got bitten by a snake! Moving down " + slide + " positions.");
        player.position -= slide;
    }
}

// Observer Pattern to notify players
interface PlayerObserver {
    void notifyTurn(Player player);
}

class Game implements PlayerObserver {
    private final List<Player> players;
    private final Dice dice;
    private final Map<Integer, Cell> board;
    private final int boardSize = 100;
    private int currentPlayerIndex = 0;

    public Game(List<String> playerNames) {
        this.players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        this.dice = new Dice();
        this.board = new HashMap<>();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 1; i <= boardSize; i++) {
            board.put(i, new Cell(i));
            if (new Random().nextInt(10) < 2) { // 20% chance to have a wild card
                board.get(i).wildCard = WildCardFactory.createWildCard();
            }
            if (new Random().nextInt(10) < 2) { // 20% chance to have a ladder
                board.get(i).specialMove = new Ladder(new Random().nextInt(10) + 2);
            }
            if (new Random().nextInt(10) < 2) { // 20% chance to have a snake
                board.get(i).specialMove = new Snake(new Random().nextInt(10) + 2);
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void startGame() {
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            notifyTurn(currentPlayer);
            playTurn(currentPlayer);

            if (currentPlayer.position >= boardSize) {
                System.out.println(currentPlayer.name + " wins!");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    public void playTurn(Player player) {
        int roll = dice.roll();
        System.out.println(player.name + " rolled a " + roll);

        int newPosition = player.position + roll;
        if (newPosition <= boardSize) {
            player.position = newPosition;

            Cell currentCell = board.get(newPosition);
            if (currentCell.wildCard != null) {
                System.out.println(player.name + " encountered a wild card!");
                currentCell.wildCard.applyEffect(player, this);
            }
            if (currentCell.specialMove != null) {
                currentCell.specialMove.execute(player, this);
            }
        }

        System.out.println(player.name + " is now at position " + player.position);
    }

    @Override
    public void notifyTurn(Player player) {
        System.out.println("It's " + player.name + "'s turn!");
    }
}

// Main class to run the game
public class SnakeAndLadderWithWildCards {
    public static void main(String[] args) {
        List<String> playerNames = Arrays.asList("Alice", "Bob", "Charlie"); // Added Charlie
        Game game = new Game(playerNames);
        game.startGame();
    }
}
