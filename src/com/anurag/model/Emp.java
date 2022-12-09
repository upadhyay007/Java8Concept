package com.anurag.model;

import java.util.Date;

public class Emp {
	private String name;
	private int Age;
	private int Salary;
	private String Department;
	private Date DOJ;
	
	
	public Emp(String name, int age, int salary, String department, Date dOJ) {
		super();
		this.name = name;
		Age = age;
		Salary = salary;
		Department = department;
		DOJ = dOJ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public long getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public Date getDOJ() {
		return DOJ;
	}
	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", Age=" + Age + ", Salary=" + Salary + ", Department=" + Department + ", DOJ="
				+ DOJ + "]";
	}
	
}
