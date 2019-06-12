package org.home.prac.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {
		int []arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}; 
        int arr_size = arr.length; 
        dutchNationalFlagSort(arr, arr_size); 
        printArray(arr, arr_size);
	}
	
	static void printArray(int []arr, int arr_size) 
    { 
		System.out.println("Printing Array..");
        for (int i = 0; i < arr_size; i++) {
        	System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }

	private static void dutchNationalFlagSort(int[] arr, int arr_size) {
		int lo = 0; 
        int hi = arr_size - 1; 
        int mid = 0,temp=0; 
          
        while (mid <= hi) 
        { 
            switch (arr[mid]) 
            { 
            case 0: 
            { 
                temp = arr[lo]; 
                arr[lo] = arr[mid]; 
                arr[mid] = temp; 
                lo++; 
                mid++; 
                break; 
            } 
            case 1: 
                mid++; 
                break; 
            case 2: 
            { 
                temp = arr[mid]; 
                arr[mid] = arr[hi]; 
                arr[hi] = temp; 
                hi--; 
                break; 
            } 
            } 
        }
	}
	
}
