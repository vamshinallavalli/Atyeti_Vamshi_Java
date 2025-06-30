package com.atyeti.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends BankUser{
    private List<Account> accounts;
    public Customer(long userId, String name, String email) {
        super(userId, name, email);
        this.accounts=new ArrayList<>();
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }
}
