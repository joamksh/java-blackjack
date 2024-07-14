import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class PlayerTest {

    @Test
    public void testPlayerTotalUnderOrEqual21() {
        Deck deck = new Deck();
        Player player = new Player("TestPlayer", new ArrayList<>());


        Card firstCard = deck.drawCard();
        player.addCard(firstCard);

        Card secondCard = deck.drawCard();
        player.addCard(secondCard);

        // Print the values of the drawn cards
        System.out.println("First card: " + firstCard);
        System.out.println("Second card: " + secondCard);

        // Calculate total and print it
        int total = player.getTotal();
        System.out.println("Total: " + total);

        // Check if the total is under or equal to 21
        assertTrue(player.isTotalUnderOrEqual21(), "21이하이다");
    }
}
