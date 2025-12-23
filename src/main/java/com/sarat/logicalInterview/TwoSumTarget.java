package com.sarat.logicalInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSumTarget {
	public static void main(String[] args) {
        int[] nums = {2, 7, 11, 5, 4, 2, 5, 7, 9, 2, 15, 3, 1, 6};
        int target = 9;

        // Find all unique pairs (i < j)
        List<int[]> pairs = IntStream.range(0, nums.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.length)
                        .mapToObj(j -> new int[]{nums[i], nums[j]}))
                .filter(pair -> pair[0] + pair[1] == target)
                .filter(pair -> pair[0] <= pair[1]) // enforce order
                .distinct() // remove duplicates if needed
                .collect(Collectors.toList());

        // Print all pairs
        pairs.forEach(pair -> System.out.println(pair[0] + " + " + pair[1] + " = " + target));
        
        
        System.out.println( "===================== =====================");
        Set<Integer> seen = new HashSet<Integer>();
        Set<String> uniquePairs = new HashSet<String>(); // store as "min,max" strings

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                // create sorted pair to avoid duplicates
                int min = Math.min(num, complement);
                int max = Math.max(num, complement);
                uniquePairs.add(min + "," + max);
            }
            seen.add(num);
        }

        // Print pairs
        for (String pair : uniquePairs) {
            String[] parts = pair.split(",");
            System.out.println(parts[0] + " + " + parts[1] + " = " + target);
        }
    }

}
