import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    // variables
    private String name;
    private ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private final String[] suits = {"♦", "♣", "❤", "♠"};
    private final String[] symbols = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private final int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    private String ANSI_RESET = "\u001B[0m";
    private String ANSI_CYAN = "\u001B[36m";
    private String ANSI_PURPLE = "\u001B[35m";
    private String ANSI_RED = "\u001B[31m";
    private String ANSI_GREEN_BACKGROUND = "\u001B[42m";


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


    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public String[] getSuits() {
        return suits;
    }

    public String getANSI_RESET() {
        return ANSI_RESET;
    }

    public String getANSI_CYAN() {
        return ANSI_CYAN;
    }

    public String getANSI_PURPLE() {
        return ANSI_PURPLE;
    }

    public String getANSI_GREEN_BACKGROUND() {
        return ANSI_GREEN_BACKGROUND;
    }

    public String getANSI_RED() {
        return ANSI_RED;
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
        Card dealtCard = deckOfCards.get(0);
        deckOfCards.remove(0);
        return dealtCard;
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards, new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                return Integer.valueOf(o1.getValue()).compareTo(o2.getValue());
            }
        });
        System.out.println(deckOfCards);
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(deckOfCards, new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                return String.valueOf(o1.getSuit()).compareTo(o2.getSuit());
            }
        });
        System.out.println(deckOfCards);
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
//        System.out.println(deckOfCards);
        return deckOfCards;
    }
}
