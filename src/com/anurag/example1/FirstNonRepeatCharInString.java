package com.anurag.example1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstNonRepeatCharInString {
	public static void main(String[] args) {

		// Find first non repeatlable element from given stream
		
		String originalString = "i love java programming";
		String stringWithoutSpace = String.valueOf(originalString.replace(" ", ""));

		String key = Arrays.stream(stringWithoutSpace.split(""))
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(f -> f.getValue() == 1).findFirst().get().getKey();
		System.out.println("First non repeatable element : " + key);
		
		// other ways
		Set<String> str = new HashSet<>();
		String other = Arrays.stream(stringWithoutSpace.split("")).filter(f->!str.add(f)).findFirst().get();
		System.out.println("Other ways : " + other );
		
		
		String key2 = Arrays.stream(stringWithoutSpace.split("")).collect(Collectors.groupingBy(f->f, LinkedHashMap::new ,Collectors.counting())).entrySet()
		.stream().filter(f->f.getValue()==1).findFirst().get().getKey();
		System.out.println("Key 2 : " + key2);
		
		
		
	}
}
