package com.anurag.test.example;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
//Kind of sorting where we are comparing the adjacent value and swap them until intended order.
		int[] data = { -2, 45, 0, 11, -9 };

		// call method using class name
		bubbleSort(data);
	    System.out.println("Sorted Array in Ascending Order:");
	    System.out.println(Arrays.toString(data));
	}

	private static void bubbleSort(int[] data) {
		int arr = data.length;
		for (int i = 0; i < arr; i++) {
			for (int j = i + 1; j < arr; j++) {
				if (data[i] > data[j]) {
					int temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}

		}

	}
}
