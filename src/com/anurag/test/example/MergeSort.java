package com.anurag.test.example;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = { 6, 5, 12, 10, 9, 1 };

	    quickSort(arr, 0, arr.length - 1);

	    System.out.println("Sorted array:");
	    System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr, int low, int high) {
	    if (low < high) {
	        int pivotIndex = partition(arr, low, high);
	        quickSort(arr, low, pivotIndex - 1);
	        quickSort(arr, pivotIndex + 1, high);
	    }
	}

	public static int partition(int[] arr, int low, int high) {
	    int pivot = arr[high];
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (arr[j] < pivot) {
	            i++;
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }
	    int temp = arr[i + 1];
	    arr[i + 1] = arr[high];
	    arr[high] = temp;
	    return i + 1;
	}
}
