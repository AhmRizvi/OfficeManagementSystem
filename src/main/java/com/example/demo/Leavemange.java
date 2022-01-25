package com.example.demo;

import java.sql.Date;

public class Leavemange {
	
	int serialno;
	int empid;
	String leavetype;
	Date  fromdate;
	Date todate;
	int leavesdays;
	String description;
	Date applydate;
	String status;
	
	public Leavemange() {
		super();
	}

	public Leavemange(int empid, String leavetype, Date fromdate, Date todate, int leavesdays, String description,
			Date applydate, String status) {
		super();
		this.empid = empid;
		this.leavetype = leavetype;
		this.fromdate = fromdate;
		this.todate = todate;
		this.leavesdays = leavesdays;
		this.description = description;
		this.applydate = applydate;
		this.status = status;
	}

	public Leavemange(int serialno, int empid, String leavetype, Date fromdate, Date todate, int leavesdays,
			String description, Date applydate, String status) {
		super();
		this.serialno = serialno;
		this.empid = empid;
		this.leavetype = leavetype;
		this.fromdate = fromdate;
		this.todate = todate;
		this.leavesdays = leavesdays;
		this.description = description;
		this.applydate = applydate;
		this.status = status;
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

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public int getLeavesdays() {
		return leavesdays;
	}

	public void setLeavesdays(int leavesdays) {
		this.leavesdays = leavesdays;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Leavemange [serialno=" + serialno + ", empid=" + empid + ", leavetype=" + leavetype + ", fromdate="
				+ fromdate + ", todate=" + todate + ", leavesdays=" + leavesdays + ", description=" + description
				+ ", applydate=" + applydate + ", status=" + status + "]";
	}
	
	
	
	
	
}
