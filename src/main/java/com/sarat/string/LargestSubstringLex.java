package com.sarat.string;

public class LargestSubstringLex {
    public static String largestSubstring(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i);
            if (sub.compareTo(max) > 0) {
                max = sub;
                System.out.println(sub);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String input = "banana pa xyz sarat chandra sahu szyx";
        System.out.println("Largest substring: " + largestSubstring(input));
        
        int[] numbers = {1, 2, 3, 4, 5};
        int length = numbers.length;  // No parentheses!
        System.out.println("Array length: " + length);
        
        String message = "Hello World";
        int length1 = message.length();  // With parentheses!
        System.out.println("String length: " + length1);
    }
}

