package com.anurag.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.anurag.model.Emp;
import com.anurag.model.Employee;

public class Practice {

	/**
	 * @param args
	 */
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
		Map<String, Optional<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		System.out.println("Higest Paid Employee in Each Department : " + collect);

		// 2.How many male and female employee are there in organization.
		Map<String, Long> collect2 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("how many male and female in orgination : " + collect2);
		// 3.List name of male and female employee are there in organization.
		Map<String, List<String>> collect3 = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("NAme of all male and female : " + collect3);

		// 4.Print All the name of the department of organization.
		employeeList.stream().map(f -> f.getDepartment()).distinct().forEach(System.out::println);
		// 5.What is the avg age of male and female employee in organization.
		Map<String, Double> collect4 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("Average age of male and female : " + collect4);
		// 6.Get the details of highest paid employee in organization.
		Optional<Employee> max = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
		System.out.println("MAx salary : " + max);
		// 7.Get name of all the empoyee who has joined after 2015.
		List<String> collect5 = employeeList.stream().filter(f -> f.getYearOfJoining() > 2015).map(Employee::getName)
				.collect(Collectors.toList());
		System.out.println("Employee join after 2015 : " + collect5);
		// 8.Count the no.of employee in each department.

		Map<String, List<Employee>> collect6 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("No of Employee in each Department : " + collect6);
		Map<String, Long> collect7 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("No of Employee : " + collect7);

		// 9.what is the average salary of each department.
		Map<String, Double> collect8 = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average Salary of Each Department : " + collect8);

		// 10.Get the details of youngest male employee in the product department.
		Optional<Employee> min = employeeList.stream()
				.filter(f -> f.getDepartment().equals("Product Development") && f.getGender().equals("Male"))
				.min(Comparator.comparingInt(Employee::getAge));

		// 11.who has the most working experiences in the origination

