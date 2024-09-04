package com.anurag.test.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindingSumOfLargestTwoNumbersUsingStream {
	public static void main(String[] args) {
		// random numbers
        List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);
        
        
     // find sum of largest 2 numbers using Stream.skip(); method
        
        
        Integer reduce = numbers.stream().sorted().skip(numbers.size()-2).reduce(0,Integer::sum);
        System.out.println("Sum of top 2 largest number in list  " + reduce);
        
        
        numbers.stream().sorted(Comparator.reverseOrder()).limit(2).reduce(0,Integer::sum);
        
        

		// find sum of largest 2 numbers using Stream.limit(); method
		int sum = numbers
				.stream()
				.sorted() // natural ordering
				.limit(2)
				.reduce(0,  Integer::sum);
		
        // find sum of largest 2 numbers using Stream.skip(); method
        int sum1 = numbers
                .stream()
                .sorted(Comparator.reverseOrder()) // reverse natural ordering
                .skip(numbers.size() - 2)
                .reduce(0,  Integer::sum);
 
	}
}
