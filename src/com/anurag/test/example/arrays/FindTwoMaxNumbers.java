package com.anurag.test.example.arrays;

public class FindTwoMaxNumbers {
	public void findTwoMaxNumbers(int[] array) {
		int maxOne = 0;
		int maxTwo = 0;
		for (int i : array) {
			if (maxOne < i) {
				maxTwo = maxOne;
				maxOne = i;
			} else if (maxTwo < i) {
				maxTwo = i;
			}
		}

		System.out.println("First Maximum Number: " + maxOne);
		System.out.println("Second Maximum Number: " + maxTwo);
	}

	public static void main(String a[]) {
		int num[] = { 4, 23, 67, 1, 76, 1, 98, 13 };
		FindTwoMaxNumbers obj = new FindTwoMaxNumbers();
		obj.findTwoMaxNumbers(num);
		// obj.findTwoMaxNumbers(new int[]{4,5,6,90,1});
	}
}
