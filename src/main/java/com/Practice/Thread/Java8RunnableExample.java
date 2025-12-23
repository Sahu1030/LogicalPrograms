package com.Practice.Thread;

public class Java8RunnableExample {
    public static void main(String[] args) {
        // Using a lambda expression (Java 8 style)
        Runnable task = () -> {
            System.out.println("Thread is running (Java 8): " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}