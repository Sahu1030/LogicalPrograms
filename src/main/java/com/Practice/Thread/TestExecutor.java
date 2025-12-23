package com.Practice.Thread;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutor {

	public TestExecutor() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor=Executors.newFixedThreadPool(5);
		
//		Callable<String> c=new Callable<String>() {
//			
//			@Override
//			public String call() throws Exception {
//				// TODO Auto-generated method stub
//				return Thread.currentThread().getName();
//			}
//		};
//		
//		for(int i=0;i<10;i++) {
//			Future<String> f= service.submit(c);
//			System.out.println(f.get());
//			
//		}
		for(int i=0;i<10;i++) {
			executor.submit(()->{
			
			System.err.println(Thread.currentThread().getName());
		});
		}
		for (int i = 1; i <= 10; i++) {
            final int taskId = i; // must be final to use inside inner class
            executor.submit(()-> {
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
		 executor.shutdown();
	}

}
