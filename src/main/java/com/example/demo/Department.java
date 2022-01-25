package com.example.demo;

public class Department {
	int departmentid;
	String departmentname;
	int employeeid;
	String departmenthead;
	public Department() {
		super();
	}
	public Department(int departmentid, String departmentname, int employeeid, String departmenthead) {
		super();
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.employeeid = employeeid;
		this.departmenthead = departmenthead;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getDepartmenthead() {
		return departmenthead;
	}
	public void setDepartmenthead(String departmenthead) {
		this.departmenthead = departmenthead;
	}
	
	
	
	
	
	
}
