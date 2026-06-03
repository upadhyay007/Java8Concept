package com.anurag.test.example.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

// Write a Program to Get Second Highest Element In an Array?
public class ArraysExample {
	public static void main(String[] args) {
		int numbers[] = { 47, 3, 37, 12, 46, 5, 64, 21 };
		int highest = 0;
		int second_highest = 0;

		for (int n : numbers) {
			if (highest < n) {
				second_highest = highest;
				highest = n;
			} else if (second_highest < n) {
				second_highest = n;
			}
		}

		System.out.println("Higest : " + highest);
		System.out.println("2nd Higest : " + second_highest);

		// Java 8 ways

		Integer integer = Arrays.stream(numbers).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1)
				.findFirst().get();
		System.out.println("second higest : " + integer);
		
		List<Integer> findMostRepetedValue = Arrays.asList(1, 7, 7, 20, 7, 2, 7, 5, 24, 22, 14, 23);
		Integer key = findMostRepetedValue.stream().collect(Collectors.groupingBy(f -> f, Collectors.counting()))
				.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue())).findFirst().get()
				.getKey();
		System.out.println("----------");
		Map<Integer, Long> collect = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(f->f,Collectors.counting()));
		
		collect.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue())).forEach((f)->System.out.println(f.getValue()));;
		//findMostRepetedValue

	}
}
