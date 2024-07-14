import java.util.List;

public class Player {
    String name;
    List<Card> cards;

    Role role;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public Player(String name, List<Card> cards, Role role) {
        this.name = name;
        this.cards = cards;
        this.role = role;
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

    public boolean isBust() {
        return getTotal() > 21;
    }

}
