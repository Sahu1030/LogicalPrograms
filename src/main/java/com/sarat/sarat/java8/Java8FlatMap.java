package com.Practice.sarat.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8FlatMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating a List of Strings
        List<String> list = Arrays.asList("5.6", "7.4", "4","1", "2.3");
  
        // Using Stream flatMap(Function mapper)
        list.stream().flatMap(num ->Stream.of(num) ).forEach(System.out::println);
       List<String>data= list.stream().map(num -> num ).collect(Collectors.toList());
       System.out.println(data);
       List<Integer> list1 = Arrays.asList(1,2,3);
       List<Integer> list2 = Arrays.asList(4,5,6);
       List<Integer> list3 = Arrays.asList(7,8,9);
         
       List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        System.out.println("=============="+listOfLists);
       List<Integer> listOfAllIntegers = listOfLists.stream()
                 .flatMap(x -> x.stream())
//                 .flatMap(x -> x.stream().map(a->a*2))
                 .collect(Collectors.toList());

       System.out.println(listOfAllIntegers);


	}

}
