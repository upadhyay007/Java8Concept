package com.anurag.test.max;

import java.util.Arrays;

public class FindFirstAndLastElementInArrayListUsingJava8 {
	public static void main(String[] args) {
		// create String[] arrays
		String[] names = { "Deepinder Goyal", "Vinay Sanghi", "Bipin Preet Singh", "Vijay Shekhar Sharma",
				"Falguni Nayar" };
		// find First element in Arrays
		String firstName = Arrays.stream(names).findFirst().get();
		System.out.println("First : " + firstName);
		
		  // find Last element in Arrays
		
		String string = Arrays.stream(names).reduce((a,b)->b).get();
		System.out.println("Largest : "+ string);
	}
}
