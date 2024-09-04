package com.anurag.example1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCount {
	public static void main(String[] args) {
		String originalString = "i love java programming";
		String stringWithoutSpace = String.valueOf(originalString.replace(" ", ""));

		// Find the frequency of each words

		Map<String, List<String>> list = Arrays.stream(stringWithoutSpace.split(""))
				.collect(Collectors.groupingBy(c -> c));
		Map<String, Long> collect = Arrays.stream(stringWithoutSpace.split(""))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		Map<String, Long> otherWaysToCountFrequency = Arrays.stream(stringWithoutSpace.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<String, List<String>> listof = Arrays.stream(stringWithoutSpace.split(""))
				.collect(Collectors.groupingBy(Function.identity()));

		System.out.println("Frequency list of each occurence  -> " + list);
		System.out.println("Frequency count of each occurence -> " + collect);
		System.out.println("Frequency other ways to count     -> " + otherWaysToCountFrequency);

		System.out.println("Frequency list of each occurence other ways -> " + listof);

		// Find the most repeated number
		List<Integer> findMostRepetedValue = Arrays.asList(1, 7, 7, 20, 7, 2, 7, 5, 24, 22, 14, 23);
		Integer key = findMostRepetedValue.stream().collect(Collectors.groupingBy(f -> f, Collectors.counting()))
				.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue())).findFirst().get()
				.getKey();
		System.out.println(key);
		
		
		// find the world that has higest length
		List<String> sentance = Arrays.asList("aabc", "aab", "aabwc", "aabc", "aabwcwer", "aabcsd");
		// 1St Ways using max()
		String higestLength = sentance.stream().max(Comparator.comparingInt(String::length)).get();
		System.out.println("higestLength :  " + higestLength);
		Optional<Integer> max = sentance.stream().map(String::length).max(Integer::compare);
		System.out.println("max : "+  max);
		// 2nd Ways using max()--length size
		Integer higestLength1 = sentance.stream().map(String::length).max(Integer::compare).get();
		System.out.println("higestLength :  " + higestLength1);
		//using collectors
		String string1 = sentance.stream().collect(Collectors.maxBy(Comparator.comparingInt(String::length))).get();
		System.out.println("HigestLength :" + string1);
		//using Sorted
		String string2 = sentance.stream().sorted((x,y)->x.length()>y.length()?-1:1).findFirst().get();
		System.out.println("string2 : " + string2);
		
		//Using reduce
		String string = sentance.stream().reduce((x,y)->x.length()>y.length()?x:y).get();
		System.out.println("HigestString : " + string);

	}
}
