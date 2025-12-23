package com.Practice.sarat.java8;

public class ConstructerTest {

	ConstructerTest(double d) {
		this(10);
		System.out.println("double-argument constructor");
	}

	ConstructerTest(int i) {
		this();
		System.out.println("int-argument constructor");
	}

	ConstructerTest() {
		System.out.println("no-argument constructor");
	}

	private static String methodOne(String msg) {
		System.out.println(msg);
		return msg;
	}

//	static String m = methodOne("1");
//	{
//		m = methodOne("2");
//	}
//	static {
//		m = methodOne("3");
//	}

	public static void main(String[] args) {
		ConstructerTest t1 = new ConstructerTest(10.5);// no-argument constructor/int-argument
														// constructor/double-argument constructor
		ConstructerTest t2 = new ConstructerTest(10);// no-argument constructor/int-argument constructor
		ConstructerTest t3 = new ConstructerTest();// no-argument constructor
	}
}
