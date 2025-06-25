package com.atyeti;

public class ThreadUsingRunnable implements Runnable{
    public static void main(String[] args) {
        ThreadUsingRunnable runnable=new ThreadUsingRunnable();
        Thread t=new Thread(runnable);
        t.start();

    }
    @Override
    public void run() {
        System.out.println("Thread Created Using Runnable!");
    }
}
