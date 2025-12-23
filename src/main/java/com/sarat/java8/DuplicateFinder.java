package com.sarat.java8;

import java.util.*;
import java.util.stream.*;

public class DuplicateFinder {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "2", "4", "1");

        // Java 8 code to find duplicates
        Set<String> duplicates = list.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e -> e.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());

        System.out.println("Duplicate elements: " + duplicates);
    }
}

