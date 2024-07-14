import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }

    public List<Card> getCards() {
        return cards;
    }


}
