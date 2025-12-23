package com.Practice.Thread;

public class SequentialThreads {

	   public static void main(String[] args) throws InterruptedException {
	        Thread t1 = new Thread(() -> System.out.println("Thread 1 completed"));
	        Thread t2 = new Thread(() -> System.out.println("Thread 2 completed"));
	        Thread t3 = new Thread(() -> System.out.println("Thread 3 completed"));

	        t1.start();
	        t1.join();  // Wait until t1 finishes

	        t2.start();
	        t2.join();  // Wait until t2 finishes

	        t3.start();
	        t3.join();  // Wait until t3 finishes

	        System.out.println("All threads completed in order");
	    }

}
