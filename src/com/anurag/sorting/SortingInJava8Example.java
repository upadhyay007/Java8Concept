package com.anurag.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingInJava8Example {
	public static void main(String[] args) {
		// ways to sort in java 8
		// 1. Collections.sort()
		// 2. Stream.sort()
		// 3. List.sort()
		List<String> asList = Arrays.asList("peter", "anna", "mike", "xenia");

		// By Collection sort

		// Collections.sort(asList);
		// System.out.println("Sorted : " +asList);
		// by passing lambda for comparator
		// Collections.sort(asList, (a,b)->a.compareTo(b));
		// System.out.println("Sorted using lambda : "+ asList);

		// By Stream

		List<String> collect = asList.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorting using Stream : " + collect);

		// Q: Sort the List of String and changes it to upper case;
		List<String> sortedAndUpperCase = asList.stream().map(a -> a.toUpperCase()).sorted()
				.collect(Collectors.toList());
		System.out.println("Sorted and upper case : " + sortedAndUpperCase);

		// Using List
		asList.sort(Comparator.reverseOrder());
		System.out.println("Using List : " + asList);

	}
}
