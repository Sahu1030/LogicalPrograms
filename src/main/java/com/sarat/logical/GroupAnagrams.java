package com.sarat.logical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	 public static void main(String[] args) {
	        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
	        List<List<String>> result = groupAnagrams(input);

	        System.out.println(result);
	    }

	    public static List<List<String>> groupAnagrams(String[] strs) {
	        if (strs == null || strs.length == 0)
	            return new ArrayList<>();

	        Map<String, List<String>> map = new HashMap<>();

	        for (String s : strs) {
	            // Sort the characters in the string
	            char[] chars = s.toCharArray();
	            Arrays.sort(chars);
	            String key = new String(chars);

	            // Group by sorted key
	            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
	        }

	        return new ArrayList<>(map.values());
	    }

}
