package com.neobank.transactionservice.dto;

import com.neobank.transactionservice.entity.TransactionType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest {
    private String accountFrom;
    private String accountTo;
    private BigDecimal amount;
    private TransactionType type;
}
