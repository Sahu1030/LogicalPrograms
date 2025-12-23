package com.Practice.sarat.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class Java8StreamTOArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> currencies = Stream.of("INR", "USD", "GBP", "EUR", "JPY");
		Object[] objectArray = currencies.toArray();
		System.out.println("===============STREAM TO ARRAY================");
		System.out.println("Stream to object array in Java:");
		System.out.println(Arrays.toString(objectArray));
		Integer[] primes = { 2, 3, 5, 7, 11 };
		System.out.println(Arrays.toString(primes));
		
		 Stream<Integer> primeStream = Arrays.stream(primes); //convert arary to stream
	        primeStream.forEach(System.out::print); // prints each number
	        System.out.println("=============ARRAY TO STREAM==================");
		Stream<Integer> emptyStr = Stream.of(primes);
		emptyStr.forEach(System.out::print); // prints each number
		
		System.out.println(emptyStr);

	}

}
