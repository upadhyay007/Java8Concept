package com.anurag.interfaceRule;

// Rule 1: if A Class extends class and implements interface having same method signature, Super class’s method takes priority over an interface's default method.
class HelloClass{
	public void sayIt() {
		System.out.println("Hello From Class");
	}
}

interface HelloInterface{
	default void sayIt() {
		System.out.println("Hello From Interface");
	}
}


public class Hello  extends HelloClass implements HelloInterface{
	public static void main(String[] args) {
		 new Hello().sayIt();
	}

}
