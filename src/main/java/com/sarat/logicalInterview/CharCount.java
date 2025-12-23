package com.sarat.logicalInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {
	public static void main(String[] args) {
		String word = "sarat chandra sahu";
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (charCountMap.containsKey(ch)) {
				charCountMap.put(ch, charCountMap.get(ch) + 1);
			} else {
				charCountMap.put(ch, 1);
			}
		}

		System.out.println(charCountMap);
		// Print the character counts
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		System.out.println("============================");
		Map<Character, Long> charCountMap1 = word.chars() // IntStream of char codes
				.mapToObj(c -> (char) c) // Convert int to Character
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		charCountMap.forEach((k, v) -> System.out.println(k + " - " + v));
	}
}
