package com.atyeti.model;

import com.atyeti.exception.InsufficientFundsException;

public class CurrentAccount extends Account{
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, String accountHolderName,double overdraftLimit) {
        super(accountNumber, balance, accountHolderName);
        this.overdraftLimit=overdraftLimit;
    }

    public void withdraw(double amount) {
        try {
            if (amount > getBalance() + overdraftLimit) {
                throw new InsufficientFundsException("Withdraw exceeds overdraft limit.");
            }

            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: " + amount + ", Remaining Balance: " + getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }

}
