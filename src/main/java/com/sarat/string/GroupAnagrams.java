package com.sarat.string;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] words = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = groupAnagrams(words);

		// Print the result
		System.out.println(result);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			System.out.println(key);
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
		}

		return new ArrayList<>(map.values());
	}
}
