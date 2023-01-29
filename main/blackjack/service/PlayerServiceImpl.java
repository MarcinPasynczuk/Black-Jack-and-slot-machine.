package main.blackjack.service;

import main.blackjack.model.Player;

public class PlayerServiceImpl extends DeckServiceImpl implements PlayerService{
    private final Player player = new Player();


    public void getPlayer1Cards() {
        System.out.println("Your cards are: " + player.getPlayer1());
    }

    public void getDealerCards() {
        System.out.println("Dealer cards: " + player.getDealer());
    }

    public void firstHands() {
        addCardToDealer();
        addCardToPlayer();
        addCardToDealer();
        addCardToPlayer();
        System.out.println("First dealer card is: " + player.getDealer().get(0));
        System.out.println("Your cards are: " + player.getPlayer1());
    }

    public void addCardToPlayer() {
        player.getPlayer1().add(getDeck().get(0));
        getDeck().remove(0);
    }

    public void showPlayerCard() {
        System.out.println(player.getPlayer1());
    }

    public void showDealerCard() {
        System.out.println(player.getDealer());
    }
    public void addCardToDealer() {
        player.getDealer().add(getDeck().get(0));
        getDeck().remove(0);
    }

    public int getScorePlayer1() {
        player.setTotalPlayerValue(0);
        int aceCount = 0;
        for (String element : player.getPlayer1()) {
            String[] parts = element.split(" ");
            int value;
            if (parts[0].equals("ace")) {
                aceCount++;
                value = 11;
            } else if (parts[0].equals("king") || parts[0].equals("queen") || parts[0].equals("jack")) {
                value = 10;
            } else {
                value = Integer.parseInt(parts[0]);
            }
            player.setTotalPlayerValue(player.getTotalPlayerValue()+value);
            String suit = parts[1];
        }
        while (aceCount > 0 && player.getTotalPlayerValue() > 21) {
            player.setTotalPlayerValue(player.getTotalPlayerValue()-10);
            aceCount--;
        }
        return player.getTotalPlayerValue();
    }

    public int getScoreDealer(){
        player.setTotalDealerValue(0);
        int aceCount = 0;
        for (String element : player.getDealer()) {
            String[] parts = element.split(" ");
            int value;
            if (parts[0].equals("ace")) {
                aceCount++;
                value = 11;
            } else if (parts[0].equals("king") || parts[0].equals("queen") || parts[0].equals("jack")) {
                value = 10;
            } else {
                value = Integer.parseInt(parts[0]);
            }
            player.setTotalDealerValue(player.getTotalDealerValue()+value);
            String suit = parts[1];
        }
        while (aceCount > 0 && player.getTotalDealerValue() > 21) {
            player.setTotalDealerValue(player.getTotalDealerValue()-10);
            aceCount--;
        }
        return player.getTotalDealerValue();
    }

    public void resetAllCards() {
        player.getPlayer1().clear();
        player.getDealer().clear();
    }

    public void split() {
        player.getPlayer1().add(player.getPlayer1().get(1));
        player.getPlayer1().remove(1);
    }


}
