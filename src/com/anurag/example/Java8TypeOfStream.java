package com.anurag.example;

import java.util.Arrays;

public class Java8TypeOfStream {
	public static void main(String[] args) {
	// To find first element of the array
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println); // a1
	}
}
