package main.blackjack.service;

import main.blackjack.model.Deck;

import java.util.Collections;

public class DeckServiceImpl extends Deck implements DeckService {


    public void shuffle() {
        for (int i = 0; i < 6; i++) {
        setDeck();
        }
        Collections.shuffle(getDeck());
    }

    public void addMoreCardsIfNeeded() {
        if (getDeck().size() < 30) {
            setDeck();
            Collections.shuffle(getDeck());
        }
    }
   }
