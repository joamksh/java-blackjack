import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerTest {

    @Test
    public void testPlayerTotalUnderOrEqual21() {
        Deck deck = new Deck();
        Player player = new Player("TestPlayer", Role.PLAYER, 1000);

        Card firstCard = deck.drawCard();
        player.addCard(firstCard);

        Card secondCard = deck.drawCard();
        player.addCard(secondCard);

        System.out.println("First card: " + firstCard);
        System.out.println("Second card: " + secondCard);

        int total = player.getTotal();
        System.out.println("Total cards: " + total);

        assertTrue(player.isTotalUnderOrEqual21(), "21이하여야한다.");

        while (player.isTotalUnderOrEqual21()) {
            Card card = deck.drawCard();
            player.addCard(card);
            total = player.getTotal();
            System.out.println("Drew card: " + card + ", new total: " + total);
        }

        assertTrue(player.isTotalOver21(), "21초과인지 확인");
    }

    @Test
    public void testDealerDrawCardIfTotal16OrLess() {
        Deck deck = new Deck();
        Player dealer = new Player("TestDealer", Role.DEALER, 0);

        dealer.addCard(new Card("Diamonds", "7"));
        dealer.addCard(new Card("Hearts", "8"));

        int total = dealer.getTotal();
        System.out.println("Dealer's 처음 total: " + total);

        assertTrue(dealer.isTotalUnderOrEqual21(), "21이하여야한다.");
        assertTrue(dealer.isTotalUnderOrEqual16(), "16이하여야한다.");

        if (dealer.isTotalUnderOrEqual16()) {
            Card thirdCard = new Card("Clubs", "9");
            dealer.addCard(thirdCard);
            total = dealer.getTotal();
            System.out.println("Drew card: " + thirdCard + ", new total: " + total);
        }

        assertTrue(dealer.isTotalOver21(), "21초과인지 확인");
    }

    @Test
    public void testDetermineWinner() {
        // Simulate user input for the game
        String simulatedInput = "n\nn\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();
        Player player1 = new Player("Player1", Role.PLAYER, 10000);
        Player player2 = new Player("Player2", Role.PLAYER, 20000);
        Player dealer = new Player("Dealer", Role.DEALER, 0);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        player1.addCard(deck.drawCard());
        player1.addCard(deck.drawCard());

        player2.addCard(deck.drawCard());
        player2.addCard(deck.drawCard());

        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        System.out.println("Initial hands:");
        System.out.println(dealer.name + " initial hand: " + dealer.getCardsString());
        System.out.println(player1.name + " initial hand: " + player1.getCardsString());
        System.out.println(player2.name + " initial hand: " + player2.getCardsString());

        Game.playGame(deck, dealer, players);


        System.out.println("Final hands:");
        System.out.println(dealer.name + " final hand: " + dealer.getCardsString() + " - total: " + dealer.getTotal());
        System.out.println(player1.name + " final hand: " + player1.getCardsString() + " - total: " + player1.getTotal());
        System.out.println(player2.name + " final hand: " + player2.getCardsString() + " - total: " + player2.getTotal());

        Game.determineWinners(dealer, players);

        assertTrue(dealer.getTotal() <= 21, "Dealer 유효함");
        assertTrue(player1.getTotal() <= 21, "Player1 유효함");
        assertTrue(player2.getTotal() <= 21, "Player2 유효함");
    }
}
