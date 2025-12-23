package com.Practice.sarat.java8;

import java.util.Collections;
import java.util.stream.IntStream;

public class Java8InStreamPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The stream is not running parallelly.");
		IntStream i = IntStream.rangeClosed(1, 5);
		IntStream j = IntStream.rangeClosed(1, 4);
		i.boxed().sorted(Collections.reverseOrder()).forEach(System.out::println);

//		 i.forEach(ra-> j.
//			    // second loop for filtered elements
//			    forEach(city -> { 
//			        System.out.print(ra);
//			    }));
		IntStream.range(1, 5).forEach(val -> {
			IntStream.range(1, val + 1).forEach(res -> System.out.print(" " + res));
			System.out.println(" ");
		});

		IntStream.range(1, 6).forEach(ii -> {
			IntStream.range(1, ii + 1).forEach(k -> System.out.print(" " + ii));
			System.out.println(" ");
		});

		IntStream.rangeClosed(1, 5).forEach(iii -> {
			IntStream.range(0, iii).forEach(jj -> System.out.print(" " + iii));
			System.out.println(" ");
		});

		IntStream.range(1, 6).forEach(ik -> {
			IntStream.range(1, 6 - ik).forEach(k -> System.out.print(" "));
			IntStream.range(1, ik + 1).forEach(i1 -> System.out.print(ik+""));
			System.out.println(" ");

		});

		IntStream.range(1, 6).forEach(ik -> {
			IntStream.range(1, ik).forEach(k -> System.out.print("  "));
			IntStream.range(ik, 6).forEach(jk -> System.out.print(ik + " "));
			System.out.println(" ");
		});

//		 System.out.println("The stream is running parallellys.");  
//		IntStream r2 = IntStream.rangeClosed(1, 5);  
//	    IntStream r2Parallel = r2.parallel();  
//	    r2Parallel.forEach(System.out::println);  

	}

}
