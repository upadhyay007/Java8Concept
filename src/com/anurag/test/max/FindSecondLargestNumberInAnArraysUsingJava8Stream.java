package com.anurag.test.max;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FindSecondLargestNumberInAnArraysUsingJava8Stream {
	public static void main(String[] args) {
		 // random numbers
        int[] numbers = {5, 9, 11, 2, 8, 21, 1};
        
	Integer integer = Arrays.stream(numbers).boxed().sorted(Collections.reverseOrder()).skip(2).findFirst().get();
	System.out.println("3rd higest : "+ integer);
	
	Integer integer2 = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
	System.out.println("3rd higest : "+ integer);
	
	}
}
