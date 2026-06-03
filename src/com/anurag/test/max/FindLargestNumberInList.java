package com.anurag.test.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindLargestNumberInList {
	public static void main(String[] args) {
        // random numbers
        List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);
        Integer integer = numbers.stream().max(Integer::compareTo).get();
        System.out.println("Integer : " +integer);
        
        Integer integer1 = numbers.stream().max(Integer::compare).get();
        System.out.println("Integer : " +integer1);
        
        Integer integer2 = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Integer2 : "+ integer2);
        
        Optional<Integer> collect = numbers.stream().collect(Collectors.maxBy(Comparator.comparing(Integer::valueOf)));
        System.out.println("Max : "+ collect.get());
        
        Integer reduce1 = numbers.stream().reduce(Integer::max).get();
        System.out.println("REduce :"+ reduce1);
        
        Integer integer3 = numbers.stream().reduce(Math::max).get();        
        System.out.println("Reduce and MAth.get" +integer3);
        
        Integer integer4 = numbers.stream().reduce((x,y)->x>y?x:y).get();
        System.out.println("Binary : "+ integer4);
        
        Integer integer6 = numbers.stream().reduce((x,y)->Integer.max(x, y)).get();
        System.out.println("Integer.max Reduce : "+ integer6);
        
        Integer integer5 = numbers.stream().reduce((x,y)->Math.max(x, y)).get();
        System.out.println("Math.max Reduce : "+ integer5);
        
        
        
        
	}

}
