package com.neobank.accountservice.account_service.service;

import com.neobank.accountservice.account_service.dto.AccountRequest;
import com.neobank.accountservice.account_service.dto.AccountResponse;
import com.neobank.accountservice.account_service.entity.Account;
import com.neobank.accountservice.account_service.exception.ResourceNotFoundException;
import com.neobank.accountservice.account_service.exception.InsufficientBalanceException;
import com.neobank.accountservice.account_service.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse createAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .userId(accountRequest.getUserId())
                .accountType(accountRequest.getAccountType())
                .balance(accountRequest.getInitialDeposit())
                .accountNumber(generateUniqueAccountNumber())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Account saved = accountRepository.save(account);
        return mapToResponse(saved);
    }

    @Override
    public AccountResponse getAccountByNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with number: " + accountNumber));
        return mapToResponse(account);
    }

    @Override
    public List<AccountResponse> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse updateBalance(String accountNumber, Double amount, boolean isCredit) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with number: " + accountNumber));

        BigDecimal currentBalance = account.getBalance();
        BigDecimal transactionAmount = BigDecimal.valueOf(amount);

        if (!isCredit && currentBalance.compareTo(transactionAmount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal");
        }

        BigDecimal updatedBalance = isCredit
                ? currentBalance.add(transactionAmount)
                : currentBalance.subtract(transactionAmount);

        account.setBalance(updatedBalance);
        account.setUpdatedAt(LocalDateTime.now());

        Account updated = accountRepository.save(account);
        return mapToResponse(updated);
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            accountNumber = "ACCT" + String.format("%08d", new Random().nextInt(100_000_000));
        } while (accountRepository.findByAccountNumber(accountNumber).isPresent());
        return accountNumber;
    }

    private AccountResponse mapToResponse(Account account) {
        AccountResponse response = new AccountResponse();
        response.setAccountNumber(account.getAccountNumber());
        response.setBalance(account.getBalance());
        response.setAccountType(account.getAccountType());
        return response;
    }
}