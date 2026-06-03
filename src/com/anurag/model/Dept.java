package com.anurag.model;

public class Dept {
	private long id;
	private String deptName;
	private String deptGrp;
	
	
	public Dept(String deptName, String deptGrp) {
		super();
		this.deptName = deptName;
		this.deptGrp = deptGrp;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptGrp() {
		return deptGrp;
	}
	public void setDeptGrp(String deptGrp) {
		this.deptGrp = deptGrp;
	}

}
