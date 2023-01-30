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
                System.out.println(getANSI_RED() + "Ahh you weren't quick enough! Better luck next time" + getANSI_RESET());

            }
        };
        timer.schedule(task, 2000);
        String playerEntersSnap = scanner.nextLine();
        timer.cancel();

        if(playerEntersSnap.equalsIgnoreCase("snap")) {
            System.out.println(getANSI_GREEN_BACKGROUND() + "You win! End of game." + getANSI_RESET());
        } else {
            System.out.println(getANSI_RED() + "You did it wrong! Better luck next time" + getANSI_RESET());
        }
    }

    public void onePlayerGame() {
        System.out.println("Ready to play Snap?");
        super.shuffleDeck();

        Card firstDealtCard = super.dealCard();
        Card secondDealtCard = super.dealCard();

        playerTakesTurn();
        System.out.println(getANSI_PURPLE() + "Card one: " + firstDealtCard + getANSI_RESET());
        while (!hasMatchingSymbol) {
            playerTakesTurn();
            System.out.println(getANSI_CYAN() + "Card one: " + firstDealtCard + getANSI_RESET());
            System.out.println(getANSI_PURPLE() + "Card two: " + secondDealtCard + getANSI_RESET());
            System.out.println(" ");

            if(firstDealtCard.getSymbol().equals(secondDealtCard.getSymbol())) {
            hasMatchingSymbol = true;
                System.out.println(getANSI_GREEN_BACKGROUND() + "SNAP!" + getANSI_RESET());
            break;
             }
            else {
                firstDealtCard = secondDealtCard;
                secondDealtCard = super.dealCard();
            }

            if(super.getDeckOfCards().size() == 0) {
                super.createDeck();
                super.shuffleDeck();
            }
        }

    }

    public void twoPlayerGame() {
        System.out.println("Ready to play Snap?");
        super.shuffleDeck();
        System.out.println("Take it in turns to deal a card by pressing enter.");
        System.out.println("When you see two cards with matching symbols, you have 2 seconds to say snap to win!");

        Card firstDealtCard = super.dealCard();
        Card secondDealtCard = super.dealCard();

        playerTakesTurn();
        System.out.println("Card one: " + firstDealtCard);
        while (!hasMatchingSymbol) {
            playerTakesTurn();
            System.out.println("Card one: " + firstDealtCard + " ¦ Card two: " + secondDealtCard);
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

            if(super.getDeckOfCards().size() == 0) {
                super.createDeck();
                super.shuffleDeck();
            }
        }
    }

    public void game() {
        System.out.println(super.getANSI_GREEN_BACKGROUND() + "Welcome to Snap!" + super.getANSI_RESET());
        player.chooseNumOfPlayers();

        if(player.isOnePlayerGame()) {
            onePlayerGame();
        } else {
            twoPlayerGame();
        }

    }
}
