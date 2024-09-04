package com.anurag.test;

public class Test1 {

	public void m1(String str1) {
		str1 = "hello";

		
	}

	private static int  javaoceanTryCatch() {

		try {
			System.out.println("Try");
			int i=4/0;
			return 10;
		} catch (Exception e) {
			System.out.println("Catch");
		} finally {
			System.out.println("Finally");
			return 88;
		}
	
	}

	@SuppressWarnings("finally")
	private static int javaocean() {
		try {
			System.out.println("Try");
			return 10;
		} catch (Exception e) {
			System.out.println("Catch");
		} finally {
			System.out.println("Finally");
			return 12;
		}
	}

	public static void main(String[] args) {
		Test1 test1 = new Test1();
		String s1 = "hey";
	//	test1.m1(s1);
	//	System.out.println(s1);
		
		int i = javaocean();
		System.out.println(i);
		int javaoceanTryCatch = javaoceanTryCatch();
		System.out.println(javaoceanTryCatch);
	}
}
