package com.neobank.transactionservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_account_id")
    private String accountFrom;

    @Column(name = "to_account_id")
    private String accountTo;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @Column(name = "transaction_date")
    private LocalDateTime timestamp;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;
}