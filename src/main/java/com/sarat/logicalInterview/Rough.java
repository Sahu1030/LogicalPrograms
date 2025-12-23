package com.sarat.logicalInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome.");
		
		String s = "Hello";
//				Output: H = 1, e= 1, l= 2, o= 1.
		
		List<String> list=Arrays.asList("hello");
		
		Map<Character, Long> map=s.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(c->c,Collectors.counting()));


		System.out.println(map);
		
		
		String ss = "abcde";
		int n=ss.length();
		// all the Subctring
		List<String> list1=new ArrayList<>();
		for (int i = 0; i < ss.length(); i++) {
            for (int j = i + 1; j <= ss.length(); j++) {
                System.out.println(ss.substring(i, j));
                list1.add(ss.substring(i, j));
            }
		}
            System.out.println(list1);
            // for all the subsequence
    		List<String> list2=new ArrayList<>();

            for (int i = 1; i < (1 << n); i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        sb.append(ss.charAt(j));
                        
                    }
                }
                System.out.print(sb.toString());
                list2.add(sb.toString());
            }
            System.out.println();
            System.out.println(list2);
		
		List<String> words=Arrays.asList("a","bb","abc","ace");
		int count=0;
		for (String string : words) {
			if(list2.contains(string)) {
				count ++;
			}
			
		}
		System.out.println(count);
		
		
	}

}
