package main.bank.service;
public interface BankService{

    void addMoney(double howMuch);
    double showBalance();
    double checkBetAmount();
    void putBetAmount(double betAmount);
}
