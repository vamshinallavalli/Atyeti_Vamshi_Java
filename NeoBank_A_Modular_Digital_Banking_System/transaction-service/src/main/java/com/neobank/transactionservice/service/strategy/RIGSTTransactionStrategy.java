package com.neobank.transactionservice.service.strategy;

import com.neobank.transactionservice.dto.TransactionRequest;
import com.neobank.transactionservice.dto.TransactionResponse;
import com.neobank.transactionservice.entity.Transaction;
import com.neobank.transactionservice.entity.TransactionType;
import com.neobank.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class RIGSTTransactionStrategy implements TransactionStrategy {

    @Autowired
    private TransactionRepository repository;

    @Override
    public TransactionResponse process(TransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setAccountFrom(request.getAccountFrom());
        transaction.setAccountTo(request.getAccountTo());
        transaction.setAmount(request.getAmount());
        transaction.setTransactionType(TransactionType.RIGS);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("SUCCESS");

        repository.save(transaction);

        TransactionResponse response = new TransactionResponse();
        response.setTransactionId(UUID.randomUUID().toString());
        response.setStatus("SUCCESS");
        response.setTimestamp(transaction.getTimestamp());

        return response;
    }
}