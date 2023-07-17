package com.anurag.sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortingMapStream {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("India", "Delhi");
		map.put("Usa", "Washington");
		map.put("China", "Beging");
		map.put("France", "Peris");
		map.put("Japan", "Tokyo");

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
