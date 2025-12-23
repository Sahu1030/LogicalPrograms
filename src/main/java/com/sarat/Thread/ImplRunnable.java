package com.Practice.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ImplRunnable {

	public ImplRunnable() {
		// TODO Auto-generated constructor stub
	}
	
	int square(int i)
	{
		return i*i;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ImplRunnable ir=new ImplRunnable();
		
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("using Runnable interface");
			}
		};
		Thread t = new Thread(r);
		t.start();
		System.out.println("======>Runnable");
		Runnable r1 = () -> {
			System.out.println("only  runnable--->");
		};
		Thread t1 = new Thread(r1);
		t1.start();
		System.out.println("======>Executors");
		ExecutorService  s =Executors.newFixedThreadPool(10);
		
		
		for(int i=0;i<20;i++) {
			s.execute(()->
				System.out.println("Executor service executing"+Thread.currentThread().getName())
				
			);
			
		}
		System.out.println("======>Executors=================");
		for(int j=1;j<20;j++)
		{
			int number =j;
			@SuppressWarnings("unchecked")
			Future<?> f=s.submit(()->ir.square(number));
			System.out.println(f.get());
		}
		
		s.shutdown();
		
	}

}
