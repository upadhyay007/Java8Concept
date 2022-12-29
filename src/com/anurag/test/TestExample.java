package com.anurag.test;

public class TestExample {
	public void main(){
        //some code
   }
	
	public static void main(String[] args) {
		ABC abc = new CDE(1);
		// ABC abc = new CDE();
		// ABC abc = new ABC(1);
		// CDE cde = new CDE(1);
	}
}

class ABC {
	static {
		System.out.println("static block of ABC");
	}

	public static void display() {
		System.out.println("static method class ABC");
	}

	public ABC() {
		System.out.println("No parameterized constructor ABC");
	}

	public ABC(int a) {
		System.out.println("Parameterized constructor ABC " + a);
	}
}

class CDE extends ABC {
	static {
		System.out.println("static block CDE");
	}

	public static void display() {
		System.out.println("static method class CDE");
	}

	public CDE() {
		System.out.println("No parameterized constructor CDE");
	}

	public CDE(int a) {
		System.out.println("Parameterized constructor CDE");
	}
}