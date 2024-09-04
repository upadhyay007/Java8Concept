package com.anurag.interfaceRule;

interface A1 {
	public default void sayIt() {
		System.out.println("Hello From A1");
	}
}

interface A2 {
	public default void sayIt() {
		System.out.println("Hello From A2");
	}
}

public class MultipleInheritanceRule implements A1, A2 {

	public static void main(String[] args) {
		new MultipleInheritanceRule().sayIt();// fail
	}

	@Override
	public void sayIt() {
		// TODO Auto-generated method stub
		A2.super.sayIt();
	}
}
