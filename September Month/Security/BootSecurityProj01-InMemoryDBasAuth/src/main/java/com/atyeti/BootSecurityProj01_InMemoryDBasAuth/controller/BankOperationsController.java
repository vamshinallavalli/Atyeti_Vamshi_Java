package com.atyeti.BootSecurityProj01_InMemoryDBasAuth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import java.util.Random;

@Controller
public class BankOperationsController {

    @GetMapping("/")
    public String showHome() {
        return "index";   // maps to index.jsp
    }

    @GetMapping("/offers")
    public String showOffers() {
        return "offers";  // maps to offers.jsp
    }

    @GetMapping("/balance")
    public String showBalance(Map<String, Object> map) {
        map.put("balance", new Random().nextInt(200000));
        return "balance"; // maps to balance.jsp
    }

    @GetMapping("/loanApprove")
    public String performLoanApprove(Map<String, Object> map) {
        map.put("amount", new Random().nextInt(200000));
        return "loanApprove"; // maps to loanApprove.jsp
    }
}