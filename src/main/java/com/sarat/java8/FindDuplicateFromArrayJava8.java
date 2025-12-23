package com.sarat.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicateFromArrayJava8 {

	public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 2, 7, 8, 8, 3,2};

        IntStream.of(array)
                .boxed()
                .distinct()
                .forEach(System.out::print);
        System.out.println("=================OR==============");
        Arrays.stream(array).distinct().forEach(System.out::print);
        System.out.println("===============================");
        
     // Convert the array to a List
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        // Find duplicates using groupingBy
        Map<Integer, Long> duplicates = list.stream()
//            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .collect(Collectors.groupingBy(i->i, Collectors.counting()))
            .entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Print the duplicates
        System.out.println("Duplicate elements: " + duplicates);
        System.out.println("Duplicate elements: " + duplicates.keySet());
        List<String> hostingProviders = Arrays.asList(
                "Bluehost", "GoDaddy", "GoDaddy", 
                "Amazon AWS", "LiquidWeb", 
                "FatCow", "FatCow");

        Set<String> duplicates1 = hostingProviders.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println("Duplicate elements: " + duplicates1);
    
    }
}