package com.anurag.designpattern.builder;

public class Student {

	private String name;
	private String city;
	private int age;
	private int mobile;
	private String county;

	public Student(StudentBuilder builder) {
		super();
		this.name = builder.name;
		this.city = builder.city;
		this.age = builder.age;
		this.mobile = builder.mobile;
		this.county = builder.county;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", city=" + city + ", age=" + age + ", mobile=" + mobile + ", county=" + county
				+ "]";
	}


	public static class StudentBuilder {
		private String name;
		private String city;
		private int age;
		private int mobile;
		private String county;

		public StudentBuilder(String name) {
			this.name = name;
		}

		public StudentBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public StudentBuilder setCity(String city) {
			this.city = city;
			return this;
		}

		public StudentBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public StudentBuilder setMobile(int mobile) {
			this.mobile = mobile;
			return this;

		}

		public StudentBuilder setCounty(String county) {
			this.county = county;
			return this;
		}

		public Student build() {
			return new Student(this);
		}

	}
}
