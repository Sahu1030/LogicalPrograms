package com.Practice.sarat.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Java8AllStreamFunTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		List<Integer> list=new ArrayList<>();
		list.add(1);list.add(5);list.add(0);list.add(999);		list.add(2);		list.add(3);		list.add(4);
		System.out.println(list);
		//For filter according to filter condition from list
		List l1=(List) list.stream().filter(S->S % 2 ==0).collect(Collectors.toList());
		System.out.println("Filter all the elsment: "+l1);
		//For Map to  all Elements
//		l1.forEach(System.out::print);
		List l2=(List<?>) list.stream().map(S->S*2).collect(Collectors.toList());
		System.out.println("Mapping to all element : "+l2);
		//For Sorting
		List sort=list.stream().sorted().collect(Collectors.toList());
		List sort1=list.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
		System.out.println("Sorted Array: "+sort1);
		int max=list.stream().max((o1, o2) -> o1.compareTo(o2)).get();
		int min=list.stream().min((o1, o2) -> o1.compareTo(o2)).get();
		int minmax=list.stream().reduce(Integer.MAX_VALUE, Integer::min);

		System.out.println("Max element from list : "+max+    "Min munber  " +min );
		//For Count
		long count=list.stream().filter(S->S>3).count();
		System.out.println("Count in List : "+count);
		//ForEach Condition in Java8
		System.out.println("ForEach works in java 8 ");
		 list.stream().forEach(S->System.out.print(S)) ;
		 //Sum of all even numbers
		 int sum1 = list.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
		 System.out.println("Sum of even numbers "+sum1);
		 OptionalDouble average = list.stream().mapToInt(a->a).average();
		 System.out.println("Average of list "+average);
		List a= list.stream().map(S->S*2).collect(Collectors.toList());
		System.out.println(a);
			
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int maxinarray = Arrays.stream(numbers).reduce(0, (x, y) -> x < y ? x : y);
		System.out.println(LocalDate.of(1979, 11, 23));
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		//In parallel processing thread pool
		ForkJoinPool customThreadPool = new ForkJoinPool(4);
		int sum = customThreadPool.submit(
		    () -> listOfNumbers.parallelStream().reduce(0, Integer::sum)).get();
		System.out.println(sum);
		}
	}
