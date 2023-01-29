package main.bank.service;

import main.bank.model.Bank;
import main.bank.service.BankService;

public class BankServiceImpl implements BankService {

    private final Bank bank = new Bank();

    public void addMoney(double howMuch) {
        bank.setAccountBalance(bank.getAccountBalance() + howMuch);
    }

    public double showBalance(){
        return bank.getAccountBalance();
    }

    public double checkBetAmount(){
        return bank.getBetMoney();
    }

    public void putBetAmount(double betAmount){
        bank.setBetMoney(betAmount);
    }

    public int getCreditNumber() {
        return bank.getCreditNumber();
    }

    public void setCreditNumber(int creditNumber) {
        bank.setCreditNumber(creditNumber);
    }

    public double getCreditMoney() {
        return bank.getCreditMoney();
    }

    public void setCreditMoney(double creditMoney) {
        bank.setCreditMoney(creditMoney);
    }
}
