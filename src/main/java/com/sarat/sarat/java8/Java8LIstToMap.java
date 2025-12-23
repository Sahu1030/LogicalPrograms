package com.Practice.sarat.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8LIstToMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> hostingProviders = Arrays.asList("Bluehost",
                "GoDaddy", "GoDaddy", "Amazon AWS", "LiquidWeb", "FatCow", "FatCow");
 System.out.println("list: " + hostingProviders);

 Map<String, Integer> cards2Length = hostingProviders.stream()
         .collect(Collectors.toMap(Function.identity(),
                         String::length,
                         (e1, e2) -> e1));
 System.out.println("map: " + cards2Length);
 Map<String, Long> stringCount = hostingProviders.stream()
         .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
 
 System.out.println("map: " + stringCount);
 
 Map<String,Integer> data=hostingProviders.stream().collect(Collectors.toMap(Function.identity(),String::length,(e1,e2)->e1));
 System.out.println(data);
 

 

	}

}
