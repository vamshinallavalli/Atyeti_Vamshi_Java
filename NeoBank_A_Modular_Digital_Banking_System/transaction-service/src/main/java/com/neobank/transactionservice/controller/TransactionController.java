package com.neobank.transactionservice.controller;

import com.neobank.transactionservice.dto.TransactionRequest;
import com.neobank.transactionservice.dto.TransactionResponse;
import com.neobank.transactionservice.entity.Transaction;
import com.neobank.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> transact(@RequestBody TransactionRequest request) {
        TransactionResponse response = transactionService.makeTransaction(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/mini-statement/{accountId}")
    public ResponseEntity<List<Transaction>> getMiniStatement(@PathVariable String accountId) {
        // Logic to fetch recent N transactions
    }
}
