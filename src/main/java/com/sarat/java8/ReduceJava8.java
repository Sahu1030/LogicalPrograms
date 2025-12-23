package com.sarat.java8;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceJava8 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Sum the numbers using reduce
        Optional<Integer> sum = numbers.stream()
                                       .reduce((a, b) -> a + b);
        
        // Print the result
        sum.ifPresent(result -> System.out.println("Sum: " + result)); // Outputs: Sum:
        
     // Sum the numbers using reduce
        int sum1 = numbers.stream()
                                       .reduce(0,(a, b) -> a + b);
        System.out.println(sum1);
    }
}
