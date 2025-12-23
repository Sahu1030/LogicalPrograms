package com.Practice.sarat.java8;

import java.util.stream.IntStream;

public class Java8PyramidTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream.range(1, 5).forEach(e->
				 {
					 IntStream.range(1, e+1).forEach(e1->System.out.print(e1));
			 System.out.println(" ");
				 });
		

	}

}
