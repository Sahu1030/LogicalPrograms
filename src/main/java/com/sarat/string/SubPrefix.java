package com.sarat.string;

import java.util.Arrays;
import java.util.List;

public class SubPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String[] strs = { "flower", "flow", "flight" };
		String[] strs = { "application", "apple", "apply"};
// 		 
// 		Output: "fl"
// 		 

		List<String> list = Arrays.asList("flower", "flow", "flight");

		String result = subPrefix(strs);
		System.out.println("------>" + result);
	}

	public static String subPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		String prefix = strs[0];
		
		for (int i = 1; i < strs.length; i++) {
			System.out.println(strs[i].indexOf(prefix)!= 0);
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		return prefix;
	}
}
