package com.anurag.designpattern.builder;

// Understand it form https://www.adevguide.com
public class TestBuilder {
	public static void main(String[] args) {
		
		Student student = new Student.StudentBuilder("Anurag")
				.setAge(99)
				.setMobile(999999)
				.setCounty("INDIA")
				.build();
		
		System.out.println(student);
	
	}

}
