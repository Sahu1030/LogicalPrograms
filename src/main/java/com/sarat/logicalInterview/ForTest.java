package com.sarat.logicalInterview;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] score = { 98, 100, 35, 75, 73, 81, 86, 75, 100, 75, 35, 75, 17, 98, 100, 35, 75, 73, 125, 81, 86 };

		int second = secondhs(score);
		int count = count(score, second);
		System.out.println(count + " students have scored second highest " + second);
		List<List<Integer>> lits = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3));

		int data1 = lits.stream().flatMap(List::stream).reduce(0, (a, b) -> a + b);
		System.out.println(data1);
		
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> groupedAnagrams =
                Arrays.stream(input)
                        .collect(Collectors.groupingBy(str -> {
                            char[] chars = str.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);  // sorted string as key
                        }));
		System.out.println("Welcome"+groupedAnagrams);


        groupedAnagrams.forEach((k, v) -> System.out.println(v));
		
		int[] data= {1,2,3,4,5};
		
		List<Integer> list=Arrays.stream(data).boxed().collect(Collectors.toList());
		System.out.println(list);
		int list1=Arrays.stream(data).reduce(1,(a,b)->a*b);
		System.out.println(list1);

		
		int f0=0;int f1=1;
		System.out.print(f0+" "+f1+" ");
		
		for(int i=2;i<10;i++) {
			
			int f2=f0+f1;
			System.out.print(f2+" ");
			f0=f1;
			f1=f2;
		}
		System.out.println();
		
		for(int j=0;j<10;j++)
		{
			System.out.print("-->"+fibonaci(j));
		}
		
		System.out.println("\n"+"============>"+fact(5));
		
		int[] myArray = {1,2,2,0,0,1,2,2,1};
		
		bubbleSort(myArray);
		 System.out.println(Arrays.toString(myArray));

	}
	
	static int fibonaci(int n) {
		if(n<=1)
			return n;
		return fibonaci(n-1)+fibonaci(n-2);
	}
	static int fact(int n) {
		if(n ==1 || n ==0)
			return 1;
		return fact(n-1)*n;
	}
	
	static int secondhs(int[] score) {
		int large = Integer.MIN_VALUE;
		int seclarge = Integer.MIN_VALUE;

		for (int num : score) {
			if (num > large) {
				seclarge = large;
				large = num;
			} else if (num > seclarge && num != large) {
				seclarge = num;

			}
		}
		return seclarge;

	}

	static int count(int[] score, int second) {
		int count = 0;
		for (int num : score) {
			if (num == second) {
				count++;
			}
		}
		return count;
	}
	
	public static void bubbleSort(int[] myArray) {
		for(int i=myArray.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(myArray[j]>myArray[j+1])
				{
					int temp=myArray[j];
					myArray[j]=myArray[j+1];
					myArray[j+1]=temp;
					
				}
			}
		}
    }
	  public static int binarySearch(int[] arr, int target) {
	        int left = 0;
	        int right = arr.length - 1;
	        System.out.println(arr.length - 1+"======"+arr.length);

	        while (left <= right) {
	            int mid = left + (right - left) / 2; // Avoids overflow

	            if (arr[mid] == target) {
	                return mid; // Found
	            } else if (arr[mid] < target) {
	                left = mid + 1; // Search right half
	            } else {
	                right = mid - 1; // Search left half
	            }
	        }

	        return -1; // Not found
	    }

}
