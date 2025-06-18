package com.atyeti.model;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber,String accountHolderName,double balance,double interestRate) {
        super(accountNumber, balance, accountHolderName);
        this.interestRate=interestRate;
    }


    public void applyInterest() {
       double newBalance =getBalance()+getBalance() * interestRate / 100;
       setBalance(newBalance);
    }
}
