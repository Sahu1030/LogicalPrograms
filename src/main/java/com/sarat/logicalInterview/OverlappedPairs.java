package com.sarat.logicalInterview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OverlappedPairs {
	    public static void main(String[] args) {
	        int[][] pairs = {
	                {1, 2},
	                {3, 4},
	                {4, 9},
	                {5, 7}
	        };

	        List<int[]> overlappedPairs = Arrays.stream(pairs)
	                .flatMap(pair -> Arrays.stream(pairs)
	                        .filter(otherPair -> otherPair != pair && hasOverlap(pair, otherPair))
	                        .map(otherPair -> new int[][]{pair, otherPair}))
	                .flatMap(Stream::of)
	                //or
//	                .flatMap(Arrays::stream)
	                .collect(Collectors.toList());

	        System.out.println("Overlapped pairs: " + overlappedPairs.toString());

	        System.out.println("Overlapped-1 pairs: " + overlappedPairs.stream()
	        .map(Arrays::toString)
	        .collect(Collectors.joining(", ")));
	        
	        for (int i = 0; i < pairs.length; i++) {
	        	System.out.println(Arrays.toString(pairs[i]));
	            for (int j = i + 1; j < pairs.length; j++) {
	                if (hasOverlap(pairs[i], pairs[j])) {
	                	
	                	System.out.println(Arrays.toString(pairs[j]));
	                    System.out.println("Overlapping intervals: " + Arrays.toString(pairs[i]) + " and " + Arrays.toString(pairs[j]));
	                }
	            }
	        }
	    }

	    private static boolean hasOverlap(int[] pair1, int[] pair2) {
	        return (pair1[0] <= pair2[1] && pair1[1] >= pair2[0]) ||
	               (pair2[0] <= pair1[1] && pair2[1] >= pair1[0]);
	    }
	    
	    
	    public static boolean isOverlapping1(int[] interval1, int[] interval2) {
	        // Check if the intervals overlap
	        if (interval1[0] <= interval2[1] && interval2[0] <= interval1[1]) {
	            return true;
	        }
	        return false;
	    }
	    
	    
	   
	    
	    
	}