package com.sarat.logicalInterview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
int[]   input = {1,2,3,4,5,6,7,8,9,10,11,17};
        
        
        List<List<Integer>> list=new ArrayList();
        
        
        for(int i=0;i<input.length;i++){
            for(int j=i+1;j<input.length;j++){
                if(input[i]+input[j] == 18)
                {
                    
                    List results=new ArrayList<>();
                    results.add(input[i]);
                    results.add(input[j]);
                    list.add(results);
                }
            }
        }
        System.out.println(list.toString());
        

//		input: ["apple","banana","pear","kiwi"]
//				
//				Expected output:
//				4=[pear,kiwi] , 5=[apple],6=[banana];

//		List<String> list = Arrays.asList("apple", "banana", "pear", "kiwi");
//
//		Map<Integer, List<String>> map = new java.util.HashMap<>();
//
//		for (String s : list) {
//
//			int length = s.length();
//			List<String> list1 = new ArrayList<>();
//
//			if (map.containsKey(length)) {
//				list1 = map.get(length);
//				list1.add(s);
//
//				map.put(length, list1);
//			} else {
//
//				
//
//				list1.add(s);
//				map.put(length, list1);
//			}
//
//		}
//		System.out.println(map);
        
        
        
        List<Integer> l1 = Arrays.asList(1, 2, 4, 6);
        List<Integer> l2 = Arrays.asList(1, 2, 4, 6, 7);
        List<Integer> l3 = Arrays.asList(1, 4, 6, 9);

        // ⭐ Common integers
        List<Integer> common =
                l1.stream()
                  .filter(l2::contains)
                  .filter(l3::contains)
                  .collect(Collectors.toList());

        // ⭐ Uncommon integers
        List<Integer> uncommon =
                Stream.of(l1, l2, l3)
                      .flatMap(List::stream)
                      .distinct()
                      .filter(n -> !common.contains(n))
                      .collect(Collectors.toList());

        System.out.println("Common   = " + common);
        System.out.println("Uncommon = " + uncommon);
        
        String s="india is one beautiful country";
		String vowels = s.chars()                     // stream of int chars
		        .mapToObj(c -> (char) c)              // convert to Character
		        .filter(ch -> "aeiouAEIOU".indexOf(ch) != -1)   // keep vowels
		        .map(String::valueOf)                 // convert to String
		        .collect(Collectors.joining()); 
		
		long count = s.chars()                     // stream of int chars
		        .mapToObj(c -> (char) c)              // convert to Character
		        .filter(ch -> "aeiouAEIOU".indexOf(ch) != -1)   // keep vowels
		        .map(String::valueOf)                 // convert to String
		        .count();
		
		System.out.println("=====>"+vowels);
		
		String[] arr = { "Bangalore", "hyderabad", "Chennai", "Mumbai" };
		  String[] othercity = { "ajmeer", "Boopal", "kota", "Delhi", "Mumbai", "Nagpur" };
		  Set<String> diff =
			        Arrays.stream(arr)
			              .filter(city -> Arrays.stream(othercity)
			                                    .noneMatch(c -> c.equals(city)))
			              .collect(Collectors.toSet());

			System.out.println(":::"+diff);
			
			Set<String> union =
			        Stream.concat(Arrays.stream(arr), Arrays.stream(othercity))
			              .sorted(String.CASE_INSENSITIVE_ORDER)
			              .collect(Collectors.toCollection(LinkedHashSet::new));

			System.out.println(union);
			
			
			int[] data = { 1, 2, 2, 2, 2, 23, 4, 1, 4, 1, 43, 5, 1 };
			System.out.println(Arrays.toString(data));
			List<Integer> list1 = Arrays.stream(data)
			        .distinct()
			        .boxed()   // convert int → Integer
			        .collect(Collectors.toList());
			System.out.println(list1);
			char condition = 'd'; 
			
			int[] sorted = Arrays.stream(data)
	                .boxed()  // int → Integer for Comparator
	                .sorted((condition == 'a' ) ? Comparator.naturalOrder() : Comparator.reverseOrder())
	                .sorted((condition == 'd' ) ? Comparator.reverseOrder() : Comparator.naturalOrder())
	                .mapToInt(i -> i)
	                .toArray();

	        System.out.println("$$$$$$$"+Arrays.toString(sorted));
	        
	        
	        if(condition =='a')
	        {
	        	Arrays.stream(data)
	            .boxed()  // int → Integer for Comparator
	            .sorted()
	            .mapToInt(i -> i)
	            .toArray();
	        }
	        else if (condition =='d'){
	        	Arrays.stream(data)
	            .boxed()  // int → Integer for Comparator
	            .sorted(Comparator.reverseOrder())
	            .mapToInt(i -> i)
	            .toArray();
	        }
	        
	        else {
	        	 throw new IllegalArgumentException("Invalid condition: " + condition + ". Use 'a' or 'd'.");
	        }

	
	}
}


