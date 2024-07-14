import java.util.List;

public class Player {
    String name;
    List<Card> cards;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getTotal() {
        int total = 0;
        for (Card card : cards) {
            total += card.getValue();
        }
        return total;
    }

    public boolean isTotalUnderOrEqual21() {
        return getTotal() <= 21;
    }
}
