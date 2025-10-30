package org.example.service;

import org.example.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public void transfer(Account from, Account to, BigDecimal amount) {

        Account first = from.getAccountId() < to.getAccountId() ? from : to;
        Account second = from.getAccountId() < to.getAccountId() ? to : from;

        synchronized (first) {
            synchronized (second) {
                if (from.withdraw(amount)) {
                    to.deposit(amount);
                    logger.info("{} transferred {} from {} to {}",
                            Thread.currentThread().getName(), amount, from.getAccountHolder(), to.getAccountHolder());
                } else {
                    logger.warn("{} failed to transfer {} from {} (Insufficient funds)",
                            Thread.currentThread().getName(), amount, from.getAccountHolder());
                }
            }
        }
    }
}