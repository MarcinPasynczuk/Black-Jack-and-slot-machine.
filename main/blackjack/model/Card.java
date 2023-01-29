package main.blackjack.model;

public class Card {
    private final String[] value = {"spades","hearts","diamonds","clubs"};
    private final String[] symbol = {"ace","2","3","4","5","6","7","8","9","10","jack","queen","king"};


    public String[] getValue() {
        return value;
    }
    public String[] getSymbol() {
        return symbol;
    }
}
