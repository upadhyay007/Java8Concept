package com.anurag.model;

import java.util.List;

public class Student {
private String name;
private int rank;
private List<String> subject;

public Student(String name, int rank, List<String> subject) {
	super();
	this.name = name;
	this.rank = rank;
	this.subject = subject;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getRank() {
	return rank;
}
public void setRank(int rank) {
	this.rank = rank;
}
public List<String> getSubject() {
	return subject;
}
public void setSubject(List<String> subject) {
	this.subject = subject;
}



}
