import java.util.Arrays;

public class Card {
    // variables
    private String suit;
    private String symbol;
    private int value;
    private String[] suits = {"♦", "♣", "❤", "♠"};
    private String[] symbols = new String[]{"2", "3","4","5","6","7","8","9","10","J","Q","K","A"};
    private int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};

    // constructor
    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    // getters and setters

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    // methods


    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", symbol='" + symbol + '\'' +
                ", value=" + value +
                '}';
    }
}
