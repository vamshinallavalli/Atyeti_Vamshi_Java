package com.atyeti.model;

public abstract class BankUser {
    private long userId;
    private String name;
    private String email;

    public void displayUserInfo(){
        System.out.println("UserId : "+userId+"\n Name : "+name+"\n Email : "+email);
    }

    public abstract void login();
    public abstract void logout();

    public BankUser(long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
