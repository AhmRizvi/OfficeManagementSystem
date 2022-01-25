package com.example.demo;

import java.sql.Date;

public class Employee {
	int empid;
	String name;
	String departmentname;
	String designationname;
	String branchname;
	Date joiningdate;
	Date permanentdate;
	Date discontinuationdate;
	Date dob;
	String address;  
	String phone;  
	String email;    
	Double salary;  
	String status;  
	String password;
	
	
	public Employee() {
		super();
	}


	public Employee(String name, String departmentname, String designationname, String branchname, Date joiningdate,
			Date permanentdate, Date discontinuationdate, Date dob, String address, String phone, String email,
			Double salary, String status, String password) {
		super();
		this.name = name;
		this.departmentname = departmentname;
		this.designationname = designationname;
		this.branchname = branchname;
		this.joiningdate = joiningdate;
		this.permanentdate = permanentdate;
		this.discontinuationdate = discontinuationdate;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.salary = salary;
		this.status = status;
		this.password = password;
	}


	public Employee(int empid, String name, String departmentname, String designationname, String branchname,
			Date joiningdate, Date permanentdate, Date discontinuationdate, Date dob, String address, String phone,
			String email, Double salary, String status, String password) {
		super();
		this.empid = empid;
		this.name = name;
		this.departmentname = departmentname;
		this.designationname = designationname;
		this.branchname = branchname;
		this.joiningdate = joiningdate;
		this.permanentdate = permanentdate;
		this.discontinuationdate = discontinuationdate;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.salary = salary;
		this.status = status;
		this.password = password;
	}


	public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartmentname() {
		return departmentname;
	}


	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}


	public String getDesignationname() {
		return designationname;
	}


	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}


	public String getBranchname() {
		return branchname;
	}


	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}


	public Date getJoiningdate() {
		return joiningdate;
	}


	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}


	public Date getPermanentdate() {
		return permanentdate;
	}


	public void setPermanentdate(Date permanentdate) {
		this.permanentdate = permanentdate;
	}


	public Date getDiscontinuationdate() {
		return discontinuationdate;
	}


	public void setDiscontinuationdate(Date discontinuationdate) {
		this.discontinuationdate = discontinuationdate;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", departmentname=" + departmentname
				+ ", designationname=" + designationname + ", branchname=" + branchname + ", joiningdate=" + joiningdate
				+ ", permanentdate=" + permanentdate + ", discontinuationdate=" + discontinuationdate + ", dob=" + dob
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", salary=" + salary + ", status="
				+ status + ", password=" + password + "]";
	}
	
	



}
