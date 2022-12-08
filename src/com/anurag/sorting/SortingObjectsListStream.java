package com.anurag.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.anurag.model.Person;

public class SortingObjectsListStream {
	public static void main(String[] args) {
		List<Person> employee = new ArrayList<>();

		employee.add(new Person("Perer", 23));
		employee.add(new Person("Mark", 25));
		employee.add(new Person("Meli", 45));
		employee.add(new Person("Anna", 32));

		// employee.stream().sorted().forEach(System.out::println);
		employee.stream().sorted((p1, p2) -> {
			return p1.getName().compareTo(p2.getName());
		}).forEach(System.out::println);

		//
		Comparator<Person> sortByName = (p1, p2) -> {
			return p1.getName().compareTo(p2.getName());
		};

		employee.stream().sorted(sortByName).collect(Collectors.toList());
		// using comparator reversed
		employee.stream().sorted(sortByName.reversed()).collect(Collectors.toList());
		// printing all value
		employee.stream().sorted(sortByName.reversed()).forEach(System.out::println);
		;

		employee.stream().sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);

		Stream<Person> sorted = employee.stream().sorted(Comparator.comparing((Person p) -> p.getName()));
		sorted.forEach(System.out::println);

		employee.stream()
				.sorted(Comparator.comparing((Person p) -> p.getName()).thenComparing((Person p) -> p.getAge()))
				.forEach(System.out::print);;

	}
}
