package com.anurag.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.anurag.model.Student;

public class FlatMapStudentExample {
public static void main(String[] args) {
	List<String> asList1 = Arrays.asList("aaa","aaa1","aaa2","aaa3","aaa7");
	List<String> asList2 = Arrays.asList("bbb","bbb","bbb","bbb","bbb");
	List<String> asList3 = Arrays.asList("ccc","ccc1","ccc2","cccc6","ccc");
	List<String> asList4 = Arrays.asList("ddd4","ddR","ddd","ddd","ddd");
	List<String> asList5 = Arrays.asList("eee5","e","eee","eee","eee");
	List<String> asList6 = Arrays.asList("ff","fff","fff","ffd","ffR");
	List<String> asList7 = Arrays.asList("ggg7","ggg","ggR","ggsd","ggR");
	List<String> asList8 = Arrays.asList("hhC8","hhh","hhR","hdR","hhh");
	List<String> asList9 = Arrays.asList("iii9","iiR","iiR","iii","iAR");
	List<String> asList10 = Arrays.asList("jjjj","jjjR","jjjR","jjjR","jjj");
	
	
	List<Student> listOfStudent = Arrays.asList(new Student("Anurag", 7, asList1),
												new Student("Upadhyay", 2, asList2),
												new Student("Anu", 3, asList3),
												new Student("Rag", 10, asList4),
												new Student("Anurag007", 2, asList5),
												new Student("A", 1, asList6),
												new Student("AU", 6, asList7),
												new Student("Bunty", 5, asList8),
												new Student("Ang", 8, asList9),
												new Student("Bunty2", 9, asList10));
												
	List<String> listOfSubject=listOfStudent.stream().filter(f->f.getRank()<5).flatMap(a->a.getSubject().stream()).collect(Collectors.toList());
System.out.println("subject : " +listOfSubject);
}
}
