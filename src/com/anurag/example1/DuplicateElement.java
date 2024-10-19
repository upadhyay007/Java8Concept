package com.anurag.example1;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateElement {
	public static void main(String[] args) {
		String originalString = "i love java programming";
		String stringWithoutSpace = String.valueOf(originalString.replace(" ", ""));

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
		
		
		 
	}
}
