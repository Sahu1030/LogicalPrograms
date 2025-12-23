package com.sarat.sort;

public class BinarySearchRecursive {

	public static int binarySearch(int[] arr, int left, int right, int target) {
		if (left > right)
			return -1;

		int mid = left + (right - left) / 2;
		System.out.println(mid);

		if (arr[mid] == target)
			return mid;
		else if (arr[mid] > target)
			return binarySearch(arr, left, mid - 1, target);
		else
			return binarySearch(arr, mid + 1, right, target);
	}

	public static void main(String[] args) {
		int[] sortedArray = { 56, 27, 2, 4, 7, 10, 14, 18 };
		int target = 10;

		int result = binarySearch(sortedArray, 0, sortedArray.length - 1, target);

		if (result != -1) {
			System.out.println("Element found at index: " + result);
		} else {
			System.out.println("Element not found in array.");
		}
	}
}
