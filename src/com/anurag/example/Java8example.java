package com.anurag.example;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.anurag.model.Employee;

public class Java8example {
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

		// 1.Print the higest paid employee in each department 
		// 2.How many male and female employee are there in organization.
		// 3.List name of male and female employee are there in organization.
		// 4.Print All the name of the department of organization.
		// 5.What is the avg age of male and female employee in organization.
		// 6.Get the details of highest paid employee in organization.
		// 7.Get name of all the empoyee who has joined after 2015.
		// 8.Count the no.of employee in each department.
		// 9.what is the avarage salary of each department.
		// 10.Get the details of youngest male employee in the product developement
		// department.
		// 11.who has the most working experiences in the orgination
		// 12.How many male and female employee are there in sales and marketing teams.
		// 13.what is the average salary of male and female empleoyee.
		// 14.List down the name of all employee of each department.
		// 15.what is average salary and total salary of whole orgaization.
		// 16.Seperate the employee who are younger or equal to 25 from those employee
		// who are older than 25.
		// 17.who is the oldest employee in the orgination? what is is age and which
		// department he belongs to.
		// 18. Group all employee who has same age
		// 19. Group all employee name who has same age
		// 20. List down the name of all employee of each department.
		// 21. Print the higest paid employee in each department 

		// 22. Counting the frequency of employee age
		Map<Integer, Long> collect = employeeList.stream()
				.collect(Collectors.groupingBy(f -> f.getAge(), Collectors.counting()));
		System.out.println("Counting the frequency of employee age--> " + collect);
		
		// 2. How many male and female employee are there in organization.
		Map<String, Long> collect2 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(collect2);
		
		// 3. List name of male and female employee are there in organization.
		Map<String, List<String>> maleFemaleName = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Male and Female employee name " + maleFemaleName);

		// 4. Print All the name of the department of organization.
		List<String> listOfDepartmentName = employeeList.stream().map(a -> a.getDepartment())
				.collect(Collectors.toList());
		System.out.println("list Of Department Name" + listOfDepartmentName);

		// 5. What is the avg age of male and female employee in organization.
		Map<String, Double> avgOfMaleAndFemale = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("Avg Of Male And Female " + avgOfMaleAndFemale);

		// 6. Get the details of highest paid employee in organization.
		Optional<Employee> collect3 = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("Get higest salary dertails : " + collect3.get().getName());
		
		Map<String, Optional<Employee>> higestSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		System.out.println("Get higest salary dertails : " + higestSalary);
		// 7. Get name of all the empoyee who has joined after 2015.
		List<String> collect4 = employeeList.stream().filter(f -> f.getYearOfJoining() > 2015).map(Employee::getName)
				.collect(Collectors.toList());
		System.out.println("Employee joined after 2015 : " + collect4);

		// 8. Count the no.of employee in each department.
		Map<String, Long> collect5 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Count  employee in each department : " + collect5);

		// 9. what is the avarage salary of each department.
		Map<String, Double> collect6 = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("AvarageSalary :  " + collect6);

		// 10. Get the details of youngest male employee in the product development
		// department.
		Optional<Employee> min = employeeList.stream()
				.filter(f -> f.getDepartment().equals("Product Development") && f.getGender().equals("Male"))
				.min(Comparator.comparingInt(Employee::getAge));
		System.out.println("Youngest male in product development : " + min.get().getName());

		Optional<Employee> minOtherways = employeeList.stream()
				.filter(f -> f.getDepartment().equals("Product Development") && f.getGender().equals("Male"))
				.collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
		System.out.println("Youngest male in product development minOtherways  : " + minOtherways.get().getName());

		// 11. who has the most working experiences in the orgination
		Optional<Employee> findFirst = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining))
				.findFirst();
		System.out.println("Most working  experience : " + findFirst.get().getName());

		// 12. How many male and female employee are there in sales and marketing teams.
		Map<String, Long> collect7 = employeeList.stream().filter(f -> f.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Male and femail employee : " + collect7);

		// 13. what is the average salary of male and female employee.
		Map<String, Double> collect8 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average salary of male and female : " + collect8);

		// 14. List down the name of all employee of each department
		Map<String, List<Employee>> collect9 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("All employee of each department : " + collect9);

		// 15. what is average salary and total salary of whole organization.
		DoubleSummaryStatistics collect10 = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("AverageSalary : " + collect10.getAverage());
		System.out.println("Total salary : " + collect10.getSum());

		// 16. Separate the employee who are younger or equal to 25 from those employee who
		// are older than 25
		Map<Boolean, List<Employee>> collect11 = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		System.out.println("Employee younger than 25 : " + collect11.size());

		// 17. who is the oldest employee in the organization? what is is age and which
		// department he belongs to.
		Optional<Employee> max = employeeList.stream().max(Comparator.comparingDouble(Employee::getAge));
		System.out.println("Max : " + max.get().getName());

		// 18. Group all employee who has same age
		Map<Integer, List<Employee>> collect12 = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println("All employee who has same age--> " + collect12);
		// other ways 
		Map<Integer, Long> collect14 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
		System.out.println("All employee who has same age--> " + collect14);

		// 19. Group all employee name who has same age
		Map<Integer, List<String>> collectAllSameName = employeeList.stream().collect(
				Collectors.groupingBy(f -> f.getAge(), Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("All employee name who has same age " + collectAllSameName);

		// 20. List down the name of all employee of each department.
		Map<String, List<Employee>> collect16 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
		
		collect16.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + "--> " + entry.getValue());
		});
		
		//1 Print the higest paid employee in each department 
		System.out.println("-----Print the higest paid employee in each department ----");
		Map<String, Optional<Employee>> collect19 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		collect19.entrySet().forEach(e->{System.out.println(e.getKey() +"--> "+ e.getValue().get());});
		
		// Other ways using ollectors.reducing 
		Map<String, Optional<Employee>> collectOtherways = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary)))));
		collectOtherways.entrySet().forEach(e->{System.out.println(e.getKey() +"--> "+ e.getValue().get());}); 
	}
}
