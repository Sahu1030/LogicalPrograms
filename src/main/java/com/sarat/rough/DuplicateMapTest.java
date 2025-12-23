package com.sarat.rough;


	import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

	public class DuplicateMapTest {
	    public static void main(String[] args) {
	        List<Map<String, Object>> data = new ArrayList<>();

	        Map<String, Object> map1 = new HashMap<>();
	        map1.put("id", 1);
	        map1.put("name", "Alice");
	        data.add(map1);

	        Map<String, Object> map2 = new HashMap<>();
	        map2.put("id", 2);
	        map2.put("name", "Bob");
	        data.add(map2);

	        Map<String, Object> map3 = new HashMap<>();
	        map3.put("id", 1);
	        map3.put("name", "Alice"); // Duplicate
	        data.add(map3);

	        Map<String, Object> map4 = new HashMap<>();
	        map4.put("id", 3);
	        map4.put("name", "Charlie");
	        data.add(map4);

	        Map<String, Object> map5 = new HashMap<>();
	        map5.put("id", 2);
	        map5.put("name", "Bob"); // Duplicate
	        data.add(map5);

	        // Remove duplicates
	        System.out.println(data);

	        List<Map<String, Object>> uniqueData = removeDuplicates(data);
	        System.out.println(uniqueData);
	        
	        // Remove duplicates using streams
//	        List<Map<String, Object>> uniqueData1 = data.stream()
//	                .filter(distinctByKey(map -> map.get("id").toString()))
//	                .collect(Collectors.toList());
//
//	        System.out.println(uniqueData1);

	  
	    }

	    public static List<Map<String, Object>> removeDuplicates(List<Map<String, Object>> data) {
	        Set<String> seen = new HashSet<>();
	        List<Map<String, Object>> uniqueList = new ArrayList<>();

	        for (Map<String, Object> map : data) {
	            String id = map.get("id").toString(); // Assuming "id" is the key to check for duplicates
	            if (!seen.contains(id)) {
	                seen.add(id);
	                uniqueList.add(map);
	            }
	        }

	        return uniqueList;
	    }
	    
	    // Remove duplicates using streams
	    private static <T> java.util.function.Predicate<T> distinctByKey(java.util.function.Function<? super T, ?> keyExtractor) {
	        Map<Object, Boolean> seen = new HashMap<>();
	        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	    }
	}
