package org.home.prac.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {5, 10, 12, 18, 19, 29, 52, 55, 61, 68, 81, 99};
		System.out.println(binarySearch(arr, 0, arr.length - 1, 52));
	}
	
	static int binarySearch(int arr[], int l, int r, int x) {
		while (l <= r) {
			// find index of middle element
			int m = (l + r) / 2;
			// Check if x is present at mid
			if (arr[m] == x)
				return m;
			// If x greater, ignore left half
			if (arr[m] < x)
				l = m + 1;
			// If x is smaller, ignore right half
			else
				r = m - 1;
		}
		// if we reach here, then element was not present
		return -1;
	}
}
