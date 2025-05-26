package com.atyeti.pojo;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private String transactionId;
    private double amount;
    private LocalDate date;
    private String description;

    // Constructors
    public Transaction(String transactionId, double amount, LocalDate date, String description) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // Getters & Setters
    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId);
    }

    @Override
    public String toString() {
        return transactionId + " | " + amount + " | " + date + " | " + description;
    }
}
