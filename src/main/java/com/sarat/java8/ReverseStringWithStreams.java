package com.sarat.java8;

import java.util.stream.Collectors;

public class ReverseStringWithStreams {
    public static void main(String[] args) {
        String original = "Hello, World!";
        String reversed = new StringBuilder(original)
                .reverse()
                .toString();

        // Alternatively, using streams
        String reversedWithStreams = original.chars().mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s, c) -> s + c);

        System.out.println("Original: " + original);
        System.out.println("Reversed (StringBuilder): " + reversed);
        System.out.println("Reversed (Streams): " + reversedWithStreams);
    }
}
