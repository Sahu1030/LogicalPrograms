package com.Practice.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableJava7Example {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = new Callable<String>() {
            @Override
            public String call() {
                return "Callable result from thread (Java 7): " + Thread.currentThread().getName();
            }
        };

        Future<String> future = executor.submit(task);
        System.out.println(future.get());

        executor.shutdown();
    }
}
