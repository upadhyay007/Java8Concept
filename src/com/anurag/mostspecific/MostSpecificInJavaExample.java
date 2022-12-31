package com.anurag.mostspecific;

public class MostSpecificInJavaExample {
	
	public static void main(String[] args) {
		show(null);
	}

	public static void show(String str) {
		System.out.println("String Type Parameter");
	}

	public static void show(Object object) {
		System.out.println("Object Type Parameter");
	}
}
