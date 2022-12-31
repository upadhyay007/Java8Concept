package com.anurag.mostspecific;
//https://javahungry.blogspot.com/p/answers.html
public class MostSpecificInJavaExample02 {

	public static void main(String[] args) {
		 show(null);
	}

	public static void show(Exception exception) {
		System.out.println("Exception Type Parameter");
	}

	public static void show(ArithmeticException arithmeticException) {
		System.out.println("ArithmeticException Type Parameter");
	}
	
	public static void show(Object object) {
		System.out.println("Object Type Parameter");
	}


}
