package com.anurag.test.example;

import java.util.Arrays;

public class SelectionSorting {
	public static void main(String[] args) {
		int[] data = { 20, 12, 10, 15, 2 };
		selectionSort(data);
		System.out.println("Sorted Array in Ascending Order: ");
		System.out.println(Arrays.toString(data));
	}

	private static void selectionSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[i]) {
					minIndex = j;
				}
			}
			int temp = data[minIndex];
			data[minIndex] =data[i];
			data[i]=temp;
		}
	}
}
