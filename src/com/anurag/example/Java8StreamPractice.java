package com.anurag.example; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.anurag.model.Employee;

public class Java8StreamPractice {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// 1.Print the highest paid employee in each department
		Map<String, List<Employee>> collect = employeeList.stream()
				.collect(Collectors.groupingBy((s) -> s.getDepartment()));
		// System.out.println(collect);
		Map<String, Optional<Employee>> collect2 = employeeList.stream().collect(Collectors.groupingBy(
				(s) -> s.getDepartment(), Collectors.maxBy(Comparator.comparingDouble((s) -> s.getSalary()))));
		collect2.entrySet().forEach((f) -> {
			System.out.println(f.getKey() + "->" + f.getValue().get() + ": " + f.getValue().get().getSalary());
		});
		System.out.println("----------------------------------------");
		employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))).entrySet().forEach(s -> {
					System.out.println(s.getKey() + " : " + s.getValue().get());
				});
		System.out.println("----------------------------------------");

		// 2.How many male and female employee are there in organization.
		Map<String, Long> maleAndFemaleInDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		System.out.println(maleAndFemaleInDept);
		System.out.println("----------------------------------------");
		// 3.List name of male and female employee are there in organization.
		Map<String, List<String>> collect3 = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(collect3);
		System.out.println("----------------------------------------");
		Map<String, Map<String, List<String>>> collect4 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender,
						Collectors.mapping(Employee::getName, Collectors.toList()))));

		// 4.Print All the name of the department of organization.
		System.out.println("----------------------------------------");
		employeeList.stream().map(f -> f.getDepartment()).distinct().forEach(s -> System.out.println(s));
		System.out.println("----------------------------------------");
		employeeList.stream().map(f -> f.getDepartment()).distinct().collect(Collectors.toList())
				.forEach(System.out::println);
		System.out.println("----------------------------------------");
		// 5.What is the avg age of male and female employee in organization.
		Map<String, Double> collect5 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println(collect5);
		System.out.println("----------------------------------------");
		// What is the avg age of male and female employee in organization department
		// wise.
		Map<String, Double> collect6 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getAge)));
		System.out.println(collect6);
		System.out.println("----------------------------------------");
		// 6.Get the details of highest paid employee in organization.
		Optional<Employee> optional = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(optional.get().getName());
		System.out.println("----------------------------------------");
		// 7.Get name of all the empoyee who has joined after 2015.
		List<Employee> collect7 = employeeList.stream().filter(f -> f.getYearOfJoining() > 2015)
				.collect(Collectors.toList());
		System.out.println(collect7);
		System.out.println("----------------------------------------");
		// 8.Count the no.of employee in each department.
		Map<String, Long> collect8 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(collect8);
		System.out.println("----------------------------------------");
		// 9.what is the avarage salary of each department.
		Map<String, Double> collect9 = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(collect9);
		// 10.Get the details of youngest male employee in the product development
		// department.
		System.out.println("----------------------------------------");
		Optional<Employee> collect10 = employeeList.stream()
				.filter(f -> f.getGender().equals("Male") && f.getDepartment().equals("Product Development"))
				.collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
		System.out.println(collect10);
		System.out.println("----------------------------------------");
		Optional<Employee> min = employeeList.stream()
				.filter(f -> f.getGender().equals("Male") && f.getDepartment().equals("Product Development"))
				.min(Comparator.comparingLong(Employee::getAge));
		System.out.println(min);
		System.out.println("----------------------------------------");
		// 11.who has the most working experiences in the origination
		Optional<Employee> findFirst = employeeList.stream()
				.sorted(Comparator.comparingDouble(Employee::getYearOfJoining)).findFirst();
		System.out.println(findFirst);
		System.out.println("----------------------------------------");
		// 12.How many male and female employee are there in sales and marketing teams.
		Map<String, Long> collect11 = employeeList.stream().filter(f -> f.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(collect11);

		System.out.println("----------------------------------------");
		// 13.what is the average salary of male and female employee.
		Map<String, Double> collect12 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(collect12);
		System.out.println("----------------------------------------");
		// 14.List down the name of all employee of each department.
		employeeList.stream().map(f -> f.getDepartment()).distinct().forEach(System.out::println);
		System.out.println("----------------------------------------");
		// 15.what is average salary and total salary of whole organization.
		DoubleSummaryStatistics collect14 = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(collect14.getAverage());
		System.out.println(collect14.getSum());
		System.out.println("----------------------------------------");
		// 16.Separate the employee who are younger or equal to 25 from those employee
		Map<Boolean, List<Employee>> collect15 = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() >= 25));
		System.out.println(collect15);
		System.out.println("----------------------------------------");
		// who are older than 25.
		// 17.who is the oldest employee in the organization? what is is age and which
		Employee collect16 = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed())
				.findFirst().get();
		System.out.println(collect16);
		System.out.println("----------------------------------------");
		// department he belongs to.
		// 18. Group all employee who has same age
		Map<Integer, List<Employee>> collect17 = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println(collect17);
		System.out.println("----------------------------------------");
		// 19. Group all employee name who has same age
		Map<Integer, List<String>> map = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(map);
		System.out.println("----------------------------------------");
		// 20. List down the name of all employee of each department.
		Map<String, List<String>> map1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(map1);
		// 21. Print the highest paid employee in each department
		// employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getSalary,
		// Collectors.(Comparator.comparingDouble(Employee::getSalary)))));
		System.out.println("----------------------------------------");
		// employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getSalary,
		// Collectors.(Comparator.comparingDouble(Employee::getSalary)))));
		Map<String, Employee> higestSalaryinEachDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
		System.out.println("higestSalaryinEachDept : " + higestSalaryinEachDept);

		// max salary in each department java 8--https://stackoverflow.com/questions/36040945/java-8-lambda-for-selecting-top-salary-employee-for-each-department
		System.out.println("----------------------------------------");
		// 22. Counting the frequency of employee age
		Map<Integer, Long> frequency = employeeList.stream().map(f -> f.getAge())
				.collect(Collectors.groupingBy(f -> f, Collectors.counting()));
		Map<Integer, Long> frequency1 = employeeList.stream()
				.collect(Collectors.groupingBy(f -> f.getAge(), Collectors.counting()));
		System.out.println(frequency);
		System.out.println("----------------------------------------");
		System.out.println(frequency1);
		

	}
}
