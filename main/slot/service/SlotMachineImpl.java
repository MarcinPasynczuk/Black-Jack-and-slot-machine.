package main.slot.service;
import main.bank.service.BankServiceImpl;
import main.slot.model.SlotMachineBase;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class SlotMachineImpl extends SlotMachineBase implements SlotMachine{

    Scanner scanner = new Scanner(System.in);
    SlotMachineBase slotMachineBase = new SlotMachineBase();
    private final String[] reels = new String[3];

    private final BankServiceImpl bankService = new BankServiceImpl();
    public void playSlotMachine(){
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


    public void playNewGame() {
        this.setCredit();
        System.out.println("1 to auto spin all credit, 2 to single spin.");
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> autoSpin();
            case "2" -> singleSpin();
            default -> validation();
        }
    }

    private void spin() {
        for (int i = 0; i < getNumOfReels(); i++) {
            Random random = new Random();
            int symbolIndex = random.nextInt(getSymbols().length);
            reels[i] = getSymbols()[symbolIndex];
                    }
        System.out.println(Arrays.toString(reels));
        bankService.setCreditNumber(bankService.getCreditNumber()-1);
        if (Objects.equals(reels[0], reels[1]) && Objects.equals(reels[1], reels[2])){
            System.out.println("Congratulations!!! You won!");
            switch (reels[0]) {
                case "cherry" -> bankService.addMoney(17* bankService.getCreditMoney());
                case "lemon" -> bankService.addMoney(27* bankService.getCreditMoney());
                case "orange" -> bankService.addMoney(37* bankService.getCreditMoney());
                case "plum" -> bankService.addMoney(47* bankService.getCreditMoney());
                case "bell" -> bankService.addMoney(57* bankService.getCreditMoney());
                case "bar" -> bankService.addMoney(67* bankService.getCreditMoney());
                case "seven" -> bankService.addMoney(77* bankService.getCreditMoney());
                default -> validation();
            }

        }
    }

    private void setCredit(){
        System.out.println("How many spins do you want to play?");
        try {
            String input = scanner.nextLine();
            int betAmount = Integer.parseInt(input);
            bankService.setCreditNumber(betAmount);
        } catch(NumberFormatException e){
            System.out.println("Wrong pattern. Please enter a valid number.");
            setCredit();
        }

            System.out.println("How much do you want to put on 1 spin?");
            try {
                String input = scanner.nextLine();
                double betAmount = Double.parseDouble(input);
                if (betAmount* bankService.getCreditNumber() > bankService.showBalance()){
                    System.out.println("You don't have enough money.");
                    setCredit();
                }else{
                    bankService.setCreditMoney(betAmount);
                    bankService.addMoney(-(bankService.getCreditMoney())* bankService.getCreditNumber());
                    howManySpinsLeft();
                }
            } catch(NumberFormatException e){
                System.out.println("Wrong pattern. Please enter a valid number.");
                setCredit();
            }

     }

    private void validation() {
        System.out.println("Invalid input, please enter a valid option.");
    }

    private void showRules(){
        System.out.println("You have 7 symbols of 7 different values: cherry(17), lemon(27), orange(37), plum(47), bell(57), bar(67), seven(77). If you hit 3 symbols in a row you will win your bet * amount in parentheses.");
    }

    private void howManySpinsLeft(){
        System.out.println("You have " + bankService.getCreditNumber() + " spins for " + bankService.getCreditMoney() + " each.");
    }

    private void printBalance(){
        System.out.println("Your balance is: " + bankService.showBalance() + ".");
    }

    private void depositCreditToBankAccount(){
        bankService.addMoney(bankService.getCreditMoney()*bankService.getCreditNumber());
        bankService.setCreditNumber(0);
        bankService.setCreditMoney(0);
    }

    private void playMoreOrStop() {
        System.out.println("1 to new spin, 2 to exit.");
        String input = scanner.nextLine();
        switch(input)
        {
            case "1":
                if (bankService.getCreditNumber()==0){
                    return;
                }
                break;
            case "2":
                depositCreditToBankAccount();
                break;
            default:
                validation();
        }

    }

    private void singleSpin() {
        for (int i = 0; 0 < bankService.getCreditNumber(); i++) {
            spin();
            howManySpinsLeft();
            playMoreOrStop();
            if (bankService.getCreditNumber()==0){
                break;
            }
        }
        printBalance();
        howManySpinsLeft();
    }

    private void autoSpin(){
        for (int i = 0; 0 < bankService.getCreditNumber(); i++) {
            spin();
            howManySpinsLeft();
        }
        printBalance();
        howManySpinsLeft();
    }


}
