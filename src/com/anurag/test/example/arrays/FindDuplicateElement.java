package com.anurag.test.example.arrays;

import java.util.HashSet;

public class FindDuplicateElement {
	public static void main(String[] args) {		
	      String[] strArray = {"abc", "def", "mno", "xyz", "pqr", "xyz", "def"};
	      HashSet<String> set = new HashSet<String>(); 
	      for (String arrayElement : strArray)
	      {
	         if(!set.add(arrayElement))
	         {
	            System.out.println("Duplicate Element is : "+arrayElement);
	         }
	      }
	      String s="hello";
	      System.out.println("Substring :  " + s.substring(0));
	      System.out.println("Char At   :  " + s.charAt(0));
	      System.out.println("Substring :  " + s.substring(1,4));
	      
	      
	      
	      
	      
	}
}
