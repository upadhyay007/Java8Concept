package com.anurag.mostspecific;
//https://javahungry.blogspot.com/p/answers.html
public class MostSpecificInJavaExample01 {

	public static void main(String[] args) {
//		show('1');
		// show('h');
		// show(10);
		 show(null);
	}

//	public static void show(String str) {
//		System.out.println("String Type Parameter");
//	}

	public static void show(char ch) {
		System.out.println("Object Type Parameter");
	}

	public static void show(Object object) {
		System.out.println("Object Type Parameter");
	}

//	public static void show(Integer integer) {
//		System.out.println("Integer Type Parameter");
//	}

}
