package com.anurag.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {
	public static void main(String[] args) {
		
		List<EmpClass> empList = new ArrayList<>();
		empList.add(new EmpClass(234364, "Saurabh", new Dept("Mechanical", "DC")));
		empList.add(new EmpClass(242741, "Manikandan", new Dept("IT", "DA")));
		empList.add(new EmpClass(245564, "Amir", new Dept("CompSc", "DB")));
		empList.add(new EmpClass(253455, "Gaurav", new Dept("IT", "DA")));
		empList.add(new EmpClass(224343, "Debasis", new Dept("CompSc", "DA")));
		empList.add(new EmpClass(215267, "Sambit", new Dept("Mechanical", "DB")));
		
		
  Map<String,List<String>> collect = empList.stream()
		.collect(Collectors.groupingBy(f->f.getDept().getDeptName(), Collectors.mapping(EmpClass::getName, Collectors.toList())));
	
	System.out.println("collect : "+ collect);
	}
}
