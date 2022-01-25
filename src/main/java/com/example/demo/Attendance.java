package com.example.demo;

import java.sql.Date;

public class Attendance {
	int serialno;
	int empid;
	Date attendancedate;	
	String logintime;
	String logouttime;
	String status;
	
	
	public Attendance() {
		super();
	}

	

	public Attendance(int serialno, int empid, Date attendancedate, String logintime, String logouttime,
			String status) {
		super();
		this.serialno = serialno;
		this.empid = empid;
		this.attendancedate = attendancedate;
		this.logintime = logintime;
		this.logouttime = logouttime;
		this.status = status;
	}


	
	public Attendance(int empid, Date attendancedate, String logintime, String logouttime, String status) {
		super();
		this.empid = empid;
		this.attendancedate = attendancedate;
		this.logintime = logintime;
		this.logouttime = logouttime;
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


	public Date getAttendancedate() {
		return attendancedate;
	}


	public void setAttendancedate(Date attendancedate) {
		this.attendancedate = attendancedate;
	}


	public String getLogintime() {
		return logintime;
	}


	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}


	public String getLogouttime() {
		return logouttime;
	}


	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	




	public Attendance(int empid) {
		super();
		this.empid = empid;
	}



	@Override
	public String toString() {
		return "Attendance [serialno=" + serialno + ", empid=" + empid + ", attendancedate=" + attendancedate
				+ ", logintime=" + logintime + ", logouttime=" + logouttime + ", status=" + status + "]";
	}




	
	
	
	
}
