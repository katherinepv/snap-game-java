import java.util.Scanner;

public class Snap extends CardGame {
    Scanner scanner = new Scanner(System.in);
    public Snap(String name) {
        super(name);
    }

    public String playerTakesTurn() {
        String playerInput = scanner.nextLine();
        return playerInput;
    }


    public void game() {
        System.out.println("Ready to play Snap?");
        super.shuffleDeck();


//        while(!firstDealtCard.getSymbol().equals(secondDealtCard.getSymbol())) {
            if(playerTakesTurn().equals("")){

                playerTakesTurn();
                Card firstDealtCard = super.dealCard();
                System.out.println("Card one: " + firstDealtCard);
                playerTakesTurn();
                Card secondDealtCard = super.dealCard();
                System.out.println("Card two: " + secondDealtCard);

                if(firstDealtCard.getSymbol().equals(secondDealtCard.getSymbol())) {
                    System.out.println("Say snap!");
                    scanner.nextLine();

                    if(playerTakesTurn().equals("snap")) {
                        System.out.println("you win");
                    }
                } else {
                    firstDealtCard = secondDealtCard;
                    secondDealtCard = super.dealCard();
                }
            }
        }
//    }
}
