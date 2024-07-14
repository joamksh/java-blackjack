public class Game {
    public static String determineWinner(Player player, Player dealer) {
        int playerTotal = player.getTotal();
        int dealerTotal = dealer.getTotal();

        if (player.isTotalOver21()) {
            return "Dealer wins!";
        } else if (dealer.isTotalOver21()) {
            return "Player wins!";
        }

        if (playerTotal > dealerTotal) {
            return "Player wins!";
        } else if (dealerTotal > playerTotal) {
            return "Dealer wins!";
        } else {
            return "It's a tie!";
        }
    }
}
