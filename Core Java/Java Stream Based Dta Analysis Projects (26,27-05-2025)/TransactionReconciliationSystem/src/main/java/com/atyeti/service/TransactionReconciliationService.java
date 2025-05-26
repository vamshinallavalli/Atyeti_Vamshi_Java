package com.atyeti.service;

import com.atyeti.pojo.Transaction;
import com.atyeti.util.TransactionMismatchReason;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransactionReconciliationService {

    public Map<String, List<Transaction>> reconcile(List<Transaction> bankTransactions, List<Transaction> customerTransactions) {
        Map<String, List<Transaction>> mismatches = new HashMap<>();

        // Convert lists to maps for easier lookup
        Map<String, Transaction> bankMap = bankTransactions.stream()
                .collect(Collectors.toMap(Transaction::getTransactionId, Function.identity()));

        Map<String, Transaction> customerMap = customerTransactions.stream()
                .collect(Collectors.toMap(Transaction::getTransactionId, Function.identity()));

        List<Transaction> amountMismatches = new ArrayList<>();
        List<Transaction> missingInBank = new ArrayList<>();
        List<Transaction> missingInCustomer = new ArrayList<>();

        // Check from customer perspective
        for (Transaction custTxn : customerTransactions) {
            Transaction bankTxn = bankMap.get(custTxn.getTransactionId());
            if (bankTxn == null) {
                missingInBank.add(custTxn);
            } else if (Double.compare(custTxn.getAmount(), bankTxn.getAmount()) != 0) {
                amountMismatches.add(custTxn);
            }
        }

        // Check from bank perspective
        for (Transaction bankTxn : bankTransactions) {
            if (!customerMap.containsKey(bankTxn.getTransactionId())) {
                missingInCustomer.add(bankTxn);
            }
        }

        // Populate result map
        if (!amountMismatches.isEmpty())
            mismatches.put(TransactionMismatchReason.AMOUNT_MISMATCH, amountMismatches);

        if (!missingInBank.isEmpty())
            mismatches.put(TransactionMismatchReason.MISSING_IN_BANK, missingInBank);

        if (!missingInCustomer.isEmpty())
            mismatches.put(TransactionMismatchReason.MISSING_IN_CUSTOMER, missingInCustomer);

        return mismatches;
    }
}
