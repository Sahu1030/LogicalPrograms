package com.sarat.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8ListTOMapCounting {

	public Java8ListTOMapCounting() {
		// TODO Auto-generated constructor stub
	}
	
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi");

        // Count occurrences of each string
        Map<String, Long> stringCount = strings.stream()
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        // Print string counts
        System.out.println("String counts:"
        		+stringCount);
        stringCount.forEach((string, count) -> System.out.println(string + ": " + count));
        System.out.println("=======================================");
        
        // Count occurrences of each character in the list of strings
        List<String> strings1 = Arrays.asList("apple");
//        List<String> strings1 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi");
        Map<Character, Long> charCount = strings1.stream()
            .flatMap(s -> s.chars().mapToObj(c -> (char) c)) // Convert each string to a stream of characters
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Print character counts
        System.out.println("\nCharacter counts:");
        charCount.forEach((character, count) -> System.out.println(character + ": " + count));

    }

}
