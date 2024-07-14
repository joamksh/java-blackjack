import java.util.List;

public class Game {

    public static void playGame(Deck deck, Player dealer, List<Player> players) {
        for (Player player : players) {
            while (player.isTotalUnderOrEqual21()) {
                Card card = deck.drawCard();
                player.addCard(card);
                if (player.isTotalOver21()) {
                    break;
                }
            }
        }

        while (dealer.isTotalUnderOrEqual16()) {
            dealer.addCard(deck.drawCard());
        }
    }

    public static String determineWinner(Player player, Player dealer) {
        int playerTotal = player.getTotal();
        int dealerTotal = dealer.getTotal();

        if (player.isTotalOver21() && dealer.isTotalOver21()) {
            return "All bust.";
        }

        if (player.isTotalOver21()) {
            return player.name + " loses.";
        } else if (dealer.isTotalOver21()) {
            return player.name + " wins!";
        }

        if (playerTotal > dealerTotal) {
            return player.name + " wins!";
        } else if (dealerTotal > playerTotal) {
            return player.name + " loses.";
        } else {
            return "It's a tie for " + player.name + ".";
        }
    }

    public static void determineWinners(Player dealer, List<Player> players) {
        boolean allBust = dealer.isTotalOver21() && players.stream().allMatch(Player::isTotalOver21);

        if (allBust) {
            System.out.println("All bust. No winners.");
        } else {
            for (Player player : players) {
                String result = determineWinner(player, dealer);
                System.out.println(result);
            }
        }
    }
}
