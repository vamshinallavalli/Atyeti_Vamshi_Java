package org.example.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class Account {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1000);
    private final long accountId;
    private final String accountHolder;
    private BigDecimal balance;

    public Account(String accountHolder, BigDecimal balance) {
        this.accountId = ID_GENERATOR.getAndIncrement();
        this.accountHolder = accountHolder;
        this.balance = balance != null ? balance : BigDecimal.ZERO;
    }


    public synchronized boolean withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Amount Must be Positive!");
            return false;
        }
        if (amount.compareTo(balance) > 0) {
            System.out.println("Insufficient Funds for " + accountHolder + "!");
            return false;
        }
        balance = balance.subtract(amount);
        return true;
    }


    public synchronized void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Amount Must be Positive!");
            return;
        }
        balance = balance.add(amount);
    }
}