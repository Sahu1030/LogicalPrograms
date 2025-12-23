package com.sarat.java8;

public class Interface18 implements Vehicle {
	
	public static void main(String[] args) {
		Interface18 c = new Interface18();
		Vehicle.clean();
		c.start();
		c.m1();
		c.m2();
	}

	@Override
	public void start() {
		System.out.println("Start method Override completed...");
		
	}
	
	public  void m1() {
		System.out.println("M1() Start method in Class...");
	}	

}

interface Vehicle {
	public void start();

	public default void m1() {
		System.out.println("M1() Start method interfacecompleted...");
	}

	public default void m2() {
		System.out.println("M2() Start method interface completed...");
	}

	public static void clean() {
		System.out.println("cleaning completed...");
	}
}

