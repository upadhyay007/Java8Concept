package com.anurag.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamCodingQuestion1 {
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 17, 78, 29, 5, 2, 36, 24, 28, 89, 98);

		// Given a list of numbers, return the sum of all numbers
		Optional<Integer> sumReduce = asList.stream().reduce((a, b) -> a + b);
		System.out.println("Sum is : " + sumReduce.get());

		// WAP to get sum of all number in list
		int sum1 = asList.stream().mapToInt(i -> i).sum();
		System.out.println("Sum is : " + sum1);

		// WAP to square the number of list and filter out the number greater than 10
		List<Integer> collect = asList.stream().map(m -> m * m).filter(f -> f < 10).collect(Collectors.toList());
		System.out.println("Square and filter : " + collect);

		// find the list of string greater than 6 character
		List<String> list = Arrays.asList("aabc", "aab", "aabwc", "aabc", "aabwcwer", "aabcsd");
		List<String> collect2 = list.stream().filter(f -> f.length() > 6).collect(Collectors.toList());
		System.out.println(" more than 6 digit " + collect2);
		
		
		 
		 
		// How to collect 2 stream
		List<Integer> list1 = Arrays.asList(1, 4, 6, 7);
		List<Integer> list2 = Arrays.asList(11, 24, 86, 97);

		Stream<Integer> stream1 = Stream.concat(list1.stream(), list2.stream());
		System.out.println("Concatnated stream : ");
		stream1.forEach(System.out::print);

		// How to remove duplicate element
		List<Integer> asList1 = Arrays.asList(1, 2, 7, 20, 5, 2, 7, 24, 22, 14, 21);
		asList1.stream().distinct().forEach(System.out::println);

		// Find all the even number exist in List
		IntStream.range(1, 11).filter(f -> f % 2 == 0).forEach(System.out::println);
		
		
		// Find the duplicate element from the list using java 8
		List<Integer> findDuplicate = Arrays.asList(1, 2, 7, 20, 5, 2, 7, 24, 22, 14, 21);
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> duplicate = findDuplicate.stream().filter(i -> !set.add(i)).collect(Collectors.toList());// .forEach(System.out::prinln);
		System.out.println("Duplicate list : " + duplicate);

		
		 

	}
}
