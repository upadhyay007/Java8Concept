package com.anurag.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8StreamCodingQuestion {
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 17, 78, 29, 5, 2, 36, 24, 29, 89, 98);

		// Given a list of numbers, return the sum of all numbers
		Optional<Integer> sumReduce = asList.stream().reduce((a, b) -> a + b);
		System.out.println("Sum is : " + sumReduce.get());

		// Given a list of numbers, return the average of all numbers
		double orElse = asList.stream().mapToInt(a -> a).average().orElse(0);
		System.out.println("Average of all number : " + orElse);

		// Given a list of numbers, square them and filter the number which are greater
		// 100 and then find the average of them.
		double orElse2 = asList.stream().map(a -> a * a).filter(a -> a > 100).mapToInt(a -> a).average().orElse(0);
		System.out.println("Average of number greater than 100 : " + orElse2);

		// Given a list of numbers, find out all the numbers starting with 2
		List<Integer> collect = asList.stream().map(num -> String.valueOf(num)).filter(n -> n.startsWith("2"))
				.map(Integer::valueOf).collect(Collectors.toList());
		System.out.println("Number start with 2 in list : " + collect);

		// Given a list of number find the duplicate
		System.out.println("Given a list of number find the duplicate");
		asList.stream().filter(f -> Collections.frequency(asList, f) > 1).forEach(System.out::print);
		System.out.println("Given a list of number find the duplicate");
		Map<Integer, Long> collect3 = asList.stream().collect(Collectors.groupingBy(f->f,Collectors.counting()));
		List<Integer> collect4 = collect3.entrySet().stream().filter(f->f.getValue()>1).map(Entry::getKey).collect(Collectors.toList());
		System.out.println("Collect 4 :" + collect4);
		//To print distinct
		asList.stream().distinct().forEach(System.out::println);
		
		//Given a list of numbers, print the maximum and minimum values
		Integer max = asList.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Max : " +  max);
		
		Integer min = asList.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Min : " +  min);
		
		//Given list of number, sort them in ASC and DESC order and print 
		asList.stream().sorted().forEach(System.out::print);
		asList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		
		//Given list of numbers, return the first 5 element and sum.
		// Approach we can use limit()followed by reduce()
		 
		Optional<Integer> collect2 = asList.stream().limit(5).reduce((a,b)->a+b);
		System.out.println("Sum : " + collect2.get());
		
		// Given a list of numbers. skip the first 5 numbers and return the sum of remaining numbers
		Integer sum = asList.stream().skip(5).reduce((a,b)->a+b).get();
		System.out.println(" Sum : "+ sum);
		
		
		
		

	}
}
