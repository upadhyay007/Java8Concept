package com.anurag.example1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueElement {
	public static void main(String[] args) {
		String originalString = "i love java programming";
		String stringWithoutSpace = String.valueOf(originalString.replace(" ", ""));

		// Find unique emelent in given string

		List<String> uniqueElements = Arrays.stream(stringWithoutSpace.split(""))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream()
				.filter(f -> f.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());

		System.out.println("Duplicat Element : " + uniqueElements);
	}
}
