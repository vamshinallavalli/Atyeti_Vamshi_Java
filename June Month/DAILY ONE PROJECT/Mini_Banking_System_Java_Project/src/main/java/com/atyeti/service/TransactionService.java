package com.atyeti.service;

import com.atyeti.exception.InsufficientFundsException;
import com.atyeti.exception.InvalidAccountException;
import com.atyeti.model.Account;

public interface TransactionService {
    void deposit(Account account, double amount);
    void withdraw(Account account,double amount) throws InsufficientFundsException;
    void transfer(Account from,Account to,double amount) throws InsufficientFundsException, InvalidAccountException;
}
