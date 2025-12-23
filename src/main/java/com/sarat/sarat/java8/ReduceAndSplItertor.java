package com.Practice.sarat.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

public class ReduceAndSplItertor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> names = Arrays.asList("sachin", "sehwag", "dhoni");

		Spliterator<String> spliterator = names.stream().spliterator();

		spliterator.forEachRemaining(n -> System.out.println(n));
		int[] nums = { 1, 2, 3, 4, 5 };

		/*
		 * int sum = 0; for(int i : nums) { sum = sum + i; } System.out.println(sum);
		 */

		int reduce = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
		System.out.println(reduce);
		
		

	}

}
