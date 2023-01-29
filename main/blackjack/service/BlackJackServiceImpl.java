package main.blackjack.service;
import main.bank.service.BankServiceImpl;

import java.util.Scanner;

public class BlackJackServiceImpl implements BlackJackService{
    private final PlayerServiceImpl player = new PlayerServiceImpl();
    private final BankServiceImpl bankService = new BankServiceImpl();
    Scanner scanner = new Scanner(System.in);



    public void playBlackJack() {
        player.shuffle();
        while (true) {
            System.out.println("1 to play a new game, 2 for rules, 3 to show your balance or 0 to exit.");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> playNewGame();
                case "2" -> showRules();
                case "3" -> System.out.println(bankService.showBalance());
                case "0" -> System.exit(0);
                default -> validation();
            }
        }
    }

    private void playNewGame() {
        player.addMoreCardsIfNeeded();
        putABet();
        player.firstHands();
        checkIfBJ();
        if (player.getScorePlayer1() == 0) {
            return;
        }
        while (true) {
            System.out.println("1 to hit, 2 to stand, 3 to double.");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    player.addCardToPlayer();
                    player.showPlayerCard();
                    if (player.getScorePlayer1() > 21) {
                        System.out.println("More than 21 (" + player.getScorePlayer1() + "), game over.");
                        loseAbet();
                        player.resetAllCards();
                        return;
                    }
                                    }
                case "2" -> {
                    dealerIsPlaying();
                    checkForWin();
                    return;
                }
                case "3" -> {
                    doubleDown();
                    return;
                }
                case "4" -> player.split();
                default -> validation();
            }
        }

    }

    private void checkForWin() {
        if (player.getScorePlayer1() > player.getScoreDealer()) {
            System.out.println("Your score is: " + player.getScorePlayer1() + ". Dealer score is: "+ player.getScoreDealer() + ". You win.");
            winABet();
            player.resetAllCards();
     }
        if (player.getScorePlayer1() == player.getScoreDealer() && player.getScorePlayer1()!=0) {
            System.out.println("Your score is: " + player.getScorePlayer1() + ". Dealer score is: "+ player.getScoreDealer() + ". You draw.");
            drawABet();
            player.resetAllCards();
        }
        if (player.getScorePlayer1() < player.getScoreDealer() && 22 > player.getScoreDealer()) {
            System.out.println("Your score is: " + player.getScorePlayer1() + ". Dealer score is: " + player.getScoreDealer() + ". You lost.");
            loseAbet();
            player.resetAllCards();
  }

    }
    private void showRules(){
        System.out.println("Blackjack hands are scored by their point total. The hand with the highest total wins as long as it doesn't exceed 21; a hand with a higher total than 21 is said to bust. Cards 2 through 10 are worth their face value, and face cards (jack, queen, king) are also worth 10. An ace's value is 11 unless this would cause the player to bust, in which case it is worth 1. ");
    }

    private void putABet(){
        System.out.println("How much do you want to bet?");
        try {
            String input = scanner.nextLine();
            double betAmount = Double.parseDouble(input);
            if (betAmount > bankService.showBalance()){
                System.out.println("You don't have enough money.");
                putABet();
            }else{
                bankService.putBetAmount(betAmount);
                System.out.println("Your bet of "+betAmount+" has been placed.");
            }
        } catch(NumberFormatException e){
            System.out.println("Wrong pattern. Please enter a valid number.");
            putABet();
        }
    }

    private void winABet(){
        System.out.println("Congratulation you won: " + bankService.checkBetAmount()+ ".");
        bankService.addMoney(bankService.checkBetAmount());
        bankService.putBetAmount(-bankService.checkBetAmount());
    }

    private void loseAbet(){
        System.out.println("Loss: -" + bankService.checkBetAmount()+ ".");
        bankService.addMoney(-bankService.checkBetAmount());
        bankService.putBetAmount(-bankService.checkBetAmount());
    }

    private void drawABet(){
        System.out.println("Draw.");
        bankService.putBetAmount(-bankService.checkBetAmount());
    }

    private void winABJ(){
        System.out.println("Congratulation it is A Black Jack! You won: " + 1.5*bankService.checkBetAmount()+ ".");
        bankService.addMoney((int) (1.5*bankService.checkBetAmount()));
        bankService.putBetAmount(-bankService.checkBetAmount());
    }

    private void doubleDown(){
        System.out.println("Double! Good luck!");
        bankService.putBetAmount(bankService.checkBetAmount());
        player.addCardToPlayer();
        player.showPlayerCard();
        checkIfNotMoreThan21OnPlayerHand();
        if (bankService.checkBetAmount()>0){
        dealerIsPlaying();
         checkForWin();
        }
    }

    private void dealerIsPlaying(){
        while (player.getScoreDealer() < 18) {
            player.addCardToDealer();
            player.showDealerCard();
            if (player.getScoreDealer() > 21) {
                System.out.println("Your score is: " + player.getScorePlayer1() + ". Dealer score is: "+ player.getScoreDealer() + ". You win.");
                winABet();
                player.resetAllCards();
                break;
            }
        }
    }

    private void checkIfNotMoreThan21OnPlayerHand(){
        if (player.getScorePlayer1() > 21) {
            System.out.println("More than 21 (" + player.getScorePlayer1() + "), game over.");
            loseAbet();
            player.resetAllCards();
        }
    }

    private void checkIfBJ() {
        if (player.getScorePlayer1() == 21) {
            System.out.println("Blackjack! Congratulations!");
            winABJ();
            player.resetAllCards();
        }
    }

    private void validation() {
        System.out.println("Invalid input, please enter a valid option.");
    }
}


