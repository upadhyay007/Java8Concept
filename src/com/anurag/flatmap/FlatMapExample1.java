package com.anurag.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample1 {
	public static void main(String[] args) {

		Stream<List<Integer>> listOfInteger = Stream.of(Arrays.asList(1,2,3,4,5),Arrays.asList(7,8,9,10,11,12));
//		List<List<Integer>> collect = listOfInteger.collect(Collectors.toList());
//		System.out.println("Just Collocted " + collect);
//		System.out.println("Applying flatmap on list of list");

	//	List<Integer> collect2 = listOfInteger.flatMap(n->n.stream()).collect(Collectors.toList());
	//	System.out.println("calling flat map : " +collect2);
		
		
		//List<List<Integer>> collect = listOfInteger.collect(Collectors.toList());
		//System.out.println("Collects :  "+ collect);
		
		List<Integer> collect2 = listOfInteger.flatMap(f->f.stream()).collect(Collectors.toList());
		System.out.println("Collectors : " + collect2);
		
		
	}
}
