package com.neobank.accountservice.account_service.dto;

import com.neobank.accountservice.account_service.entity.AccountType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Data
@Setter
@Getter
public class AccountRequest {
    private Long userId;
    private AccountType accountType;
    private BigInteger initialDeposit;
}
