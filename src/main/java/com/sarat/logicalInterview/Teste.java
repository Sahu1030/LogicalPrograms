package com.sarat.logicalInterview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Welcome");
//		input= "apple", "banana", "apple", "orange", "banana"
		// outpput: {orange=1, banana=2, apple=2}

		List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana");

		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(map);

		List<Integer> data = Arrays.asList(5, 3, 4, 1, 2);

		List<Integer> listd = data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(listd);
//		List<Integer> data =Arrays.asList(5,3,4,1,2);
		int[] myArray = { 1, 2, 2, 0, 0, 1, 2, 2, 1 };

		int[] sorted = Arrays.stream(myArray).sorted().toArray();

		System.out.println(Arrays.toString(sorted));
		List<Integer> list11 = Arrays.stream(myArray).boxed().sorted().collect(Collectors.toList());

		System.out.println(list11);
		
		
		
		
		
		
		
		
		
		
		
//		1. Find and print the duplicate element present in given integer using streams(1,2,2,5,7,8,7)
//		2.Find and replace the vowels present in given string to max number of consonents
//		input: altimetrik
//		expected output:2lt2m2tr2k
		
		
		
		
	
		
		
		List<Integer> list111=Arrays.asList(1,2,2,5,7,8,7);
		
		Map<Integer,Long> map11=list111.stream().filter(c->c > 2 ).collect(Collectors.groupingBy(c->c,Collectors.counting()));
//		System.out.println(map);
		
		
		int[] array= {1,2,2,2,5,5,5,5,7,8,7};
		
		HashSet<Integer> set=new HashSet<>();
		ArrayList<Integer> duplicateArray=new ArrayList<>();
		for(int i:array)
		{
			if(set.contains(i)) {
				System.out.println("duplicate found"+i);
				duplicateArray.add(i);
			}
			else {
				set.add(i);
			}
			
		}
		
		System.out.println("No DUplicate"+set);
		System.out.println("Duplicate Array"+duplicateArray.stream().collect(Collectors.groupingBy(c->c,Collectors.counting())));
		
		
		String s="altimetrik";
		

		String result = s.chars()
		        .mapToObj(c -> {
		            char ch = (char) c;
		            return "aeiouAEIOU".indexOf(ch) != -1 ? "9" : String.valueOf(ch);
		        })
		        .collect(Collectors.joining());
		
		System.out.println("Result=>"+result);
		
		char[] ch=s.toCharArray();
		
		for(char ch1: ch) {
			
			if("aeiouAEIOU".indexOf(ch1) !=-1)
			{
				ch1 = '#';
			}
			System.out.print(ch1);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println();
		
		List<Integer> listdata=Arrays.asList(1,5,3,6,5,1,4);
		List<Integer> listdata1=	listdata.stream().distinct().sorted().collect(Collectors.toList());
		
		System.out.println(listdata1);
		
		Map<Integer, Long> map111=listdata.stream().collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.err.println(map111);
		
		

	}
}
