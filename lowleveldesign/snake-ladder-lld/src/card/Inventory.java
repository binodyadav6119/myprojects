package card;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<WildCard> cards = new ArrayList<>();

    public void addCard(WildCard card) {
        cards.add(card);
    }

    public WildCard useCard(int index) {
        return cards.remove(index);
    }

    public List<WildCard> getCards() {
        return cards;
    }
}