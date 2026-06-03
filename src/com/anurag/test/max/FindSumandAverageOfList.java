package com.anurag.test.max;

import java.util.Arrays;
import java.util.List;

public class FindSumandAverageOfList {
	public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17,20
                );
        
        int sum = numbers.stream().mapToInt(n->n).sum();
        System.out.println("Sum : " + sum);
        
        
	}
}
