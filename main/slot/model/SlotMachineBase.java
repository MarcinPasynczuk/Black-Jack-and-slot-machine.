package main.slot.model;

public class SlotMachineBase {

    private final String[] symbols = {"cherry", "lemon", "orange", "plum", "bell", "bar", "seven"};
    private final int[] payouts = {0, 1, 2, 3, 4, 5, 6, 7};
    private final int numOfReels = 3;

    public String[] getSymbols() {
        return symbols;  
    }

    public int[] getPayouts() {
        return payouts;
    }

    public int getNumOfReels() {
        return numOfReels;
    }
}



