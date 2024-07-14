import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class PlayerTest {

    @Test
    public void testPlayerTotalUnderOrEqual21() {
        Deck deck = new Deck();
        Player player = new Player("TestPlayer",new ArrayList<>(), Role.PLAYER);


        Card firstCard = deck.drawCard();
        player.addCard(firstCard);

        Card secondCard = deck.drawCard();
        player.addCard(secondCard);

        System.out.println("First card: " + firstCard);
        System.out.println("Second card: " + secondCard);

        int total = player.getTotal();
        System.out.println("Total of player's cards: " + total);

        assertTrue(player.isTotalUnderOrEqual21(), "The total should be 21 or less initially.");

        while (player.isTotalUnderOrEqual21()) {
            Card card = deck.drawCard();
            player.addCard(card);
            total = player.getTotal();
            System.out.println("Drew card: " + card + ", new total: " + total);
        }

        assertTrue(player.isTotalOver21(), "The player should bust (total should exceed 21) after drawing more cards.");
    }

    @Test
    public void testDealerTotalUnderOrEqual21() {
        Deck deck = new Deck();
        Player player = new Player("TestPlayer",new ArrayList<>(), Role.DEALER);


        Card firstCard = deck.drawCard();
        player.addCard(firstCard);

        Card secondCard = deck.drawCard();
        player.addCard(secondCard);

        System.out.println("First card: " + firstCard);
        System.out.println("Second card: " + secondCard);

        int total = player.getTotal();
        System.out.println("Total of player's cards: " + total);

        assertTrue(player.isTotalUnderOrEqual21(), "The total should be 21 or less initially.");

        if(player.isTotalUnderOrEqual16()){
            Card thirdcard = deck.drawCard();
            player.addCard(thirdcard);
            total = player.getTotal();
            System.out.println("Drew card: " + thirdcard + ", new total: " + total);
        }

        assertTrue(player.isTotalOver21(), "The player should bust (total should exceed 21) after drawing more cards.");
    }
}