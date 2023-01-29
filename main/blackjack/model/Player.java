package main.blackjack.model;

import java.util.LinkedList;

public class Player {
    private LinkedList<String> dealer = new LinkedList<>();
    private LinkedList<String> player1 = new LinkedList<>();

    private int totalPlayerValue;
    private int totalDealerValue;

    public LinkedList<String> getDealer() {
        return dealer;
    }

    public LinkedList<String> getPlayer1() {
        return player1;
    }

    public int getTotalPlayerValue() {
        return totalPlayerValue;
    }

    public void setTotalPlayerValue(int totalPlayerValue) {
        this.totalPlayerValue = totalPlayerValue;
    }

    public int getTotalDealerValue() {
        return totalDealerValue;
    }

    public void setTotalDealerValue(int totalDealerValue) {
        this.totalDealerValue = totalDealerValue;
    }

}