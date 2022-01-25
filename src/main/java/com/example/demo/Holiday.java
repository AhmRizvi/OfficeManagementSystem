package com.example.demo;

import java.sql.Date;

public class Holiday {
	int serialno;
	Date holidaydate;
	String description;
	public Holiday(int serialno, Date holidaydate, String description) {
		super();
		this.serialno = serialno;
		this.holidaydate = holidaydate;
		this.description = description;
	}
	public Holiday() {
		super();
	}
	public Holiday(Date holidaydate, String description) {
		super();
		this.holidaydate = holidaydate;
		this.description = description;
	}
	public int getSerialno() {
		return serialno;
	}
	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}
	public Date getHolidaydate() {
		return holidaydate;
	}
	public void setHolidaydate(Date holidaydate) {
		this.holidaydate = holidaydate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Holiday [serialno=" + serialno + ", holidaydate=" + holidaydate + ", description=" + description + "]";
	}
	
	
	
	

}
