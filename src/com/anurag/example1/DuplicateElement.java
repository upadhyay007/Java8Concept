package com.anurag.example1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DuplicateElement {
	public static void main(String[] args) {
		String originalString = "i love java programming";
		String stringWithoutSpace = String.valueOf(originalString.replace(" ", ""));
		Arrays.stream(stringWithoutSpace.split(""))
		.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		// Find the duplicate emelent in given string
		List<String> duplicateElements = Arrays.stream(stringWithoutSpace.split(""))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream()
				.filter(f -> f.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		
		

		System.out.println("Duplicate Element : " + duplicateElements);
		Set<String> setString = new HashSet<String>();
		
		List<String> collect = Arrays.stream(stringWithoutSpace.split("")).filter(f->!setString.add(f)).distinct().collect(Collectors.toList());
		System.out.println("Duplicated Element : " + collect);
		
		
		String input ="Welcome to java world";
		String integer = Arrays.stream(input.split(" ")).max(Comparator.comparingInt(String::length)).get();		
		System.out.println(integer);		
		
		Map<String,Long> collect2 = Arrays.stream(stringWithoutSpace.split("")).collect(Collectors.groupingBy(f->f, Collectors.counting()));
		System.out.println("collect2 : "+ collect2);
		
		List<String> collect3 = collect2.entrySet().stream().filter(f->f.getValue()>1).map(Entry::getKey).collect(Collectors.toList());
		System.out.println("collect3 : "+ collect3);

		String string = Arrays.stream(input.split(" ")).max(Comparator.comparingLong(String::length)).get();
		System.out.println("string : "+ string);
		
		
		int arr[] = new int[] {1,2,3,4,2,2,4};
		Arrays.stream(arr).boxed().distinct().forEach(System.out::println);
		
		Map<Integer, Long> collect4 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(f->f,Collectors.counting()));
		System.out.println("collect4 : "+ collect4);
		List<Entry<Integer,Long>> collect5 = collect4.entrySet().stream().filter(f->f.getValue()>1).collect(Collectors.toList());
		System.out.println("collect5 "+ collect5);
		
		List<Integer> collect6 = collect4.entrySet().stream().filter(f->f.getValue()>1).map(Entry::getKey).collect(Collectors.toList());
		System.out.println("collect6 "+ collect6);
		 
	}
}
