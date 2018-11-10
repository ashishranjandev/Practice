package org.home.prac.Arrays;

public class PairWithGivenSum {

	private static boolean hasPairWithGivenSum(int arr[], int arraySize, int sum) {
		//Sorting the Array
		quickSort(arr,  0, arraySize -1);

		int startIndex = 0;
		int endIndex = arraySize -1;
		while (endIndex > startIndex){
			if(arr[startIndex]+arr[endIndex] ==  sum) {
				return true;
			} else if (arr[startIndex]+arr[endIndex] > sum) {
				endIndex--;
			} else {
				startIndex++;
			}
		}
		return false;
	}
	
	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		
		if(endIndex > startIndex) {
			int part = partition(arr, startIndex, endIndex);
			quickSort(arr, startIndex, part-1);
			quickSort(arr, part+1, endIndex);
		}
	}
	
	private static int partition(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[endIndex];
		int i = startIndex - 1;
		for(int j = startIndex; j < endIndex; j++) {
			// if current element is smaller or equal to pivot;
			if(arr[j] <= pivot) {
				i++;
				//Swapping lower number 
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp; 
			}
		}
		//Swapping pivot element with i+1
		arr[endIndex] = arr[i+1];
		arr[i+1] = pivot;
		
		return i+1;
	}
	
	public static void main(String[] args) {
		//int[] arr0 = {5, 6, 11, 65, 6, -1, 6};
		int arr[] = {1, 4, 45, 6, 10, -8}; 
		int sum = 16; 
		int arraySize = 6;
		if(hasPairWithGivenSum(arr, arraySize, sum)) {
			System.out.println("There is a pair with sum as "+sum);
		} else {
			System.out.println("There are no pair with sum as "+sum);
		}
	}
}
