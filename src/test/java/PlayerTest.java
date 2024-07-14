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

    @Test
    public void testDetermineWinner() {
        Deck deck = new Deck();
        Player player = new Player("Player", new ArrayList<>(), Role.PLAYER);
        Player dealer = new Player("Dealer", new ArrayList<>(), Role.DEALER);

        while (player.getTotal() < 21) {
            player.addCard(deck.drawCard());
        }

        while (dealer.isTotalUnderOrEqual16()) {
            dealer.addCard(deck.drawCard());
        }

        System.out.println("Player total: " + player.getTotal());
        System.out.println("Dealer total: " + dealer.getTotal());

        String result = Game.determineWinner(player, dealer);
        System.out.println(result);

        if (player.isTotalOver21()) {
            assertEquals("Dealer wins!", result, "Dealer should win if player busts.");
        } else if (dealer.isTotalOver21()) {
            assertEquals("Player wins!", result, "Player should win if dealer busts.");
        } else {
            if (player.getTotal() > dealer.getTotal()) {
                assertEquals("Player wins!", result, "Player should win if player total is higher.");
            } else if (dealer.getTotal() > player.getTotal()) {
                assertEquals("Dealer wins!", result, "Dealer should win if dealer total is higher.");
            } else {
                assertEquals("It's a tie!", result, "It should be a tie if totals are equal.");
            }
        }
    }

}