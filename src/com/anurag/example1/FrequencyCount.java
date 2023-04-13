package com.anurag.example1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCount {
	public static void main(String[] args) {
		String originalString = "i love java programming";
		String stringWithoutSpace = String.valueOf(originalString.replace(" ", ""));
		
		// Find the frequency of each words
		
		Map<String, List<String>> list = Arrays.stream(stringWithoutSpace.split("")).collect(Collectors.groupingBy(c->c));
		Map<String, Long> collect = Arrays.stream(stringWithoutSpace.split("")).collect(Collectors.groupingBy(c->c, Collectors.counting()));
	    Map<String, Long> otherWaysToCountFrequency = Arrays.stream(stringWithoutSpace.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		Map<String, List<String>> listof = Arrays.stream(stringWithoutSpace.split("")).collect(Collectors.groupingBy(Function.identity()));
		
		System.out.println("Frequency list of each occurence  -> " + list);
		System.out.println("Frequency count of each occurence -> " + collect);
		System.out.println("Frequency other ways to count     -> " + otherWaysToCountFrequency);

		System.out.println("Frequency list of each occurence other ways -> " + listof);	
	 
	} 
}
