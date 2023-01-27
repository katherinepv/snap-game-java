import java.util.Scanner;

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
        System.out.println("two player game here");
    }

    public void game() {
        player.chooseNumOfPlayers();

        if(player.isOnePlayerGame()) {
            onePlayerGame();
        } else {
            twoPlayerGame();
        }

    }
}
