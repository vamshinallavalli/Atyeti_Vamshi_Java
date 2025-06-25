package com.atyeti;

import java.util.logging.Logger;

public class ThreadLifeCycle extends Thread{
    //static Logger logger=Logger.getLogger(ThreadLifeCycle.class.getName());
    public static void main(String[] args) throws InterruptedException{
        ThreadLifeCycle t=new ThreadLifeCycle();
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        Thread.sleep(10000);
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());
    }
    public void run(){
        System.out.println("Running in"+Thread.currentThread().getName());
    }
}
