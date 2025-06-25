package com.atyeti;

public class ThreadCreation extends Thread{
    public static void main(String[] args) {
        ThreadCreation t=new ThreadCreation();
        t.start();
    }

    public void run(){
        System.out.println("Using Thread!");
    }
}
