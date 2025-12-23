package com.sarat.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RepeatConsecutiveCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Character[] input = { 'a','a', 'b', 'c', 'a', 'b', 'a', 'f', 'f', 'a', 'n', 'n', 'n','a', 'a', 'g', 'h', 'h', 'p' };

	        List<Character> result = IntStream.range(0, input.length - 1)
	                .filter(i -> input[i] == input[i + 1])   // find consecutive repeats
	                .mapToObj(i -> input[i])
	                .distinct()                               // avoid duplicates (f,f,n,n,n)
	                .collect(Collectors.toList());

	        System.out.println("------->"+result); 

		List<Character> output = new ArrayList<>();
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] == input[i + 1]) {
				// Add only once
				if (!output.contains(input[i])) {
					output.add(input[i]);
				}
			}
		}
		System.out.println(output);

		List<Character> output1 = new ArrayList<>();
		Character latest = null; // empty character variable
		int count = 1;

		for (int i = 0; i < input.length - 1; i++) {

			if (input[i] == input[i + 1]) {
				count++;
			} else {
				if (count >= 2) {
//					output1.add(input[i]); // add the repeated char only once
					if (!output1.contains(input[i])) {
						output1.add(input[i]);
					}
				}
				count = 1; // reset for next group
			}
		}

		System.out.println("Latest assigned character = " + latest);
		System.out.println("list = " + output1);

	}

}
