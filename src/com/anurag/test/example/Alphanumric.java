package com.anurag.test.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Write a Program to print only numbers from alphanumeric char array using stream API in java-8.
public class Alphanumric {
	
	public static void main(String[] args) {
		char[] alphanumericArray = {'a', '1', 'b', '2', 'c', '3', 'd', '8', 'e', '5'};
		
		 Stream<Character> mapToObj = new String(alphanumericArray).chars().mapToObj(i -> (char)i);
		 mapToObj.filter(Character::isDigit).forEach(System.out::println);
		 
		 Stream<Character> mapToObj1 = new String(alphanumericArray).chars().mapToObj(i -> (char)i);
		 mapToObj1.mapToInt(Character::getNumericValue)
	      .filter(i -> i != -1)
	      .forEach(System.out::print);
		  
 
		 
	}
}
