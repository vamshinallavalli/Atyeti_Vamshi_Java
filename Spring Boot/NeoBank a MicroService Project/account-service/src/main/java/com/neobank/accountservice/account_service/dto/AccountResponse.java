package com.neobank.accountservice.account_service.dto;

import com.neobank.accountservice.account_service.entity.AccountType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class AccountResponse {
    private String accountNumber;
    private BigDecimal balance;
    private AccountType accountType;
}
