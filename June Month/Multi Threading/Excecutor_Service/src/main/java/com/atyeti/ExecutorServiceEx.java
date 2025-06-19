package com.atyeti;

import java.util.concurrent.Executors;

public class ExecutorServiceEx {
    public static void main(String[] args) {
        java.util.concurrent.ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(() -> System.out.println(ExecutorServiceEx.count()));
        executor.shutdown();

    }

    public static boolean count(){
        for(int i=0;i<999;i++){
            System.out.println(i);
        }
        return false;
    }
}
