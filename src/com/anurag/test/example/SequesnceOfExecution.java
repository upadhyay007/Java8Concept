package com.anurag.test.example;

public class SequesnceOfExecution extends A {
	public SequesnceOfExecution() {
		System.out.println("constructor stub");
	}

	static {
		System.out.println("static block!!");
	}
	{
		System.out.println("Insilizer block");
	}

	public static void main(String[] args) {
		SequesnceOfExecution execution = new SequesnceOfExecution();
		System.out.println("----------------");
		SequesnceOfExecution execution1 = new SequesnceOfExecution();

	}
}

class A {
	public A() {
		System.out.println("Constructor-A");
	}

	static {
		System.out.println("Static - A");
	}

	{
		System.out.println("Non Static - A");
	}
}