package com.anurag.stream.numericstreams;

import java.util.Arrays;
import java.util.List;

//Numeric Streams
//Represents the primitive values in a Stream 
//IntStream
//LongStream
//DoubleStream
public class NumericStreams {
	public static void main(String[] args) {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 11, 22, 40, 90);
		System.out.println("Sum of N mumner : " + sumOfNumber(integerList));

	}

	private static int sumOfNumber(List<Integer> integerList) {
		// As Integer is Warper type
		// Unboxing to convert the Integer to int   
		return integerList.stream().reduce(0, (x, y) -> x + y);
	}
}
