package com.Practice.test;

public class DebugTest {
	
	static String f6(String s)
	{
		System.out.println("F6 test");
		f5( s);
		System.out.println("F5 called");
		return "F6";
	}
	
	static String f5(String s)
	{
		System.out.println("F5 test");
		
		return "F5";
	}
	
	static String f7(String s)
	{
		System.out.println("F7 test");
		f8( s);
		System.out.println("F8 called");
		return "F7";
	}
	static String f8(String s)
	{
		System.out.println("F8 test");
		return "F8";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f6("ABC");
		System.out.println(" Main");
		System.out.println("LAST");

	}

}
