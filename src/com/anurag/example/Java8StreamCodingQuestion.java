package com.anurag.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8StreamCodingQuestion {
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 17, 58, 29, 5, 2, 36, 24, 28, 78, 98);
		
		// Given a list of numbers, return the sum of all numbers
		Optional<Integer> sumReduce = asList.stream().reduce((a,b)->a+b);
		System.out.println("Sum is : " + sumReduce.get());
	
		// Given a list of numbers, return the average of all numbers
		double orElse = asList.stream().mapToInt(a->a).average().orElse(0);
		System.out.println("Average of all number : " + orElse);
		
		//Given a list of numbers, square them and filter the number which are greater 100 and then find the avarage of them.
		double orElse2 = asList.stream().map(a->a*a).filter(a->a>100).mapToInt(a->a).average().orElse(0);
		System.out.println("Average of number greater than 100 : "+orElse2);
		
		//Given a list of numbers, find out all the numbers starting with 2
		List<Integer> collect = asList.stream().map(num->String.valueOf(num)).filter(n->n.startsWith("2")).map(Integer::valueOf).collect(Collectors.toList());
		System.out.println("Number start with 2 in list : "+ collect);
	}
}
