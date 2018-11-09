package org.home.prac.Arrays;

public class PairWithGivenSum {

	private static boolean hasPairWithGivenSum(int arr[], int arraySize, int sum) {
		
		//Sorting the Array
		quickSort(arr,  0, arraySize -1);
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
		
		System.out.println("Picking "+arr[endIndex]+ " as pivot");
		int pivot = arr[endIndex];
		int i = startIndex - 1;
		for(int j = 0; j < endIndex; j++) {
			System.out.println("startIndex "+startIndex+" endIndex "+endIndex+" i "+i+" j "+j);
			// if current element is smaller or equal to pivot;
			if(arr[j] <= pivot) {
				i++;
				//Swapping lower number 
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp; 
			}
		}
		printArray(arr);
		System.out.println("Swapping Pivot"+pivot+" with position i "+i);
		//Swapping pivot element with i+1
		arr[endIndex] = arr[i+1];
		arr[i+1] = pivot;
		
		printArray(arr);
		return i+1;
	}
	
	private static void printArray(int[] arr) {
		for(int i: arr) {
			System.out.print("\t"+i);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//int[] arr0 = {5, 6, 11, 65, 6, -1, 6};
		int arr1[] = {10, 7, 8, 9, 1, 5};
		
		quickSort(arr1, 0, arr1.length - 1);
		
		System.out.println(arr1.toString());
	}
}
