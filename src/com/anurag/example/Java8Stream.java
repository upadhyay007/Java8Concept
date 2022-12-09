package com.anurag.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.anurag.model.Emp;

public class Java8Stream {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(12, 24, 45, 67, 88, 99, 48));

		// Find the distinct number from arrays that is greater than 20 using stream API
		List<Integer> collect = arrayList.stream().distinct().filter(n -> n > 20).collect(Collectors.toList());
		System.out.println("Distinct No greater than 20 in array : " + collect);

		// Count the occurrence of given character in string using streamAPI
		String str = "Better Butter";
		String stringwithoutspace = String.valueOf(str.replace(" ", ""));
		Map<String, Long> countoccurence = Arrays.stream(stringwithoutspace.split(""))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println("Count the occurence of fiven character :  " + countoccurence);

		// Find the nth Largest number in an Arrays or List or stream API
		ArrayList<Integer> intArr = new ArrayList<Integer>(Arrays.asList(12, 24, 45, 67, 88, 99, 48));
		Integer nth = intArr.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(2 - 1);
		System.out.println("nth Largest : " + nth);

		// Find the word which start with a "T" from a given string using stream API
		String sentance = "Hi guys welcome to the Teams";
		List<String> collect2 = Arrays.stream(sentance.split(" ")).filter(s -> s.startsWith("T"))
				.collect(Collectors.toList());
		System.out.println("Word start with 'T' : " + collect2);

		// Count the no of employee in each department
		List<Emp> emp = new ArrayList<>();
		emp.add(new Emp("Jay", 24, 25000, "IT", new Date(2009, 01, 22)));
		emp.add(new Emp("Rehman", 45, 55000, "Testing", new Date(2021, 01, 02)));
		emp.add(new Emp("Rajan", 34, 120000, "Prodcution", new Date(2012, 11, 12)));
		emp.add(new Emp("Sagar", 46, 320000, "Testing", new Date(2016, 03, 02)));
		emp.add(new Emp("Abhijit", 26, 50000, "IT", new Date(2010, 06, 23)));
		
		Map<String, Long> collect3 = emp.stream().collect(Collectors.groupingBy(Emp::getDepartment, Collectors.counting()));
		System.out.println("Count the no of employee in each department : "+  collect3);
		//Find the employee who joined after 2010 using stream API
		
		List<Emp> collect4 = emp.stream().filter(f->f.getDOJ().getYear()>2010).collect(Collectors.toList());
		System.out.println("Employee Who joined after 2010 : " + collect4);
		
		//Count the employee who have an age greater than 30 years using Stream API
		long count = emp.stream().filter(e->e.getAge()>30).count();
		System.out.println("Total emoloyee greater the certain age : " + count);
		
		// Sort employees by salary in descending order using comparator
		List<Emp> collect5 = emp.stream().sorted(Comparator.comparingDouble(Emp::getSalary).reversed()).collect(Collectors.toList());
		System.out.println(collect5);
		
		//Sort employees by their age and Department using a comparator in Stream API
		List<Emp> collect6 = emp.stream().sorted(Comparator.comparing(Emp::getAge).thenComparing(Emp::getDepartment)).collect(Collectors.toList());
		System.out.println("Sorted List : " +  collect6);
		
		
		//Find the top 3 most salaried employees using Stream API
		List<Emp> collect7 = emp.stream().sorted(Comparator.comparing(Emp::getSalary).reversed()).limit(3).collect(Collectors.toList());
		System.out.println("Top # slries person :  " + collect7);
		
	}
}
