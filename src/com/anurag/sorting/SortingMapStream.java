package com.anurag.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SortingMapStream {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("India", "Delhi");
		map.put("Usa", "Washington");
		map.put("China", "Beging");
		map.put("France", "Peris");
		map.put("Japan", "Tokyo");

		// List<Entry<String, String>> collect4 =
		Map<String, String> collect4 = map.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getKey(), (p1, p2) -> p2, LinkedHashMap::new));

		System.out.println("Collect4 : " + collect4);

		// Sorting map in without java8 ways
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		ArrayList<Entry<String, String>> arrayList = new ArrayList<>(entrySet);
		
		Collections.sort(arrayList, new Comparator<Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}

		});
		System.out.println("Sorted : " + arrayList);

		map.entrySet().stream().sorted(Entry.comparingByValue()).forEach(System.out::println);
		Map<String, String> collect3 = map.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByKey()))
				.collect(Collectors.toMap(f -> f.getKey(), f -> f.getValue(), (p1, p2) -> p2, LinkedHashMap::new));
		System.out.println(" collect3 " + collect3);
		System.out.println("--------------------------------------");

		// map.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::print);

		// map.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByKey())).forEach(System.out::println);

		// Collect the sorted entries in map
		Map<String, String> collect = map.entrySet().stream().sorted(Entry.comparingByKey())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

		System.out.println("Sorted by key ..[oder will got lost at the time collecting] --> " + collect);
		// Ordering was lost while collecting result in map,We need to use LinkedHashMap
		// to preserve the order

		LinkedHashMap<String, String> collect2 = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value1,
						LinkedHashMap::new));
		System.out.println("Using LinkedHashMap for preserving order : " + collect2);

		// Reversed sorting and order capturing
		LinkedHashMap<String, String> reverseCollect = map.entrySet().stream()
				.sorted(Map.Entry.<String, String>comparingByKey().reversed()).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value1, LinkedHashMap::new));
		System.out.println("Reverse ...Using LinkedHashMap for preserving order" + reverseCollect);
	
	
	}
}
