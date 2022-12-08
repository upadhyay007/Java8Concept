package com.anurag.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.anurag.model.Person;

public class SortingInJava8Objects {
	public static void main(String[] args) {

		List<Person> employee = new ArrayList<>();

		employee.add(new Person("Perer", 23));
		employee.add(new Person("Mark", 25));
		employee.add(new Person("Meli", 45));
		employee.add(new Person("Anna", 32));

		System.out.println("Sorting  using list.sort");
 
		// first sort the name using name then age
		employee.sort((e1, e2) -> {
			if (e1.getName().equals(e2.getName())) {
				return e1.getAge() - e2.getAge();
			} else {
				return e1.getName().compareTo(e2.getName());
			}
		});
		
		System.out.println("Sorted Employee : " + employee);

		// Sorting by name using lambda expression
		employee.sort((a, b) -> a.getName().compareTo(b.getName()));
		System.out.println("employee : " + employee);

		// sorting using comparator
		employee.sort(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
 
		System.out.println("Using Comparator: " + employee);
		
		// Sorting object List Lambdas and Collections classes
		
		Collections.sort(employee, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				 
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("Sorted employee ByName: " + employee);
		
		// Sorting object List Lambdas and Collections classes
		Collections.sort(employee, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {				 
				return o1.getAge()-o2.getAge();      // By age
			}
		});	
		System.out.println("Sorted employee ByAge :"+ employee);
		
		
		//Passing lambda directly instead of comparator
		Collections.sort(employee, (o1,o2)-> o2.getAge()-o1.getAge());
		System.out.println("Reverse order byage :"+ employee);
		
		//Passing lambda directly instead of comparator
		Collections.sort(employee, (o1,o2)-> o2.getName().compareTo(o1.getName()));
		System.out.println("Reverse order byname:"+ employee);
		

		
		
		
		
	}

}
