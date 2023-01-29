package main.blackjack.service;

public interface PlayerService {
    void firstHands();
    void addCardToPlayer();
    void showPlayerCard();
    int getScorePlayer1();
    int getScoreDealer();
    void addCardToDealer();
    void resetAllCards();

}
