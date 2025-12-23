package com.Practice.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceWithFixedThreadPool {

	    public static void main(String[] args) {
	        // Create a thread pool with 10 threads
	        ExecutorService executor = Executors.newFixedThreadPool(10);

	        // Submit 10 tasks to the executor
	        for (int i = 1; i <= 20; i++) {
	            final int taskId = i;  // Need final or effectively final for lambda
	            executor.submit(() -> {
	                String threadName = Thread.currentThread().getName();
	                System.out.println("Task " + taskId + " is executed by " + threadName);

	                try {
	                    // Simulate some work with sleep
	                    Thread.sleep(500);
	                } catch (InterruptedException e) {
	                    Thread.currentThread().interrupt();
	                }
	            });
	        }

	        // Shutdown the executor gracefully
	        executor.shutdown();
	    }
	}
