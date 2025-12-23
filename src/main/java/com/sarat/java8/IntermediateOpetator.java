package com.sarat.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOpetator {

	public IntermediateOpetator() {
		// TODO Auto-generated constructor stub
	}

	 public static void main(String[] args) {
	        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
	        System.out.println("===========Map============");
	        // Convert names to uppercase
	        List<String> upperCaseNames = names.stream()
	                                            .map(String::toUpperCase)
	                                            .collect(Collectors.toList());
	        
	        System.out.println(upperCaseNames); // Outputs: [ALICE, BOB, CHARLIE]
	        System.out.println("===========filter============");
	        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
	        
	        // Filter even numbers
	        List<Integer> evenNumbers = numbers.stream()
	                                            .filter(n -> n % 2 == 0)
	                                            .collect(Collectors.toList());
	        
	        System.out.println(evenNumbers); // Outputs: [2, 4, 6]
	        System.out.println("============distinct===========");
	        List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
	        
	        // Get distinct numbers
	        List<Integer> distinctNumbers = numbers1.stream()
	                                                .distinct()
	                                                .collect(Collectors.toList());
	        
	        System.out.println(distinctNumbers); // Outputs: [1, 2, 3, 4, 5]
	        System.out.println("===========sorted============");
	        List<Integer> numbers2 = Arrays.asList(5, 3, 2, 4, 1);
	        
	        // Sort numbers
	        List<Integer> sortedNumbers = numbers2.stream()
	                                              .sorted()
	                                              .collect(Collectors.toList());
	        List<Integer> sortedNumbers1 = numbers2.stream()
	        		.sorted(Comparator.reverseOrder())
	        		.collect(Collectors.toList());
	        
	        System.out.println(sortedNumbers); // Outputs: [1, 2, 3, 4, 5]
	        System.out.println(sortedNumbers1); // Outputs: [5, 4, 3, 2, 1]
	        System.out.println("==========flatMap============");
	        List<List<String>> listOfLists = Arrays.asList(
	                Arrays.asList("A", "B"),
	                Arrays.asList("C", "D"),
	                Arrays.asList("E", "F")
	            );
	            
	            // Flatten the list of lists
	            List<String> flattenedList = listOfLists.stream()
	                                                     .flatMap(List::stream)
	                                                     .collect(Collectors.toList());
	            List<Character> flattenedList11 = listOfLists.stream()
	            	    .flatMap(List::stream) // Flatten to Stream<String>
	            	    .flatMap(str -> str.chars().mapToObj(c -> (char) c)) // Convert each string to characters
	            	    .collect(Collectors.toList());
	            
	            System.out.println("==========>flatMap"+flattenedList11); // Outputs: [A, B, C, D, E, F]
	            
	            System.out.println(flattenedList); // Outputs: [A, B, C, D, E, F]
	            
	            List<String> flattenedList1= listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList()).stream().map(e->e.toLowerCase()).collect(Collectors.toList());
	            System.out.println(flattenedList1); // Outputs: [a, b, c, d, e, f]
	            
	            System.out.println("============peek===========");
	            List<Integer> numbersp = Arrays.asList(1, 2, 3, 4, 5);
	            
	            // Use peek to print each element
	            numbersp.stream()
	                   .peek(n -> System.out.println("Processing: " + n))
	                   .map(n -> n * n) // Square each number
	                   .forEach(System.out::println); // Print the squared numbers
	            System.out.println("===========limit============");
	            List<Integer> numbersl = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	            
	            // Limit to the first 5 numbers
	            List<Integer> limitedNumbers = numbersl.stream()
	                                                   .limit(5)
	                                                   .collect(Collectors.toList());
	            
	            System.out.println(limitedNumbers); // Outputs: [1, 2, 3, 4, 5]
	            System.out.println("===========skip============");
	            
	            List<Integer> numberss = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	            
	            // Skip the first 5 numbers
	            List<Integer> skippedNumbers = numberss.stream()
	                                                   .skip(5)
	                                                   .collect(Collectors.toList());
	            
	            System.out.println(skippedNumbers); // Outputs: [6, 7, 8, 9, 10]
	        
	        
	       
	   
	   
	    }
}
