package com.sarat.logical;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class java8FibonacciList {

	public static void main(String args[]) {
		// TODO Auto-generated method stub

		List<Integer> fibList = Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
				.limit(10)
				.map(f -> f[0])
				.collect(Collectors.toList());

		System.out.println(fibList);

	}

}
