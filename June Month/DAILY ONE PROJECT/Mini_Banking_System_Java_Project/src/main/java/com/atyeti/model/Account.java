package com.atyeti.model;

import com.atyeti.exception.InsufficientFundsException;

public class Account {
    private String accountNumber;
    private double balance;
    private String accountHolderName;

    public Account(String accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void printAccountDetails(){
        System.out.println("Account Details:\nName : "+accountHolderName+"\nAccount Number : "+accountNumber+"\nBalance Available : "+balance);
    }

    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposit of "+amount+" Successful and Current Balance : "+balance);
    }

    public void withdraw(double amount){
        if(balance<amount){
            throw new InsufficientFundsException();
        }
        else{
            balance-=amount;
            System.out.println("Amount "+amount+" Withdraw Successful and Current Balance is: "+this.balance);
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
