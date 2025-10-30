package com.neobank.transactionservice.service.impl;

import com.neobank.transactionservice.dto.TransactionRequest;
import com.neobank.transactionservice.dto.TransactionResponse;
import com.neobank.transactionservice.entity.Transaction;
import com.neobank.transactionservice.repository.TransactionRepository;
import com.neobank.transactionservice.service.TransactionService;
import com.neobank.transactionservice.service.strategy.TransactionStrategy;
import com.neobank.transactionservice.service.strategy.TransactionStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionStrategyFactory strategyFactory;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  TransactionStrategyFactory strategyFactory) {
        this.transactionRepository = transactionRepository;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public TransactionResponse makeTransaction(TransactionRequest request) {
        TransactionStrategy strategy = strategyFactory.getStrategy(request.getType());
        return strategy.process(request);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


    @Override
    public List<Transaction> getMiniStatement(String accountId) {
        return transactionRepository.findTop10ByAccountFromOrAccountToOrderByTimestampDesc(accountId, accountId);
    }
}