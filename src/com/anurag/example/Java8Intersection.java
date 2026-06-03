package com.anurag.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8Intersection {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
		List<String> otherList = Arrays.asList("red", "green", "green", "yellow");

		Set<String> collect = list.stream().distinct().filter(otherList::contains).collect(Collectors.toSet());
		System.out.println("Unique set :  " + collect);

		
		//Find vowels from a given String using stream API.
		String str = "Java is good for App developement";
		String strwithoutspace= str.replace(" ", "");
		List<String> listOfVovel = Arrays.asList("a","e","i","o","u");
		Set<String> collect2 = Arrays.stream(strwithoutspace.toLowerCase().split("")).filter(listOfVovel::contains).collect(Collectors.toSet());
		System.out.println("Vovle inside given sentance : " + collect2);
		
		
		// find the world that has highest length
		List<String> sentance = Arrays.asList("aabc", "aab", "aabwc", "aabc", "aabwcwer", "aabcsd");
		// 1St Ways using max()
		sentance.stream().max(Comparator.comparingInt(String::length)).get();

		// 2nd Ways using max()--length size
		sentance.stream().map(f->f.length()).max(Comparator.comparingInt(Integer::valueOf)).get();
		//using collectors
		sentance.stream().collect(Collectors.maxBy(Comparator.comparingInt(String::length))).get();
		//using Sorted
		sentance.stream().sorted((x,y)->x.length()>y.length()?-1:1).findFirst().get();
		//Using reduce
		
		
		
		
	}
}
