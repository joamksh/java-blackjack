import java.util.ArrayList;
import java.util.List;

class Player {
    String name;
    List<Card> cards;
    Role role;

    public Player(String name, Role role) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.role = role;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getTotal() {
        int total = 0;
        int aces = 0;

        for (Card card : cards) {
            total += card.getValue();
            if ("A".equals(card.value)) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public boolean isTotalUnderOrEqual21() {
        return getTotal() <= 21;
    }

    public boolean isTotalOver21() {
        return getTotal() > 21;
    }

    public boolean isTotalUnderOrEqual16() {
        return getTotal() <= 16;
    }

    @Override
    public String toString() {
        return name + " 카드: " + getCardsString() + " - 결과: " + getTotal();
    }

    public String getCardsString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
