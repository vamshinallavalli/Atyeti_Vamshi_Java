package com.neobank.transactionservice.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    private String transactionId;
    private String status;
    private LocalDateTime timestamp;
}