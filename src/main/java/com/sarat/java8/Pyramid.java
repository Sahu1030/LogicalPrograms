package com.sarat.java8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Pyramid {
	public static void main(String[] args) {
		int height = 6; // adjust the height of the pyramid
		printPyramid(height);
		myjav8code();
	}

	public static void printPyramid(int height) {
		IntStream.range(1, height).forEach(i -> {

//			  * 
//			 * * 
//			* * * 
//		   * * * * 
			// print leading spaces
//			IntStream.range(1, height - i - 1).forEach(j -> System.out.print(" "));

			// print asterisks
//			IntStream.range(1, i + 1).forEach(k -> System.out.print("* "));

			// print number Pyramid
//			 1
//			 1 2
//			 1 2 3
//			 1 2 3 4
			IntStream.range(1, i + 1).forEach(k -> System.out.print(" " + k));
			
			
//			    1
//			   12
//			  123
//			 1234
//			12345
//			IntStream.range(1,6-i).forEach(k->System.out.print(" "));
//			IntStream.range(1,i+1).forEach(k->System.out.print(k));

//			12345
//			1234
//			123
//			12
//			1
//			IntStream.range(1,6-i+1).forEach(k->System.out.print(k));
			
//			1 2 3 4 5 
//			  2 3 4 5 
//			    3 4 5 
//			      4 5 
//			        5 
//			IntStream.range(1, i).forEach(k -> System.out.print("  "));
//			IntStream.range(i, 6).forEach(j -> System.out.print(i + " "));

//			1 
//			2 3 
//			4 5 6 
//			7 8 9 10 
//			IntStream.range((i * (i - 1)) / 2 + 1, (i * (i + 1)) / 2 + 1).forEach(j -> System.out.print(j + " "));

			System.out.println(); // new line

		});
	}

	static void myjav8code() {
		IntStream.range(1,6).forEach(i -> {
			IntStream.range((i * (i - 1)) / 2 + 1, (i * (i + 1)) / 2 + 1).forEach(j -> System.out.print(j +" "));



			System.out.println();

		});
	}
}