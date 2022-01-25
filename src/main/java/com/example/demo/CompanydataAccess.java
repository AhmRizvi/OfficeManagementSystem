package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompanydataAccess {

	Connection cn;
	Connection cn2;
	PreparedStatement pst;
	PreparedStatement pst2;
	PreparedStatement pst3;

	public void insert(Branch branch) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"insert into branchtable (branchcode, branchname,address,city,country,status ) values(?,?,?,?,?,?)");

			pst.setInt(1, branch.branchcode);
			pst.setString(2, branch.branchname);
			pst.setString(3, branch.address);
			pst.setString(4, branch.city);
			pst.setString(5, branch.country);
			pst.setString(6, branch.status);
			pst.executeUpdate();
			System.out.println("Insert");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void branchstatusupdate(Branch branch) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("update branchtable set status=? where branchcode=?");
			pst.setString(1, branch.status);
			pst.setInt(2, branch.branchcode);
			pst.executeUpdate();
			if(pst.executeUpdate() >0 && branch.status.equals("Inactive")) {
				String branchname= branchname(branch.branchcode);
				inactivestatuschange(branchname);
				System.out.println("Employee status update");
			}	
			if(pst.executeUpdate() >0 && branch.status.equals("Active")) {
				String branchname= branchname(branch.branchcode);
				activestatuschange(branchname);
				System.out.println("Employee status update");
			}	

//			System.out.println("branch status update");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void activestatuschange(String branchname) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("update employee set status=? where branchname=?");
			pst.setString(1, "Active");
			pst.setString(2, branchname);
			pst.executeUpdate();
			System.out.println("branch status update");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void inactivestatuschange(String branchname) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("update employee set status=? where branchname=?");
			pst.setString(1, "Inactive");
			pst.setString(2, branchname);
			pst.executeUpdate();
			System.out.println("branch status update");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public String branchname(int branchcode) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("select branchname from branchtable where branchcode=?");
			pst.setInt(1, branchcode);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "";
	}
	
	
	
	public List<Branch> doShow() {
		List<Branch> list = new ArrayList<>();
		Branch branch;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select branchcode,branchname,address,city,country,status from branchtable");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				branch = new Branch(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));

				list.add(branch);
//				System.out.println(branch);
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	
	public List<String> allbranchname() {
		List<String> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select branchname from branchtable");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
//				System.out.println(rs.getString(1));

				list.add(rs.getString(1));
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	// designation
	public void designationinsert(Designation designation) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"insert into designation (designationid,designationname) values(?,?)");
			
			pst.setInt(1, designation.designationid);
			pst.setString(2, designation.designationname);
			pst.executeUpdate();
			System.out.println(" Dcreatedesignation Insert");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<Designation> alldesignation() {
		List<Designation> list = new ArrayList<>();
		Designation designation;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select * from designation");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				designation = new Designation(rs.getInt(1), rs.getString(2));
				list.add(designation);
//				
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	
	public List<String> alldesignationname() {
		List<String> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select designationname from designation");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				list.add(rs.getString(1));
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	
	
	
	
	///Department start
	public void designationinsert(Department department) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"insert into Department values(?,?,?,?)");
			
			pst.setInt(1, department.departmentid);
			pst.setString(2, department.departmentname);
			pst.setInt(3, department.employeeid);
			pst.setString(4, department.departmenthead);
			pst.executeUpdate();
			System.out.println(" designation Insert");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void departmenthead(Department department) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("update department set employeeid=?,departmenthead=? where departmentid=?");
			pst.setInt(1, department.employeeid);
			pst.setString(2, department.departmenthead);
			pst.setInt(3, department.departmentid);			
			pst.executeUpdate();
			System.out.println(" Status Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public List<Department> alldepartment() {
		List<Department> list = new ArrayList<>();
		Department department;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select * from Department");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				department = new Department(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4));
				list.add(department);
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	

	public List<String> alldepartmentname() {
		List<String> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select departmentname from department");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
//				System.out.println(rs.getString(1));

				list.add(rs.getString(1));
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	
	
	

}
