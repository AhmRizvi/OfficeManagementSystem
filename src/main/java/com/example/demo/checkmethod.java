package com.example.demo;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class checkmethod {

	public static void main(String[] args) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
//	System.out.println(eda.allemployeeData());
//	CompanydataAccess ca= new CompanydataAccess();
//	System.out.println(ca.alldepartmentname());
//	System.out.println(eda.allemployeeid());
//	System.out.println(eda.todayattAttendance());
//	System.out.println(eda.allprensentemployeeid());

		System.out.println(eda.leaveapply(234));

//	System.out.println(eda.latecount(234));
//	System.out.println(eda.absentcount(225,"September","2021"));
//	CompanydataAccess ca=  new CompanydataAccess();
//	System.out.println(ca.branchname(55));
	

	}

}
