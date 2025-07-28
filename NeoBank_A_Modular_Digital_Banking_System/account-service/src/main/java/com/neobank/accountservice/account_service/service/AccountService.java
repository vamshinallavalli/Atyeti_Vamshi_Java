package com.neobank.accountservice.account_service.service;

import com.neobank.accountservice.account_service.dto.AccountRequest;
import com.neobank.accountservice.account_service.dto.AccountResponse;

import java.util.List;

public interface AccountService{
    AccountResponse createAccount(AccountRequest accountRequest);
    AccountResponse getAccountByNumber(String accountNumber);
    List<AccountResponse> getAccountsByUserId(Long userId);
    AccountResponse updateBalance(String accountNumber,Double amount,boolean isCredit);
}