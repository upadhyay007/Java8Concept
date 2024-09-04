package com.anurag.test.example;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] data = { 20, 12, 10, 15, 2 };
		insertionSort(data);
		System.out.println("Sorted Array in Ascending Order: ");
		System.out.println(Arrays.toString(data));
	}

	private static void insertionSort(int[] data) {
		int n = data.length;
		for (int i = 1; i < n; i++) {
			int key = data[i];
			int j = i - 1;
			while (j >= 0 && data[j] > key) {
				data[j + 1] = data[j];
				j--;
			}
			data[j + 1] = key;
		}
	}
}
