package com.sarat.java8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

	public FunctionalInterfaces() {
		// TODO Auto-generated constructor stub
	}
	public  static void  main(String[] args) {
		
		Consumer<String> print = System.out::println;
		print.accept("Hello, World!"); // Output: Hello, World!
		
		Function<Integer, String> intToString = Object::toString;
		System.out.println(intToString.apply(123)); // Output: "123"
		
		
		Predicate<Integer> isEven = number -> number % 2 == 0;
		System.out.println(isEven.test(4)); // Output: true
				
		Supplier<Double> randomValue = Math::random;
		System.out.println(randomValue.get()); // Output: A random number between 0.0 and 1.0
		
		BinaryOperator<Integer> add = (a, b) -> a + b;
		System.out.println(add.apply(5, 10)); // Output: 15
		
	}

}
