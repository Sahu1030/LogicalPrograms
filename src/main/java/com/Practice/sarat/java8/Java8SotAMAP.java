package com.Practice.sarat.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8SotAMAP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> ItemToPrice = new HashMap<>();
	    ItemToPrice.put("Sony Braiva", 1000);
	    ItemToPrice.put("Apple iPhone 6S", 1200);
	    ItemToPrice.put("HP Laptop", 700);
	    ItemToPrice.put("Acer HD Monitor", 139);
	    ItemToPrice.put("Samsung Galaxy", 800);
	    ItemToPrice.put("Samsung Galaxy1", 800);

	    System.out.println("unsorted Map: " + ItemToPrice);

	    // sorting Map by values in ascending order, price here
	    ItemToPrice.entrySet().stream()
	        .sorted(Map.Entry.<String, Integer> comparingByKey())
	        .forEach(System.out::println);

	   	    // the Map returned by the previous statement was not sorted
	    // because ordering was lost while collecting result in Map
	    // you need to use the LinkedHashMap to preserve the order

	    // sorting a Map by values in descending order
	    // just reverse the comparator sorting by using reversed() method
	    Map<String, Integer> sortedByValueDesc = ItemToPrice
	        .entrySet()
	        .stream()
//	        .sorted(Map.Entry.<String, Integer> comparingByValue())
	        .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
	        .collect(Collectors.
	            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
	                LinkedHashMap::new));
	    
	    Map<Integer, List<String>> sortedByValueDesc1 = ItemToPrice
		        .entrySet()
		        .stream()
//		        .sorted(Map.Entry.<String, Integer> comparingByValue())
		        .sorted(Map.Entry.<String, Integer> comparingByKey())// optional sorting by item name
		        .collect(Collectors.groupingBy(
		                Map.Entry::getValue, // group by price
		                LinkedHashMap::new, // optional: preserve order of insertion (after sorting)
		                Collectors.mapping(Map.Entry::getKey, Collectors.toList())
		        ));
	    System.out.println("Map sorted by value in descending order: "
	        + sortedByValueDesc);
	    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$4 "
	    		+ sortedByValueDesc1);

	}

}
