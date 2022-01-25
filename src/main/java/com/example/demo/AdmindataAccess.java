package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdmindataAccess {
	
	Connection cn;
	PreparedStatement pst;

	public int login(Admin admin) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("SELECT id,password FROM admin WHERE id=? AND password=?");
			pst.setInt(1, admin.id);
			pst.setString(2, admin.password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
