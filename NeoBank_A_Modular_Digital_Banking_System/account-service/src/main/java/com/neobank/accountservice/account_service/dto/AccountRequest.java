package com.neobank.accountservice.account_service.dto;

import com.neobank.accountservice.account_service.entity.AccountType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequest {
    private Long userId;
    private AccountType accountType;
    private BigDecimal initialDeposit;
}