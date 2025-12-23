package com.sarat.rough;

import java.util.ArrayList;
import java.util.List;

public class ForLoppCheck {

	public ForLoppCheck() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list=new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println("SIZE==========>"+list.size());
		int batchSize = 5; // Process in batches of 5
		int count = 1;

		for(int k=0;k<list.size();k++) {
			System.out.println("Outer Batch===>" + count);
			int count1=1;
		System.out.println("%%%%%%%--> " + System.currentTimeMillis() + " <--%%%%%%%");
		for (int i = 0; i < 10; i += batchSize) {
			// List<Integer> batch = data.subList(i, Math.min(i + batchSize, data.size()));
			int end = Math.min(i + batchSize, 100);
			
			System.out.println("Inner Batch===>" + count1);
			System.out.println("==========");

			// Inner loop to process the current batch
			for (int j = i; j < end; j++) {
				if (count == 1 || count == 3 || count == 5)
					System.out.println("-->" + j);
				else
					System.out.println("-->" + j);
				generateIMSData(j, k, list);

			}
			System.out.println("==========");
			count1++;

		}
		count++;
		}
		System.out.println("%%%%%%%--> " + System.currentTimeMillis() + " <--%%%%%%%");

//		System.out.println("$$$$$$$$--> " + System.currentTimeMillis() + " <--$$$$$$$");
//		for (int i = 0; i < 500; i ++) {
//			
//			System.out.println("==========--> "+i);
//
//			
//
//		}
//		System.out.println("$$$$$$$$--> " + System.currentTimeMillis() + " <--$$$$$$$");

	}
	
	static void generateIMSData(int j, int k, List<String> list)
	{
		System.out.println("$$$$$$--->"+j+"  *********-->"+k);
		System.out.println("#####################--->"+list.get(k));
	}

}
