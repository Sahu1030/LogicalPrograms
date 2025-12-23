package com.sarat.rough;

public class Rough {

	public Rough() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int batchSize = 5; // Process in batches of 5
		int count = 1;
		for (int i = 0; i < 27; i += batchSize) {
			System.out.println("%%%%%%%--> " + System.currentTimeMillis() + " <--%%%%%%%");
//	            List<Integer> batch = data.subList(i, Math.min(i + batchSize, data.size()));
			int end = Math.min(i + batchSize, 27);
			System.out.println("Batch===>" + count);
			System.out.println("==========");

			// Inner loop to process the current batch
			for (int j = i; j < end; j++) {
				if (count == 1 || count == 3 || count == 5)
					System.out.println("@@@@@@@@@@@@@@@@-->" + j);
				else
					System.out.println("###############-->" + j);

			}
			count++;
			System.out.println("%%%%%%%--> " + System.currentTimeMillis() + " <--%%%%%%%");

		}

	}

}
