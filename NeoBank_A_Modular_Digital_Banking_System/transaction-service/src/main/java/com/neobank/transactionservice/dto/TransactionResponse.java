package com.neobank.transactionservice.dto;

import java.time.LocalDateTime;

public class TransactionResponse {
    private String transactionId;
    private String status;
    private LocalDateTime timestamp;
}