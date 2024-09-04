package com.anurag.test.max;

import java.util.Arrays;

public class Java8AndArraysExample {
	public static void main(String[] args) {
		int[] numbers = {5, 9, 11, 2, 8, 21, 1};
		
	int asInt = Arrays.stream(numbers).max().getAsInt();
	System.out.println("MAx : "+  asInt);
	
	int asInt2 = Arrays.stream(numbers).reduce(Integer::max).getAsInt();
	System.out.println(asInt2);
	
	int asInt3 = Arrays.stream(numbers).reduce((x,y)->Integer.max(x, y)).getAsInt();
	System.out.println("As Int : "+ asInt3);
	
	int asInt4 = Arrays.stream(numbers).reduce((x,y)->Math.max(x, y)).getAsInt();
	System.out.println("AsInt4 : "+ asInt4);
	
	int asInt5 = Arrays.stream(numbers).reduce((x,y)->x> y?x:y).getAsInt();
	System.out.println("AsInt5 : "+ asInt5);
	
	}
}
