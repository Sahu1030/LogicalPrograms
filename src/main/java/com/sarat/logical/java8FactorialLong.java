package com.sarat.logical;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class java8FactorialLong {
	public static void main(String[] args) {
        long n = 5;

        long fact = LongStream.rangeClosed(1, n)
                              .reduce(1, (a, b) -> a * b);

        System.out.println("Factorial of " + n + " is: " + fact);
        
        
        List<Integer> fibList = Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
				.limit(5)
				.map(f -> f[0])
				.collect(Collectors.toList());

		System.out.println(fibList);
    }

}
