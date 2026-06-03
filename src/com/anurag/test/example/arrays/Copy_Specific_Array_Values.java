package com.anurag.test.example.arrays;

public class Copy_Specific_Array_Values {
	public static void main(String[] args) {
		char ch[] = { 'S', 'o', 'f', 't', 'w', 'a', 'r', 'e', 'D', 'e', 'v','e', 'l', 'o', 'p', 'm', 'e', 'n', 't' };

		/** * We can copy a char array to a string by using * copyValueOf() method. */
		String chStr = String.copyValueOf(ch);
		System.out.println("Original Array Values :- " + chStr);
		
		
		String subStr = String.copyValueOf(ch,8,7); 
	      System.out.println("Substring From The Original String :-"+subStr);
	}
}
