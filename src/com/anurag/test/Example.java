package com.anurag.test;

public class Example {
	public static void main(String... args) {
		new C111().hello();
	}
}

interface A111 {

	default void hello() {
		 System.out.println("Hello from A");
	 }
}

interface B111 {
	public default void hello() {
		System.out.println("Hello from B");
	}
}

class C111 implements B111, A111 {

	public void hello() {

		A111.super.hello();
		// B.super.hello();
	}
}

/*
 * public class Example { public static void main(String... args) { new
 * C111().hello(); } }
 */