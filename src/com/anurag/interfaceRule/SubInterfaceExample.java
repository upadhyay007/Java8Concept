package com.anurag.interfaceRule;

interface A {
	public default void sayIt() {
		System.out.println("Hello From A");
	}
}

interface B extends A {
	public default void sayIt() {
		System.out.println("Hello From B");
	}

}

public class SubInterfaceExample implements B {
	public void callMetod() {
		sayIt();
	}

	public static void main(String[] args) {
		SubInterfaceExample  example = new SubInterfaceExample();
		example.callMetod();
	}

}
