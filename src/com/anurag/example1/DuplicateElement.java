package com.anurag.example1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
	}
}
