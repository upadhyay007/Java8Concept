package com.anurag.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Java8_Log_Example_Using_Stream {
	public static void main(String[] args) {
		//finding ip from where most log coming.. 
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
 
 Map<String, Long> collect = asList.stream().map(f->f.split("#")[0]).collect(Collectors.groupingBy(f->f, Collectors.counting()));
 System.out.println("Log comming from server : " + collect);
 
 String key = collect.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue()))
		 .collect(Collectors.toList()).get(0).getKey();

 System.out.println("Most log producing server : "+ key);
 
	}
}
