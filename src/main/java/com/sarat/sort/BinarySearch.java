package com.sarat.sort;

public class BinarySearch {

    // Binary Search Method (Assumes array is sorted)
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

    // Main method to test
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 6, 8, 9, 12, 15};
        int target = 8;

        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in array.");
        }
    }
}

/*
 * 📦 Time & Space Complexity: Time Complexity: O(log n) – each step cuts the
 * array in half.
 * 
 * Space Complexity:
 * 
 * Iterative: O(1)
 * 
 * Recursive: O(log n) (due to recursion stack)
 * 
 * ❗ Important: Binary Search only works on sorted arrays.
 */