		Optional<Employee> max2 = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining))
				.findFirst();
		System.out.println("OLd Employee In orgination :  " + max2);

		// 12.How many male and female employee are there in sales and marketing teams.
		Map<String, Long> collect9 = employeeList.stream().filter(f -> f.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("No of M/F in Sales and marketings : " + collect9);

		// 13.what is the average salary of male and female employee.
		Map<String, Double> collect10 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average Salary of M/F in Orgination : " + collect10);

		// 14.List down the name of all employee of each department.
		Map<String, List<Employee>> collect11 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("All Employee in each department :   " + collect11);
		Map<String, List<String>> collect12 = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Nam of Employee in each Departemt : " + collect12);

		// 15.what is average salary and total salary of whole organization.
		DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Averge Salary in Whole orgination : " + doubleSummaryStatistics.getAverage());
		System.out.println("Total in Whole orgination : " + doubleSummaryStatistics.getSum());

		// 16.Separate the employee who are younger or equal to 25 from those employee
		// who are older than 25.
		Map<Boolean, List<String>> map = employeeList.stream().collect(Collectors.partitioningBy(f -> f.getAge() > 25,
				Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Age greater : " + map);
		Map<Boolean, List<Employee>> ageGreaterthan = employeeList.stream()
				.collect(Collectors.partitioningBy(f -> f.getAge() > 25));
		System.out.println("Age greater : " + ageGreaterthan);

		// 17.who is the oldest employee in the origination? what is is age and which
		// department he belongs to.
		Optional<Employee> max3 = employeeList.stream().max(Comparator.comparingDouble(Employee::getAge));
		System.out.println("Oldest Employee in orgination :   " + max3);

		// 18. Group all employee who has same age
		Map<Integer, List<Employee>> employeeWithSameAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getAge, Collectors.toList()));
		System.out.println("employeeWithSameAge " + employeeWithSameAge);

		// 19. Group all employee name who has same age
		Map<Integer, List<String>> map4 = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("All employee with same age " + map4);

		// 20. List down the name of all employee of each department.
		Map<String, List<String>> employeeInEachDepartment = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Employee name in each department  : " + employeeInEachDepartment);

		// 21. Print the highest paid employee in each department

		Map<String, Optional<Employee>> higestPaid = employeeList.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		System.out.println("Higest paid " + higestPaid);
		// 22. Counting the frequency of employee age
		Map<Integer, Long> frequency = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
		System.out.println("Age frequency : " + frequency);

		// Find the most log throwing IP
		List<String> asList = Arrays.asList("192.168.1.2#qqqqqqqqqq", "192.168.1.2#qqqqqqqqqq",
				"192.168.1.2#qqqqqqqqqq", "192.168.1.3#qqqqqqqqqq", "192.168.1.5#qqqqqqqqqq", "192.168.1.6#qqqqqqqqqq",
				"192.168.1.2#qqqqqqqqqq", "192.168.1.2#qqqqqqqqqq", "192.168.1.6#qqqqqqqqqq", "192.168.1.6#qqqqqqqqqq",
				"192.168.1.5#qqqqqqqqqq", "192.168.1.2#qqqqqqqqqq", "192.168.1.8#qqqqqqqqqq", "192.168.1.9#qqqqqqqqqq",
				"192.168.1.8#qqqqqqqqqq", "192.168.1.4#qqqqqqqqqq", "192.168.1.2#qqqqqqqqqq");

		Map<String, Long> log = asList.stream().map(f -> f.split("#")[0])
				.collect(Collectors.groupingBy(f -> f, Collectors.counting()));
		System.out.println("collect2 : " + log);
		Optional<Entry<String, Long>> findFirst = log.entrySet().stream()
				.sorted(Collections.reverseOrder(Entry.comparingByValue())).findFirst();
		System.out.println("Higest Log : " + findFirst.get());

		// Java Intersection
		List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
		List<String> otherList = Arrays.asList("red", "green", "green", "yellow");
		List<String> uniqueFromTwoList = list.stream().distinct().filter(otherList::contains)
				.collect(Collectors.toList());
		System.out.println("Unique of two list " + uniqueFromTwoList);

		// Find vowels from a given String using stream API.
		String str = "Java is good for App developement";
		String replace = str.replace(" ", "");
		List<String> vovels = Arrays.asList("a", "e", "i", "o", "u");
		List<String> vovelInString = Arrays.stream(replace.split("")).distinct().filter(vovels::contains)
				.collect(Collectors.toList());
		System.out.println("Vovel in Given String : " + vovelInString);

		// Find the distinct number from arrays that is greater than 20 using stream API
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(12, 24, 45, 67, 88, 99, 48));
		arrayList.stream().distinct().filter(f -> f > 20).collect(Collectors.toList());

		// Count the occurrence of given character in string using streamAPI
		String givenString = "Better Butter";
		String stringwithoutspace = String.valueOf(givenString.replace(" ", ""));
		Map<String, Long> frequencyCount = Arrays.stream(stringwithoutspace.split(""))
				.collect(Collectors.groupingBy(f -> f, Collectors.counting()));
		System.out.println("Frequency count : " + frequencyCount);

		// Find the nth Largest number in an Arrays or List or stream API
		ArrayList<Integer> intArr = new ArrayList<Integer>(Arrays.asList(12, 24, 45, 67, 88, 99, 48));
		Integer integer = intArr.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(1);
		System.out.println("Nth LArgest Number in arrays : " + integer);

		// Find the word which start with a "T" from a given string using stream API
		String sentance = "Hi guys welcome to the Teams";
		List<String> wordStartWithT = Arrays.stream(sentance.split(" ")).filter(f -> f.startsWith("T"))
				.collect(Collectors.toList());
		System.out.println("wordStartWithT : " + wordStartWithT);

		// Count the no of employee in each department
		List<Emp> emp = new ArrayList<>();
		emp.add(new Emp("Jay", 24, 25000, "IT", new Date(2009, 01, 22)));
		emp.add(new Emp("Rehman", 45, 55000, "Testing", new Date(2021, 01, 02)));
		emp.add(new Emp("Rajan", 34, 120000, "Prodcution", new Date(2012, 11, 12)));
		emp.add(new Emp("Sagar", 46, 320000, "Testing", new Date(2016, 03, 02)));
		emp.add(new Emp("Abhijit", 26, 50000, "IT", new Date(2010, 06, 23)));

		Map<String, Long> noOfEmpInDepartment = emp.stream()
				.collect(Collectors.groupingBy(Emp::getDepartment, Collectors.counting()));
		System.out.println(" noOfEmpInDepartment : " + noOfEmpInDepartment);

		// Sort employees by salary in descending order using comparator
		List<Emp> sortingRev = emp.stream().sorted(Comparator.comparingDouble(Emp::getSalary).reversed())
				.collect(Collectors.toList());
		System.out.println("Sorting the employee base on salary inn revrese order " + sortingRev);

		// Sort employees by their age and Department using a comparator in Stream API
		List<Emp> AgeAndDepartmet = emp.stream()
				.sorted(Comparator.comparingInt(Emp::getAge).thenComparing(Emp::getDepartment))
				.collect(Collectors.toList());
		System.out.println("AgeAndDepartmet :  " + AgeAndDepartmet);

		// Find the top 3 most salaried employees using Stream API
		List<Emp> Top3Salary = emp.stream().sorted(Comparator.comparingLong(Emp::getSalary).reversed()).limit(3)
				.collect(Collectors.toList());

		System.out.println("Top Salary : " + Top3Salary);

		List<Integer> listValue = Arrays.asList(1, 17, 78, 29, 5, 2, 36, 24, 29, 89, 98);

		// Given a list of numbers, return the sum of all numbers

		Optional<Integer> reduce = listValue.stream().reduce((a, b) -> a + b);
		System.out.println("Reduce Example : " + reduce.get());

		// Given a list of numbers, return the average of all numbers
		OptionalDouble average = listValue.stream().mapToInt(f -> f).average();
		System.out.println(" Average of List value  : " + average);

		// Given a list of numbers, square them and filter the number which are greater
		// 100 and then find the average of them.

		List<Integer> SquareAndFilter = listValue.stream().map(f -> f * f).filter(f -> f > 100)
				.collect(Collectors.toList());

		System.out.println(" SquareAndFilter : " + SquareAndFilter);

		// Given a list of numbers, find out all the numbers starting with 2

		List<String> NoStartWith2 = listValue.stream().map(f -> f + "").filter(f -> f.startsWith("2"))
				.collect(Collectors.toList());
		System.out.println("NoStartWith2 : " + NoStartWith2);

		// Given a list of number find the duplicate
		List<Integer> finding = listValue.stream().collect(Collectors.groupingBy(f -> f, Collectors.counting()))
				.entrySet().stream().filter(f -> f.getValue() > 1).map(Entry::getKey).collect(Collectors.toList());

		System.out.println("finding : " + finding);

		// Given a list of numbers, print the maximum and minimum values

		Integer maxValue = listValue.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Max Integer Value : " + maxValue);
		Integer MinValue = listValue.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Value : " + MinValue);

		// Given list of number, sort them in ASC and DESC order and print
		listValue.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);

		// Given list of numbers, return the first 5 element and sum.
		// Approach we can use limit()followed by reduce()
		Optional<Integer> reduceAndLimit = listValue.stream().limit(5).reduce((a, b) -> a + b);
		System.out.println("reduceAndLimit : " + reduceAndLimit.get());
		
		// Given a list of numbers. skip the first 5 numbers and return the sum of remaining numbers
		Optional<Integer> skipAndLimit = listValue.stream().skip(5).reduce((a,b)->a+b);
		System.out.println("skipAndLimit : " + skipAndLimit.get());
		
		// WAP to get sum of all number in list
		int sum = listValue.stream().mapToInt(f->f).sum();
		System.out.println("Sum of all number in list");
		
		// WAP to square the number of list and filter out the number greater than 10
		List<Integer> list2 = listValue.stream().map(f->f*f).filter(f->f>10).collect(Collectors.toList());
		System.out.println("List view : "+ list2);
		
		// Find the list of string greater than 6 character
		List<String> list1 = Arrays.asList("aabc", "aab", "aabwc", "aabc", "aabwcwer", "aabcsd");
		List<String> listOfString = list1.stream().filter(f->f.length()>=6).collect(Collectors.toList());
		System.out.println("List of String : "+ listOfString);
		
		// How to collect 2 stream
		
		List<Integer> intList1 = Arrays.asList(1, 4, 6, 7);
		List<Integer> intList2 = Arrays.asList(11, 24, 86, 97);
		Stream<Integer> concat = Stream.concat(intList1.stream(), intList2.stream());
		System.out.println("Concat Stream : ");
		concat.forEach(System.out::print);
		
		// How to remove duplicate element
		List<Integer> asListOfInteger = Arrays.asList(1, 2, 7, 20, 5, 2, 7, 24, 22, 14, 21);
		List<Integer> listwithoutDuplicate = asListOfInteger.stream().distinct().collect(Collectors.toList());
		System.out.println("listwithoutDuplicate " + listwithoutDuplicate);
		
		
		// Find all the even number exist in List
		asListOfInteger.stream().filter(f->f%2==0).collect(Collectors.toList());
		
		// Find the duplicate element from the list using java 8
		List<Integer> findDuplicate = Arrays.asList(1, 2, 7, 20, 5, 2, 7, 24, 22, 14, 21);
		HashSet<Integer> hashSet = new HashSet<>();
		List<Integer> duplicateList = findDuplicate.stream().filter(f-> !hashSet.add(f)).collect(Collectors.toList());
		System.out.println("duplicateList : "+ duplicateList); 
		
	}

}
