import java.util.Scanner;

public class Player {

    private boolean isOnePlayerGame;
    private boolean userHasChosen = false;

    public void Player() {

    }

    public boolean isOnePlayerGame() {
        return isOnePlayerGame;
    }

    public void setOnePlayerGame(boolean onePlayerGame) {
        isOnePlayerGame = onePlayerGame;
    }

    public boolean isUserHasChosen() {
        return userHasChosen;
    }

    public void setUserHasChosen(boolean userHasChosen) {
        this.userHasChosen = userHasChosen;
    }

    public void chooseNumOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to for a single player game");
        System.out.println("Press 2 for a two player game");
        String playerChoice = scanner.nextLine();

        while(!userHasChosen){
            if(playerChoice.equals("1")) {
                this.isOnePlayerGame = true;
                this.userHasChosen = true;
                break;
            } else if (playerChoice.equals("2")) {
                this.isOnePlayerGame = false;
                this.userHasChosen = true;
                break;
            } else {
                System.out.println("please choose from the options above");
                chooseNumOfPlayers();
            }

        }
    }

}
