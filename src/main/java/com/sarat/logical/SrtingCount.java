package com.sarat.logical;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SrtingCount {

	public SrtingCount() {
		
	}
		// TODO Auto-generated constructor stub
		private static final ConcurrentHashMap<String, Integer> wordCounts = new ConcurrentHashMap<>();

	    public static void main(String[] args) {
	        String input = "Running in thread Running in";

	        // Split the input into words
	        String[] words = input.split("\\s+"); // split by spaces

	        // Create a thread pool
	        ExecutorService executor = Executors.newFixedThreadPool(3);

	        for (String word : words) {
	            executor.execute(() -> {
	                // Convert to lowercase to make it case-insensitive
	                String w = word.toLowerCase();

	                // Atomic update: increment count or put 1
	                wordCounts.merge(w, 1, Integer::sum);
//	                wordCounts.put(w, 1);
	            });
	        }
	        executor.shutdown();
	        while (!executor.isTerminated()) {
	            // Wait for all tasks to finish
	        }

	        // Print the word counts
	        wordCounts.forEach((key, value) -> {
	            System.out.println(key + " => " + value);
	        });
	    }
	}