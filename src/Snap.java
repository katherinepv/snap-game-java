import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {
    Scanner scanner = new Scanner(System.in);
    public boolean hasMatchingSymbol = false;

    Player player = new Player();
    public Snap(String name) {
        super(name);
    }

    public String playerTakesTurn() {
        String playerInput = scanner.nextLine();
        return playerInput;
    }

    public void checkPlayerWroteSnapInTwoSeconds() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time up! Better luck next time.");

            }
        };
        timer.schedule(task, 2000);
        String playerEntersSnap = scanner.nextLine();
        timer.cancel();

        if(playerEntersSnap.equalsIgnoreCase("snap")) {
            System.out.println("You win! End of game.");
        }
    }

    public void onePlayerGame() {
        System.out.println("Ready to play Snap?");
        super.shuffleDeck();

        Card firstDealtCard = super.dealCard();
        Card secondDealtCard = super.dealCard();

        while (!hasMatchingSymbol) {
            playerTakesTurn();
            System.out.println("Card one: " + firstDealtCard);
            playerTakesTurn();
            System.out.println("Card two: " + secondDealtCard);
            System.out.println(" ");

            if(firstDealtCard.getSymbol().equals(secondDealtCard.getSymbol())) {
            hasMatchingSymbol = true;
            break;
             }
            else {
                firstDealtCard = secondDealtCard;
                secondDealtCard = super.dealCard();
            }
        }
        System.out.println("snap! you win! end of game");
    }

    public void twoPlayerGame() {
        System.out.println("Ready to play Snap?");
        super.shuffleDeck();
        System.out.println("When you see two cards with matching symbols, you have 2 seconds to say snap!");
        System.out.println("Press enter to deal card.");

        Card firstDealtCard = super.dealCard();
        Card secondDealtCard = super.dealCard();

        playerTakesTurn();
        System.out.println("Card one: " + firstDealtCard);
        while (!hasMatchingSymbol) {
            playerTakesTurn();
            System.out.println("Card one: " + firstDealtCard + " ¦ Card two: " + secondDealtCard );
            System.out.println(" ");

            if(firstDealtCard.getSymbol().equals(secondDealtCard.getSymbol())) {
                hasMatchingSymbol = true;
                checkPlayerWroteSnapInTwoSeconds();
                break;

            }
            else {
                firstDealtCard = secondDealtCard;
                secondDealtCard = super.dealCard();
            }
        }
        System.out.println("snap! you win! end of game");
    }

    public void game() {
        System.out.println("Welcome to Snap!");
        player.chooseNumOfPlayers();

        if(player.isOnePlayerGame()) {
            onePlayerGame();
        } else {
            twoPlayerGame();
        }

    }
}
