package org.example;

import org.example.model.Account;
import org.example.service.PaymentService;
import org.example.util.TransactionProcessor;

import java.math.BigDecimal;

public class BankingApp {

    public static void main(String[] args) {


        Account alice = new Account("Alice", new BigDecimal("1000.00"));
        Account bob = new Account("Bob", new BigDecimal("800.00"));
        Account charlie = new Account("Charlie", new BigDecimal("1200.00"));


        PaymentService paymentService = new PaymentService();


        TransactionProcessor t1 = new TransactionProcessor(paymentService, alice, bob, new BigDecimal("200.00"));
        TransactionProcessor t2 = new TransactionProcessor(paymentService, bob, charlie, new BigDecimal("300.00"));
        TransactionProcessor t3 = new TransactionProcessor(paymentService, charlie, alice, new BigDecimal("150.00"));
        TransactionProcessor t4 = new TransactionProcessor(paymentService, alice, charlie, new BigDecimal("500.00"));
        TransactionProcessor t5 = new TransactionProcessor(paymentService, bob, alice, new BigDecimal("100.00"));


        Thread thread1 = new Thread(t1, "T1");
        Thread thread2 = new Thread(t2, "T2");
        Thread thread3 = new Thread(t3, "T3");
        Thread thread4 = new Thread(t4, "T4");
        Thread thread5 = new Thread(t5, "T5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("\n=== Final Account Balances ===");
        System.out.println(alice);
        System.out.println(bob);
        System.out.println(charlie);
    }
}
