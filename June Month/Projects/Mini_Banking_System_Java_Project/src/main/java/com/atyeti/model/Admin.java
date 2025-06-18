package com.atyeti.model;

public class Admin extends BankUser{
    public Admin(long userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }
}
