package main.blackjack.model;
import java.util.LinkedList;

public class Deck extends Card {

    private final LinkedList<String> deck = new LinkedList<>();


    public LinkedList<String> getDeck() {
        return deck;
    }
 
    public void setDeck() {
        for (int i = 0; i < getSymbol().length ; i++) {
            for (int j = 0; j < getValue().length; j++) {
                deck.add(getSymbol()[i] + " " + getValue()[j]);
            }
        }

    }
}
