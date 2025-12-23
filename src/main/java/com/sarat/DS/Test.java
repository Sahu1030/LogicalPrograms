package com.sarat.DS;

import java.util.Arrays;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="saat";
		
		char[] res=s.toCharArray();
		
		for(int i=0;  i<res.length;i++) {
			int a=res[i];
			System.out.println(a);
		}
		
		System.out.println(Arrays.toString(res));
		System.out.println(s);

	}

}
