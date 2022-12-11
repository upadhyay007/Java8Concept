package com.anurag.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8TypeOfStream {
	public static void main(String[] args) {
		// https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

		// To find first element of the array
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println); // a1

		// Just use Stream.of() to create stream
		Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println);// a1

		// Given input "a1", "a2", "b1", "c2", "c1" --> required outputs C1,C2
		// Filter -----> Intermediate
		// map -----> Intermediate
		// sorted -----> Intermediate
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		myList.stream().filter(f -> f.startsWith("c")).map(m -> m.toUpperCase()).sorted().forEach(System.out::println);

		// IntStreams can replace the regular for loop
		IntStream.range(1, 4).forEach(System.out::println);

		// Primitive Stream Support the additionL terminal aggregate operations sum() and average()
		Arrays.stream(new int[] { 1, 2, 3 }).map(n -> 2 * n + 1).average().ifPresent(System.out::println);
		
		//To Transfer a regular object stream to a primitive stream or vice versa
		//maptoInt()
		//mapToLong()
		//mapToDouble()
		Stream.of("a1","a2","a3").map(s->s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);
		
		
		//Primitive can be transformed to objects streams via mapToObj()
		IntStream.range(1, 4).mapToObj(i->"a"+i).forEach(System.out::println);  // out put -> a1,a2,a3
		
		
		//Stream of double 
		Stream.of(1.0,2.0,3.0).mapToInt(Double::intValue).mapToObj(i->"a"+1).forEach(System.out::println);

	}
}
