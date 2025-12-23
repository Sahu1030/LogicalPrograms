package com.Practice.test;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s= new String("Sarat ");
		s.concat("chandra");
		s=s.concat("sahu");
		System.out.println(s);
		String s1="Sarat ";
		String s2=s1+"sahu";
		System.out.println(s2);
		String s3= s;
		String s4="Sarat sahu";
		String s5=s4.intern();

		
		System.out.println(s==s2);
		System.out.println(s==s5);
		System.out.println(s3==s);
		System.out.println(s3.hashCode()+"==s3==" +s.equals(s4));
		System.out.println(s4.hashCode()+"==s4==" +s.equals(s5));
		System.out.println(s5.hashCode()+"==s5==" +s4.equals(s5));


		

	}

}
