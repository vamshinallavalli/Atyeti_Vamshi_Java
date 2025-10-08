package com.neobank.accountservice.account_service.controller;

import com.neobank.accountservice.account_service.dto.AccountRequest;
import com.neobank.accountservice.account_service.dto.AccountResponse;
import com.neobank.accountservice.account_service.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest request) {
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountByNumber(accountNumber));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AccountResponse>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(accountService.getAccountsByUserId(userId));
    }

    @PutMapping("/{accountNumber}/balance")
    public ResponseEntity<AccountResponse> updateBalance(
            @PathVariable String accountNumber,
            @RequestParam Double amount,
            @RequestParam boolean isCredit
    ) {
        return ResponseEntity.ok(accountService.updateBalance(accountNumber, amount, isCredit));
    }
}
