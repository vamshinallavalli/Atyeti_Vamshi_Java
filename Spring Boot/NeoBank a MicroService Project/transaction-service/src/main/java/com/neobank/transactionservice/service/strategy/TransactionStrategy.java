package com.neobank.transactionservice.service.strategy;

import com.neobank.transactionservice.dto.TransactionRequest;
import com.neobank.transactionservice.dto.TransactionResponse;

public interface TransactionStrategy {

    TransactionResponse process(TransactionRequest request);
}
