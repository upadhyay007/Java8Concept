package com.anurag.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Example1 {
	public static void main(String[] args) {
		String str =  "AnuragUpadhyay";

		Set<String> setValue =new HashSet();
		String string = Arrays.stream(str.split("")).filter(f->!setValue.add(f)).findFirst().get();
		System.out.println("String : " +  string);
		String[] strings={"10","12","3","9","49"};
		// plz sort given numbers in java8?
		
		Arrays.stream(strings).mapToInt(f->Integer.valueOf(f)).sorted().forEach(System.out::println);
		//Arrays.stream(strings).mapToInt(f->Integer.valueOf(f)).sorted().collect(Collectors.toList());
		
		}
}
