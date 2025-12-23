package com.Practice.Thread;

public class Java7RunnableExample {
    public static void main(String[] args) {
        // Using an anonymous inner class (Java 7 style)
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running (Java 7): " + Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}


