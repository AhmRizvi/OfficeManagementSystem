package com.example.demo;

import java.sql.Date;

public class Salary {
	int serialno;
	int empid;
	String name;
	Date startingdate;
	Date endingdate;
	Double salary;
	Date paymentdate;
	int late;
	int absent;
	double totalsalary;
	
	public Salary() {
		super();
	}


	public Salary(int serialno, int empid, String name, Date startingdate, Date endingdate, Double salary,
			Date paymentdate, int late, int absent, double totalsalary) {
		super();
		this.serialno = serialno;
		this.empid = empid;
		this.name = name;
		this.startingdate = startingdate;
		this.endingdate = endingdate;
		this.salary = salary;
		this.paymentdate = paymentdate;
		this.late = late;
		this.absent = absent;
		this.totalsalary = totalsalary;
	}


	
	public Salary(int empid, String name, Date startingdate, Date endingdate, Double salary, Date paymentdate, int late,
			int absent, double totalsalary) {
		super();
		this.empid = empid;
		this.name = name;
		this.startingdate = startingdate;
		this.endingdate = endingdate;
		this.salary = salary;
		this.paymentdate = paymentdate;
		this.late = late;
		this.absent = absent;
		this.totalsalary = totalsalary;
	}


	public int getSerialno() {
		return serialno;
	}
	public void setSerialno(int serialno) {
		this.serialno = serialno;
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
	
	public Date getStartingdate() {
		return startingdate;
	}


	public void setStartingdate(Date startingdate) {
		this.startingdate = startingdate;
	}


	public Date getEndingdate() {
		return endingdate;
	}


	public void setEndingdate(Date endingdate) {
		this.endingdate = endingdate;
	}


	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getAbsent() {
		return absent;
	}
	public void setAbsent(int absent) {
		this.absent = absent;
	}
	public double getTotalsalary() {
		return totalsalary;
	}
	public void setTotalsalary(double totalsalary) {
		this.totalsalary = totalsalary;
	}


	@Override
	public String toString() {
		return "Salary [serialno=" + serialno + ", empid=" + empid + ", name=" + name + ", startingdate=" + startingdate
				+ ", endingdate=" + endingdate + ", salary=" + salary + ", paymentdate=" + paymentdate + ", late="
				+ late + ", absent=" + absent + ", totalsalary=" + totalsalary + "]";
	}
	
	
	

}
