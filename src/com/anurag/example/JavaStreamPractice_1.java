package com.anurag.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.anurag.model.Emp;
import com.anurag.model.Employee;

public class JavaStreamPractice_1 {
	public static void main(String[] args) {
				//finding IP from where most log coming..
				List<String> asList = Arrays.asList("192.168.1.2#qqqqqqqqqq",
						 "192.168.1.2#qqqqqqqqqq",
						 "192.168.1.2#qqqqqqqqqq",
						 "192.168.1.3#qqqqqqqqqq",
						 "192.168.1.5#qqqqqqqqqq",
						 "192.168.1.6#qqqqqqqqqq",
						 "192.168.1.2#qqqqqqqqqq",
						 "192.168.1.2#qqqqqqqqqq",
						 "192.168.1.6#qqqqqqqqqq",
						 "192.168.1.6#qqqqqqqqqq",
						 "192.168.1.5#qqqqqqqqqq",
						 "192.168.1.2#qqqqqqqqqq",
						 "192.168.1.8#qqqqqqqqqq",
						 "192.168.1.9#qqqqqqqqqq",
						 "192.168.1.8#qqqqqqqqqq",
						 "192.168.1.4#qqqqqqqqqq",
						 "192.168.1.2#qqqqqqqqqq");
				Map<String, Long> maxLog = asList.stream().map(m->m.split("#")[0]).collect(Collectors.groupingBy(f->f,Collectors.counting()));
				System.out.println("maxLog -> "+maxLog);
				Optional<Entry<String,Long>> findFirst = asList.stream().map(m->m.split("#")[0]).collect(Collectors.groupingBy(f->f,Collectors.counting())).entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue())).findFirst();
				System.out.println("max Log By :"+findFirst.get());
				
	//          Intersection of two list
				List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
				List<String> otherList = Arrays.asList("red", "green", "green", "yellow");
				
				List<String> col2 = list.stream().filter(otherList::contains).collect(Collectors.toList());
				System.out.println("Concat : " + col2);
				
				List<String> col = list.stream().filter(f->otherList.contains(f)).collect(Collectors.toList());
				System.out.println("Concat_1 : " + col);
				
				System.out.println("===========================================");
				
				ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(12, 24, 45, 67, 88, 99, 48));

				// Find the distinct number from arrays that is greater than 20 using stream API
				arrayList.stream().filter(f->f>20).distinct().collect(Collectors.toList()).forEach(System.out::println);
				
				// Count the occurrence of given character in string using streamAPI
				Map<Integer, Long> collect = arrayList.stream().collect(Collectors.groupingBy(f->f,Collectors.counting()));
				System.out.println("occurrence -> : " + collect);
				String str = "Better Butter";
				String replace = str.replace(" ", "");
				Arrays.stream(replace.split("")).collect(Collectors.groupingBy(f->f, Collectors.counting())).entrySet().forEach(f->{System.out.println(f.getKey()+" : "+ f.getValue());});
				
				// Find the nth Largest number in an Arrays or List or stream API
				Integer nThaLargest = arrayList.stream().sorted(Collections.reverseOrder()).findFirst().get();
				System.out.println("nThaLargest  : "+ nThaLargest);
				Integer integer = arrayList.stream().sorted().collect(Collectors.toList()).get(0);
				System.out.println("nth-lowest :" + integer);
				Integer integer2 = arrayList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(0);
				System.out.println("nth-Largest :" + integer2);
				// Find the word which start with a "T" from a given string using stream API
				String sentance = "Hi guys welcome to the Teams";
				List<String> wordStartWithT = Arrays.stream(sentance.split(" ")).filter(f->f.startsWith("T")).collect(Collectors.toList());
				System.out.println("wordStartWithT : " + wordStartWithT);
				System.out.println("Count the no of employee in each department");
				
				// Count the no of employee in each department
				List<Emp> emp = new ArrayList<>();
				emp.add(new Emp("Jay", 24, 25000, "IT", new Date(2009, 01, 22)));
				emp.add(new Emp("Rehman", 45, 55000, "Testing", new Date(2021, 01, 02)));
				emp.add(new Emp("Rajan", 34, 120000, "Prodcution", new Date(2012, 11, 12)));
				emp.add(new Emp("Sagar", 46, 320000, "Testing", new Date(2016, 03, 02)));
				emp.add(new Emp("Abhijit", 26, 50000, "IT", new Date(2010, 06, 23)));
				
				emp.stream().collect(Collectors.groupingBy(Emp::getDepartment,Collectors.counting())).entrySet().forEach(f->System.out.println(f.getKey() +":-> "+f.getValue()));
				
				//Map<String, Long> collect3 = emp.stream().collect(Collectors.groupingBy(Emp::getDepartment, Collectors.counting()));
				
		     	//System.out.println("Count the no of employee in each department : "+  collect3);
				//Find the employee who joined after 2010 using stream API
				
				List<Emp> collect4 = emp.stream().filter(f->f.getDOJ().getYear()>2010).collect(Collectors.toList());
				System.out.println("Employee Who joined after 2010 : " + collect4);
				
				System.out.println("------------------------------------");
				//Count the employee who have an age greater than 30 years using Stream API
				emp.stream().filter(f->f.getAge()>30).collect(Collectors.toList()).forEach(System.out::println);
				System.out.println("------------------------------------");
				
				
				// Sort employees by salary in descending order using comparator
				
				
				//Sort employees by their age and Department using a comparator in Stream API
				
				
				//Find the top 3 most salaried employees using Stream API
				
				
				
				Employee emp1 = new Employee(1,"Ajay",100);
		        Employee emp2 = new Employee(2,"name",100);
		        Employee emp3 = new Employee(3,"Ajay",100);
		        Employee emp4 = new Employee(4,"name",100);
		        Employee emp5 = new Employee(5,"Ajay",100);
				
		        List<Employee> asListNew = Arrays.asList(emp1,emp2,emp3,emp4,emp5);
		        System.out.println("--> " + asListNew);
		        Map<String, Long> frequency = asListNew.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
		        System.out.println("Frequency Of Name : " + frequency);
		        
		        Map<String, Long> frequency1 = asListNew.stream().peek(f->System.out.println(f)).collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
		        
	}
}
