package com.anurag.example1;

import java.util.Arrays;
import java.util.LinkedHashMap;
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
	}
}
