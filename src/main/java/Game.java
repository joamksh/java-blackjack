import java.util.List;
import java.util.Scanner;

class Game {
    public static void playGame(Deck deck, Player dealer, List<Player> players) {
        Scanner scanner = new Scanner(System.in);

        for (Player player : players) {
            while (player.isTotalUnderOrEqual21()) {
                System.out.println(player.name + "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");
                String answer = scanner.nextLine();
                if ("n".equalsIgnoreCase(answer)) {
                    break;
                }
                Card card = deck.drawCard();
                player.addCard(card);
                System.out.println(player);
            }
        }

        if (dealer.isTotalUnderOrEqual16()) {
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
            dealer.addCard(deck.drawCard());
        }
    }

    public static String determineWinner(Player player, Player dealer) {
        int playerTotal = player.getTotal();
        int dealerTotal = dealer.getTotal();

        if (player.isTotalOver21() && dealer.isTotalOver21()) {
            return "모두 버스트.";
        }

        if (player.isTotalOver21()) {
            return player.name + ": 패배";
        } else if (dealer.isTotalOver21()) {
            return player.name + ": 승리";
        }

        if (playerTotal > dealerTotal) {
            return player.name + ": 승리";
        } else if (dealerTotal > playerTotal) {
            return player.name + ": 패배";
        } else {
            return player.name + ": 무승부";
        }
    }

    public static void determineWinners(Player dealer, List<Player> players) {
        int dealerProfit = 0;

        for (Player player : players) {
            String result = determineWinner(player, dealer);
            if (result.contains("승리")) {
                dealerProfit -= player.betAmount;
                System.out.println(player.name + ": " + player.betAmount);
            } else if (result.contains("패배")) {
                dealerProfit += player.betAmount;
                System.out.println(player.name + ": -" + player.betAmount);
            } else {
                System.out.println(player.name + ": 0");
            }
        }

        System.out.println("## 최종 수익");
        System.out.println("딜러: " + dealerProfit);
    }
}
