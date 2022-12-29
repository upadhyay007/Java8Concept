package com.anurag.stream.numericstreams;

import java.util.stream.IntStream;

public class NumericStreamRangesExample {
	public static void main(String[] args) {
		System.out.println("-------------------");
		IntStream range = IntStream.range(1, 50);
		range.forEach(System.out::println);
		System.out.println("-------------------");
		IntStream rangeClose = IntStream.rangeClosed(1, 50);
		rangeClose.forEach(System.out::println);
		
		
	}
}
