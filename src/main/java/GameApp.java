import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String input = scanner.nextLine();
        String[] playerNames = input.split(",");

        Deck deck = new Deck();
        Player dealer = new Player("딜러", Role.DEALER, 0);

        List<Player> players = new ArrayList<>();
        for (String name : playerNames) {
            System.out.println(name.trim() + "의 배팅 금액은 얼마입니까?");
            int betAmount = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            players.add(new Player(name.trim(), Role.PLAYER, betAmount));
        }

        String playerNamesList = players.stream()
                .map(player -> player.name)
                .collect(Collectors.joining(", "));
        System.out.println("딜러와 " + playerNamesList + "에게 2장을 나누었습니다.");

        // Initial deal
        for (Player player : players) {
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());
            System.out.println(player.name + " 카드: " + player.getCardsString());
        }
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        System.out.println("딜러: " + dealer.cards.get(0).toString());

        // Play game
        Game.playGame(deck, dealer, players);

        // Show dealer's hand
        System.out.println("딜러 카드: " + dealer.toString());

        // Determine winners
        Game.determineWinners(dealer, players);
    }
}
