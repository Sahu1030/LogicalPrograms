package com.Practice.sarat.java8;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="sarat";
		String s2=new String("sarat");
		String s3=new String("sarat");

		System.out.println(s1.equals(s2));
		System.out.println(s2==s3);

		
		StringBuilder sb=new StringBuilder(s1);  
		System.out.println(sb.reverse());  

		
	}

}
