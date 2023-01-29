package main.bank.model;

public class Bank {
    private double accountBalance = 10000;
    private double betMoney;

    private int creditNumber;
    private double creditMoney;

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(double betMoney) {
        this.betMoney = betMoney;
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }

    public double getCreditMoney() {
        return creditMoney;
    }

    public void setCreditMoney(double creditMoney) {
        this.creditMoney = creditMoney;
    }
}
