package com.Practice.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 */
public class ExecutorServiceWithNoLambada {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(10);

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

//Executors.newSingleThreadExecutor()	Creates a thread pool with only one thread. Tasks are executed sequentially.
//Executors.newFixedThreadPool(int n)	A thread pool with a fixed number of threads. Good for limiting concurrent threads.
//Executors.newCachedThreadPool()	A thread pool with unbounded threads. Creates new threads as needed and reuses idle ones.
//Executors.newScheduledThreadPool(int n)	For scheduled or periodic tasks (like cron jobs).
//Executors.newWorkStealingPool() (Java 8+)	Creates a pool using work-stealing algorithm (good for parallelism).





