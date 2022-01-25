package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalesDataAccess {
	
	Connection cn;
	PreparedStatement pst;

	public int salesmanlogin(Employee employee) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("SELECT empid,password FROM employee WHERE empid=? AND password=? and designationname=?");
			System.out.println("Sala");
			pst.setInt(1, employee.empid);
			pst.setString(2, employee.password);
			pst.setString(3, "Salesman");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("sddkfjhkfdf");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
