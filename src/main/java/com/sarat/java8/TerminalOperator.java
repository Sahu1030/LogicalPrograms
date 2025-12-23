package com.sarat.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperator {

	public TerminalOperator() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

		// Print each name
		names.stream().forEach(name -> System.out.println(name));
		System.out.println("=============toList==========");
		List<String> namesc = Arrays.asList("Alice", "Bob", "Charlie");

		// Collect names into a List
		List<String> collectedNames = namesc.stream().collect(Collectors.toList());

		System.out.println(collectedNames); // Outputs: [Alice, Bob, Charlie]

		System.out.println("===========reduce============");
		List<Integer> numbersr = Arrays.asList(1, 2, 3, 4, 5);
//		numbersr.stream().forEach(name -> System.out.println(name));
//		numbersr.stream().forEach( System.out::println);

		// Sum the numbers using reduce
		Optional<Integer> summ = numbersr.stream().reduce((a, b) -> a + b);
		Optional<Integer> sum = numbersr.stream().reduce((a, b) -> a * b);
		Integer integersum = numbersr.stream().reduce(0,(a, b) -> a + b);

		// Print the result
		summ.ifPresent(result -> System.out.println("Sum: " + result)); // Outputs: Sum: 15
		sum.ifPresent(result -> System.out.println("multiply: " + result)); // Outputs: Sum: 120
		System.out.println("--->+integersum<----"+integersum);
		System.out.println("=======================");
		List<String> words = Arrays.asList("Hello", "World", "from", "Java");

		// Using reduce to concatenate strings
		Optional<String> sumr = words.stream().reduce((a, b) -> a + " " + b);
		String concatenated = words.stream().reduce("",(a, b) -> a + " " + b);

		sumr.ifPresent(sumrr -> System.out.println("combined string: " + sumrr)); // Outputs: String
		System.out.println("Concatenated: " + concatenated.trim()); // O

		System.out.println("=============count==========");
		List<String> namesco = Arrays.asList("Alice", "Bob", "Charlie");

		// Count the number of names
		long count = namesco.stream().count();

		System.out.println("Count: " + count); // Outputs: Count: 3

		System.out.println("============anyMatch===========");
		List<Integer> numbersam = Arrays.asList(1, 2, 3, 4, 5);

		// Check if any number is even
		boolean hasEven = numbersam.stream().anyMatch(n -> n % 2 == 0);

		System.out.println("Contains even number: " + hasEven); // Outputs: Contains even number: true

		System.out.println("===========allMatch============");
		List<Integer> numbersallm = Arrays.asList(2, 4, 6, 8);

		// Check if all numbers are even
		boolean allEven = numbersallm.stream().allMatch(n -> n % 2 == 0);

		System.out.println("All numbers are even: " + allEven); // Outputs: All numbers are even: true

		System.out.println("============noneMatch===========");
		List<Integer> numbersnm = Arrays.asList(1, 3, 5, 7);

		// Check if no number is even
		boolean noEven = numbersnm.stream().noneMatch(n -> n % 2 == 0);

		System.out.println("No numbers are even: " + noEven); // Outputs: No numbers are even: true

		System.out.println("=============findFirst==========");
		List<String> namesff = Arrays.asList("Alice", "Bob", "Charlie");

		// Find the first name
		Optional<String> firstName = namesff.stream().findFirst();

		firstName.ifPresent(name -> System.out.println("First name: " + name)); // Outputs: First name: Alice

		System.out.println("=============findAny==========");
		List<String> namesfa = Arrays.asList("Alice", "Bob", "Charlie");

		// Find any name
		Optional<String> anyName = namesfa.stream().findAny();

		anyName.ifPresent(name -> System.out.println("Any name: " + name)); // Outputs: Any name: Alice (or another
																			// name)

		System.out.println("============toArray===========");
		List<String> namesta = Arrays.asList("Alice", "Bob", "Charlie");

		// Convert stream to an array
		String[] namesArray = namesta.stream().toArray(String[]::new);

		System.out.println(Arrays.toString(namesArray)); // Outputs: [Alice, Bob, Charlie]

		System.out.println("============MAX/MIN===========");
		List<Integer> numbersmin = Arrays.asList(5, 3, 8, 1, 4);

		// Find the minimum number
		Optional<Integer> min = numbersmin.stream().min(Integer::compareTo);

		// Find the maximum number
		Optional<Integer> max = numbersmin.stream().max(Integer::compareTo);

		min.ifPresent(value -> System.out.println("Min: " + value)); // Outputs: Min: 1
		max.ifPresent(value -> System.out.println("Max: " + value)); // Outputs: Max: 8

		System.out.println("============joining===========");
		List<String> namesjoin = Arrays.asList("Alice", "Bob", "Charlie");

		// Join names with a comma and space
		String joinedNames = namesjoin.stream().collect(Collectors.joining(", "));

		System.out.println(joinedNames); // Outputs: Alice, Bob, Charlie

		System.out.println("=======================");
		List<String> namesmap = Arrays.asList("Alice", "Bob", "Charlie");

		// Collect names into a Map with name as key and length as value
		Map<String, Integer> nameLengthMap = namesmap.stream().collect(Collectors.toMap(name -> name, String::length));

		System.out.println(nameLengthMap); // Outputs: {Alice=5, Bob=3, Charlie=7}

		System.out.println("===========summaryStatistics============");
		List<Integer> numbersss = Arrays.asList(1, 2, 3, 4, 5);

		// Get summary statistics
		IntSummaryStatistics stats = numbersss.stream().mapToInt(Integer::intValue).summaryStatistics();

// Print the statistics
		System.out.println("Count: " + stats.getCount()); // Outputs: Count: 5
		System.out.println("Sum: " + stats.getSum()); // Outputs: Sum: 15
		System.out.println("Min: " + stats.getMin()); // Outputs: Min: 1
		System.out.println("Average: " + stats.getAverage()); // Outputs: Average: 3.0
		System.out.println("Max: " + stats.getMax()); // Outputs: Max: 5

		System.out.println("==========Optional=============");
		
		// Creating an Optional that may not be null
		Optional<String> optionalName = Optional.of("Alice");

        // Check if a value is present
        if (optionalName.isPresent()) {
            System.out.println("Name is present: " + optionalName.get());
        }

        // Using ifPresent to execute an action if the value is present
        optionalName.ifPresent(name -> System.out.println("Hello, " + name + "!"));

        // Creating an Optional that may be null
        Optional<String> optionalNull = Optional.ofNullable(null);
        System.out.println("Is value present in optionalNull? " + optionalNull.isPresent());

        // Providing a default value if the optional is empty
        String defaultName = optionalNull.orElse("Default Name");
        System.out.println("Name: " + defaultName); // Output: Name: Default Name

        // Using orElseGet to provide a default value from a supplier
        String nameFromSupplier = optionalNull.orElseGet(() -> "Name from Supplier");
        System.out.println("Name from Supplier: " + nameFromSupplier); // Output: Name from Supplier

        // Using orElseThrow to throw an exception if the value is absent
        try {
            String nameOrException = optionalNull.orElseThrow(() -> new IllegalArgumentException("Name is absent!"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Output: Name is absent!
        }

        // Transforming the value using map
        Optional<String> upperCaseName = optionalName.map(String::toUpperCase);
        upperCaseName.ifPresent(name -> System.out.println("Uppercase Name: " + name)); // Output: Uppercase Name: ALICE
       
        
        Optional<String> opt1 = Optional.of("Java");
		System.out.println(opt1.get()); // Java
		
		Optional<String> opt = Optional.ofNullable(null);
//		Optional<String> opt = Optional.ofNullable("sarat");
		System.out.println(opt.orElse("Default")); 
        
		System.out.println("=======================");


	}

}
