package com.anurag.designpattern.builder;
/**
 * Outer Class
 */
public class Student {
	private String name; 
	private String city;    
	private int age;        // Optional Parameter
	private int mobile;	    // Optional Parameter
	private String county;  // Optional Parameter

	/**
	 * Private Constructor
	 * 
	 * @param builder
	 */
	private Student(StudentBuilder builder) {
		super();
		this.name = builder.name;
		this.city = builder.city;
		this.age = builder.age;
		this.mobile = builder.mobile;
		this.county = builder.county;
	}

	/**
	 * Generate only getter
	 */
	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public int getAge() {
		return age;
	}

	public int getMobile() {
		return mobile;
	}

	public String getCounty() {
		return county;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", city=" + city + ", age=" + age + ", mobile=" + mobile + ", county=" + county
				+ "]";
	}

	/**
	 * Create Static inner Class
	 *
	 */
	public static class StudentBuilder {
		private String name;
		private String city;
		private int age;
		private int mobile;
		private String county;

		/**
		 * Public Constructor with required field only
		 * 
		 * @param name
		 */
		public StudentBuilder(String name) {
			this.name = name;
		}

		/**
		 * Generate only Setter That return this, ie, Object of Static Inner Class
		 */
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

		/**
		 * This is required method 
		 * This method will invocke private constructor of OuterClass
		 * 
		 */
		public Student build() {
			return new Student(this);
		}

	}
}
