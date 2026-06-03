package com.anurag.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindElementInStream {
	public static void main(String[] args) {
		int[] numbers = { 5, 9, 11, 2, 8, 21, 1 };

		// Sorted Arrays
		List<Integer> sortedArr = Arrays.stream(numbers).boxed().sorted().collect(Collectors.toList());
		System.out.println("Find Sorted Array : " + sortedArr);

		// Sorted List
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 9, 11, 2, 8, 21, 1));
		
		List<Integer> sortedList = arrayList.stream().sorted().collect(Collectors.toList());
		System.out.println("Find Sorted List : " + sortedList);
		
		// Find 2nd highest no in given arrays/list
		Integer secondHigestInteger = arrayList.stream().sorted(Comparator.reverseOrder())
				.skip(1).findFirst().get();
		System.out.println("2nd Highest  : " + secondHigestInteger);
		
		Optional<Integer> findFirst = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(2).findFirst();
		System.out.println("2nd higest : "+findFirst.get());
		
		
		
		
		
	
	}
}
