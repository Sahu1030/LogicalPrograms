package com.sarat.sort;

public class LinearSearch {

    // Linear Search Method
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found, return index
            }
        }
        return -1; // Not found
    }

    // Main Method to test
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 6, 1, 9};
        int target = 6;

        int result = linearSearch(numbers, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in array.");
        }
    }
}

/*
 * How It Works: The function loops through the array one element at a time.
 *  * It checks if the current element equals the target.
 *  * If yes, it returns the index.
 *  * If not found after the loop, it returns -1.
 *  * 📦 Time & Space Complexity:
 *  Time Complexity: O(n) — in the worst case, it
 * checks all elements.
 *  * Space Complexity: O(1) — constant space used.
 */

