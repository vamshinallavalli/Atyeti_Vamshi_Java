package com.atyeti;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEx {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(50);
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
