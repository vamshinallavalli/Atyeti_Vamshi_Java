package com.neobank.transactionservice.service;

import com.neobank.transactionservice.dto.TransactionRequest;
import com.neobank.transactionservice.dto.TransactionResponse;
import com.neobank.transactionservice.entity.Transaction;

import java.util.List;

public interface TransactionService {
    TransactionResponse makeTransaction(TransactionRequest request);
    List<Transaction> getMiniStatement(String accountId);

    List<Transaction> getAllTransactions();
}