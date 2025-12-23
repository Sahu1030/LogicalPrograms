package com.sarat.string;

import java.util.*;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int start = 0, maxLen = 0, maxStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            System.out.println(seen.containsKey(c));
            if (seen.containsKey(c)) {
            	System.out.println("inside");
                start = Math.max(seen.get(c) + 1, start);
                System.out.println("------>"+start);
            }
            System.out.println(c);
            System.out.println(seen);
            seen.put(c, end);
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                maxStart = start;
            }
        }

        return s.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
//        System.out.println(longestUniqueSubstring("abcabcbb"));  // Output: abc
        System.out.println(longestUniqueSubstring("Sarat chandra sahu"));  // Output: abc
    }
}

