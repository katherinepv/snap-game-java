import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.*;

public class CardGame {
    // variables
    private String name;
    private ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private final String[] suits = {"♦", "♣", "❤", "♠"};
    private final String[] symbols = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private final int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};

    // constructor(s)
    public CardGame(String name) {
        this.name = name;
        this.createDeck();
    }
    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // methods
    public void createDeck() {
        for (String suit : suits) {
            for (int j = 0; j < symbols.length; j++) {
                deckOfCards.add(new Card(suit, symbols[j], values[j]));
            }
        }
    }
    public void getDeck() {
        for (Card card: deckOfCards) {
            System.out.println(card);
        }
    }
    public Card dealCard() {
        return deckOfCards.get(0);
    }

//    public ArrayList<Card> sortDeckInNumberOrder() {
//
//    }
//    public ArrayList<Card> sortDeckIntoSuits() {
//
//    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        System.out.println(deckOfCards);
        return deckOfCards;
    }
//    public ArrayList<Card> shuffleDeck() {
//        return Collections.shuffle(deckOfCards);
//    }
}
