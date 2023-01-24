import java.util.ArrayList;

public class CardGame {
    // variables
    private String name;
    private ArrayList<Card> deckOfCards = new ArrayList<Card>();
    // constructor(s)
    public CardGame(String name) {
        this.name = name;
    }
    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // methods
    public void getDeck() {
        for (Card card: deckOfCards) {
            System.out.println(card);
        }
    }

}
