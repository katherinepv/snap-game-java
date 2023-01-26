import java.util.Scanner;

public class Snap extends CardGame {
    Scanner scanner = new Scanner(System.in);
    public Snap(String name) {
        super(name);
    }

    public void game() {
        System.out.println("Ready to play Snap?");
        super.shuffleDeck();
        String playerInput = scanner.nextLine();

        Card firstDealtCard = super.dealCard();
        Card secondDealtCard = super.dealCard();

        if(playerInput.equals("")){
            System.out.println("Card one: " + firstDealtCard + " ¦ Card two: " + secondDealtCard );
        }

    }
}
