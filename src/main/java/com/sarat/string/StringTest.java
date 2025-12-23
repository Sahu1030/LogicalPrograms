package com.sarat.string;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1=new String("bhaskar"); 
		String s2=s1.intern(); 
		String s3="bhaskar"; 
		System.out.println(s2==s3);//true 
		System.out.println(s2==s1);//false 

		
		
//        ┌──────────────────────────────┐
//        │        String Pool (Heap)    │
//        │──────────────────────────────│
//        │ "bhaskar"  @1001             │ ← s2, s3
//        └──────────────────────────────┘
//
//        ┌──────────────────────────────┐
//        │          Heap Area           │
//        │──────────────────────────────│
//        │ "bhaskar"  @2001             │ ← s1
//        └──────────────────────────────┘

	}

}
