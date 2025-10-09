package org.example.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.model.Account;
import org.example.service.PaymentService;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
public class TransactionProcessor implements Runnable{
    private PaymentService paymentService;
    private Account from;
    private Account to;
    private BigDecimal amount;

    public void run(){
        paymentService.transfer(from,to,amount);
    }
}
