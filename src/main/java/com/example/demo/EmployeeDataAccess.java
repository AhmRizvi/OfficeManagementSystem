package com.example.demo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataAccess {

	Connection cn;
	PreparedStatement pst;
	PreparedStatement pst2;

	public int employeelogin(Employee employee) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("SELECT empid,password FROM employee WHERE empid=? AND password=?");
			pst.setInt(1, employee.empid);
			pst.setString(2, employee.password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void insertemployee(Employee emp) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"insert into employee (name,departmentname,designationname,branchname,joiningdate,dob,address,phone,email,salary,status,password)  values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, emp.name);
			pst.setString(2, emp.departmentname);
			pst.setString(3, emp.designationname);
			pst.setString(4, emp.branchname);
			pst.setDate(5, emp.joiningdate);
			pst.setDate(6, emp.dob);
			pst.setString(7, emp.address);
			pst.setString(8, emp.phone);
			pst.setString(9, emp.email);
			pst.setDouble(10, emp.salary);
			pst.setString(11, emp.status);
			pst.setString(12, emp.password);
			pst.executeUpdate();
			System.out.println("Insert");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<Employee> allemployeeData() {
		List<Employee> list = new ArrayList<>();
		Employee employee;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select * from employee where status=?");
			pst.setString(1, "Active");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getDate(8), rs.getDate(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getDouble(13), rs.getString(14), rs.getString(15));

				list.add(employee);
//				System.out.println(branch);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public void updateEmpinfoupdate(Employee employee) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"update employee set name=?,address=?,phone=?,email=?,salary=?,password=? where empid=?");
			pst.setString(1, employee.name);
			pst.setString(2, employee.address);
			pst.setString(3, employee.phone);
			pst.setString(4, employee.email);
			pst.setDouble(5, employee.salary);
			pst.setString(6, employee.password);
			pst.setInt(7, employee.empid);
			pst.executeUpdate();
			System.out.println(" Status Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Sala");
		}
	}

	public void shiftingemployeeinanother(Employee employee) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"update employee set branchname=?,departmentname=?, designationname=? where empid=?");
			pst.setString(1, employee.branchname);
			pst.setString(2, employee.departmentname);
			pst.setString(3, employee.designationname);
			pst.setInt(4, employee.empid);
			pst.executeUpdate();
			System.out.println(" Sift employee Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void statusupdteforemp(Employee employee) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("update employee set status=? where empid=?");
			pst.setString(1, employee.status);
			pst.setInt(2, employee.empid);
			pst.executeUpdate();
			System.out.println(" Status Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Sala");
		}
	}

	public List<Employee> searchbyemployeeid(int empid) {
		List<Employee> list = new ArrayList<>();
		Employee employee;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select * from employee where empid=?");
			pst.setInt(1, empid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getDate(8), rs.getDate(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getDouble(13), rs.getString(14), rs.getString(15));

				list.add(employee);
//				System.out.println(branch);
			}

		} catch (Exception e) {

		}
		return list;
	}

	/// all employee id get

	public List<String> allemployeeid() {
		List<String> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select empid from employee where status=?");
			pst.setString(1, "Active");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}

		} catch (Exception e) {

		}
		return list;
	}
	/// all employee id get

	//// insert into salary sheet database
	public void salarysheet(Salary salary) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"insert into salary (empid,name, startingdate, endingdate,salary,paymentdate,late,absent,totalsalary)  values(?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, salary.empid);
			pst.setString(2, salary.name);
			pst.setDate(3, salary.startingdate);
			pst.setDate(4, salary.endingdate);
			pst.setDouble(5, salary.salary);
			pst.setDate(6, salary.paymentdate);
			pst.setInt(7, salary.late);
			pst.setInt(8, salary.absent);
			pst.setDouble(9, salary.totalsalary);
			pst.executeUpdate();
			System.out.println("Insert");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	public Date nextSalarystartdate(Date today) {

		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));

		return tomorrow;
	}

	public void createsalarysheet(Salary salary, Date startingdate, Date endingdate) {
		Salary sal;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select * from employee where status=?");
			pst.setString(1, "Active");

			ResultSet rs = pst.executeQuery();

			if (lastdateget() == null) {
				while (rs.next()) {
					int latecount = 1;
					int absentcount = 0;

					Date stdate = salary.getStartingdate();
					Date endate = salary.getEndingdate();
					long totalDays = ((endate.getTime() - stdate.getTime()) / (1000 * 60 * 60 * 24)) + 1;

					EmployeeDataAccess eda = new EmployeeDataAccess();
					latecount = eda.latecount(rs.getInt(1), startingdate, endingdate);
					absentcount = eda.absentcount(rs.getInt(1), startingdate, endingdate);
					double deduction = Math.round((rs.getDouble(13) / totalDays) * (absentcount + (latecount / 3)));

					sal = new Salary(rs.getInt(1), rs.getString(2), startingdate, endingdate, rs.getDouble(13),
							salary.getPaymentdate(), latecount, absentcount, (rs.getDouble(13) - deduction));

//					System.out.println((rs.getDouble(13) - ((rs.getDouble(13) / totalDays) * (latecount / 3))));

					// insert salary start
					salarysheet(sal);
					// insert salary end
				}

			}
			if (lastdateget().before(startingdate) && lastdateget().before(endingdate)) {
				while (rs.next()) {
					int latecount = 1;
					int absentcount = 0;

					Date stdate = salary.getStartingdate();
					Date endate = salary.getEndingdate();
					long totalDays = ((endate.getTime() - stdate.getTime()) / (1000 * 60 * 60 * 24)) + 1;

					EmployeeDataAccess eda = new EmployeeDataAccess();
					latecount = eda.latecount(rs.getInt(1), startingdate, endingdate);
					absentcount = eda.absentcount(rs.getInt(1), startingdate, endingdate);
					double deduction = Math.round((rs.getDouble(13) / totalDays) * (absentcount + (latecount / 3)));

					sal = new Salary(rs.getInt(1), rs.getString(2), startingdate, endingdate, rs.getDouble(13),
							salary.getPaymentdate(), latecount, absentcount, (rs.getDouble(13) - deduction));

					System.out.println((rs.getDouble(13) - ((rs.getDouble(13) / totalDays) * (latecount / 3))));

					// insert salary start
					salarysheet(sal);
					// insert salary end
				}
			}

		} catch (Exception e) {
		}
	}

	///// salary sheet already create check

	public Date lastdateget() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("SELECT endingdate FROM salary ORDER BY endingdate DESC LIMIT 1");
			// SELECT fields FROM table ORDER BY id DESC LIMIT 1;

			ResultSet rs = pst.executeQuery();
			System.out.println("salary");
			while (rs.next()) {
				return rs.getDate(1);
			}

		} catch (Exception e) {

		}
		return null;
	}

	public int latecount(int empid, Date staringDate, Date endingdate) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement(
					"SELECT * from attendance WHERE empid=? && status=? && attendancedate BETWEEN ? AND ?");

			pst.setInt(1, empid);
			pst.setString(2, "Late");
			pst.setDate(3, staringDate);
			pst.setDate(4, endingdate);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				count++;

			}

			return count;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return 0;
	}

	public int absentcount(int empid, Date startingdate, Date endingdate) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement(
					"SELECT * from attendance WHERE empid=? &&  status=? &&  attendancedate BETWEEN ? AND ?");
			pst.setInt(1, empid);
			pst.setString(2, "Absent");
			pst.setDate(3, startingdate);
			pst.setDate(4, endingdate);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				count++;
			}
			return count;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return 0;
	}

///// salary sheet already create check

	public List<Salary> searchbymonthyear(Date startingdate, Date endingdate) {
		List<Salary> list = new ArrayList<>();
		Salary salary;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("SELECT * FROM salary where endingdate=? and endingdate=?");
			pst.setDate(1, startingdate);
			pst.setDate(2, endingdate);
			ResultSet rs = pst.executeQuery();
			System.out.println("salary");
			while (rs.next()) {
				salary = new Salary(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDouble(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getDouble(10));

				list.add(salary);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<Salary> allsalarysheet() {
		List<Salary> list = new ArrayList<>();
		Salary salary;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("SELECT * FROM salary");
			ResultSet rs = pst.executeQuery();
			System.out.println("salary");
			while (rs.next()) {
				salary = new Salary(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDouble(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getDouble(10));
				list.add(salary);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<Salary> currentonthsalary() {
		List<Salary> list = new ArrayList<>();
		Salary salary;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("SELECT * FROM salary where paymentdate=(SELECT CURRENT_DATE()");

			ResultSet rs = pst.executeQuery();
			System.out.println("salary");
			while (rs.next()) {
				salary = new Salary(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDouble(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getDouble(10));
				list.add(salary);
			}

		} catch (Exception e) {

		}
		return list;
	}

	//// salary search by id

	public List<Salary> salarysearchbyidmehtod(Salary sal) {
		List<Salary> list = new ArrayList<>();
		Salary salary;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select * from Salary where empid=?");
			pst.setInt(1, sal.empid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				salary = new Salary(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDouble(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getDouble(10));
				list.add(salary);
			}

		} catch (Exception e) {

		}
		return list;
	}
	//// salary search by month year

	public List<Salary> salarysearchbymonthyearmehtod(Salary sal) {
		List<Salary> list = new ArrayList<>();
		Salary salary;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select * from Salary where startingdate=? and endingdate=?");
			pst.setDate(1, sal.startingdate);
			pst.setDate(2, sal.endingdate);
			System.out.println("salaaa");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				salary = new Salary(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDouble(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getDouble(10));
				list.add(salary);
			}

		} catch (Exception e) {

		}
		return list;
	}

	//// attendance

////insert database

	public int todayattendencecheck(int empid, Date attendancedate) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("SELECT * FROM Attendance where empid=? and attendancedate=?");
			pst.setInt(1, empid);
			pst.setDate(2, attendancedate);
			ResultSet rs = pst.executeQuery();
			System.out.println("salary");
			while (rs.next()) {
				return 1;
			}

		} catch (Exception e) {

		}
		return 0;
	}

	public void loginattendance(Attendance attendance) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"insert into Attendance (empid, attendancedate,logintime,status)  values(?,?,?,?)");
			System.out.println("balllll");
			pst.setInt(1, attendance.empid);
			pst.setDate(2, attendance.attendancedate);
			pst.setString(3, attendance.getLogintime());
			pst.setString(4, attendance.getStatus());
			pst.executeUpdate();
			System.out.println("Insert");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	public List<Attendance> todayattAttendance() {
		List<Attendance> list = new ArrayList<>();
		Attendance attendance;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement(
					"select empid,attendancedate,logintime,logouttime,status from Attendance where attendancedate=(SELECT CURRENT_DATE())");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				attendance = new Attendance(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				list.add(attendance);
//				System.out.println(branch);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<Attendance> allattendance() {
		List<Attendance> list = new ArrayList<>();
		Attendance attendance;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement(
					"select empid,attendancedate,logintime,logouttime,status from Attendance ORDER BY attendancedate DESC");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				attendance = new Attendance(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				list.add(attendance);
//				System.out.println(branch);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public void logoutentryAdmin(Attendance attendance) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"update Attendance set logouttime=?, status=? where empid=? and attendancedate=?");
			pst.setString(1, attendance.logouttime);
			pst.setString(2, attendance.status);
			pst.setInt(3, attendance.empid);
			pst.setDate(4, attendance.attendancedate);
			pst.executeUpdate();
			System.out.println(" Status Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void logoutentry(Attendance attendance) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"update Attendance set logouttime=?, status=? where empid=? and attendancedate=(SELECT CURRENT_DATE())");
			pst.setString(1, attendance.logouttime);
			pst.setString(2, attendance.status);
			pst.setInt(3, attendance.empid);
			pst.executeUpdate();
			System.out.println(" Status Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<String> allprensentemployeeid() {
		List<String> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("select empid from Attendance where attendancedate=(SELECT CURRENT_DATE())");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<Attendance> attendencesearchbydate(Attendance attend) {
		List<Attendance> list = new ArrayList<>();
		Attendance attendance;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement(
					"select empid,attendancedate,logintime,logouttime,status from Attendance where attendancedate=?");
			pst.setDate(1, attend.attendancedate);
			System.out.println(attend.attendancedate);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				attendance = new Attendance(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				list.add(attendance);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<Attendance> attendencesearchbyid(Attendance attend) {
		List<Attendance> list = new ArrayList<>();
		Attendance attendance;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement(
					"select empid,attendancedate,logintime,logouttime,status from Attendance where empid=?");
			pst.setInt(1, attend.empid);
			System.out.println(attend.empid);
			System.out.println(attend.attendancedate);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				attendance = new Attendance(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				list.add(attendance);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<Attendance> searchforidlogout(Attendance attend) {
		List<Attendance> list = new ArrayList<>();
		Attendance attendance;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement(
					"select empid,attendancedate,logintime,logouttime,status from Attendance where empid=? && attendancedate=(SELECT CURRENT_DATE())");
			pst.setInt(1, attend.empid);
			System.out.println(attend.empid);
			System.out.println(attend.attendancedate);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				attendance = new Attendance(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				list.add(attendance);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	////// holiday
	public void addHoliday(Holiday holi) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("insert into holiday (holidaydate,description)  values(?,?)");
			pst.setDate(1, holi.holidaydate);
			pst.setString(2, holi.description);

			pst.executeUpdate();
			System.out.println("Insert");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<Holiday> allhoiliday() {
		List<Holiday> list = new ArrayList<>();
		Holiday holiday;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");

			pst = cn.prepareStatement("SELECT * FROM holiday ");

			ResultSet rs = pst.executeQuery();
			System.out.println("salary");
			while (rs.next()) {
				holiday = new Holiday(rs.getInt(1), rs.getDate(2), rs.getString(3));

				list.add(holiday);
			}

		} catch (Exception e) {

		}
		return list;
	}

	// holiday update

	public void updateHoliday(Holiday holiday) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("update holiday set holidaydate=?,description=? where serialno=?");
			pst.setDate(1, holiday.holidaydate);
			pst.setString(2, holiday.description);

			pst.setInt(3, holiday.serialno);
			pst.executeUpdate();
			System.out.println(" Sift employee Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void deleteHoliday(Holiday holiday) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("DELETE FROM holiday WHERE serialno=?");
			pst.setInt(1, holiday.serialno);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

////////////////////////////////////
	//////// leave
	public void leaverequest(Leavemange leavemange) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement(
					"insert into leavemange (empid,leavetype,fromdate,todate,leavesdays,description,applydate,status)  values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, leavemange.empid);
			Date stdate = leavemange.getFromdate();
			Date endate = leavemange.getTodate();
			long totDays = ((endate.getTime() - stdate.getTime()) / (1000 * 60 * 60 * 24)) + 1;
			int totalDays = (int) totDays;
			pst.setString(2, leavemange.leavetype);
			pst.setDate(3, leavemange.fromdate);
			pst.setDate(4, leavemange.todate);
			pst.setInt(5, totalDays);
			pst.setString(6, leavemange.description);
			pst.setDate(7, leavemange.applydate);
			pst.setString(8, "Pending");

			pst.executeUpdate();
			
			System.out.println("Insert leave");
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	

	public List<Leavemange> allleave() {
		List<Leavemange> list = new ArrayList<>();
		Leavemange leavemange;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("SELECT * FROM Leavemange");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				leavemange = new Leavemange(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getString(9));

				list.add(leavemange);
			}

		} catch (Exception e) {

		}
		return list;
	}
	public List<Leavemange> allapproveleave(String status) {
		List<Leavemange> list = new ArrayList<>();
		Leavemange leavemange;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("SELECT * FROM Leavemange where status=?");
			pst.setString(1, status);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				leavemange = new Leavemange(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getString(9));
				
				list.add(leavemange);
			}
			
		} catch (Exception e) {
			
		}
		return list;
	}

	public List<Leavemange> allleaveapply(int empid) {
		List<Leavemange> list = new ArrayList<>();
		Leavemange leavemange;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("SELECT * FROM Leavemange where empid=? ");
			pst.setInt(1, empid);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				leavemange = new Leavemange(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getString(9));

				list.add(leavemange);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<Leavemange> leaveapply(int empid) {
		List<Leavemange> list = new ArrayList<>();
		Leavemange leavemange;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("SELECT * FROM Leavemange where empid=? && status=? ");
			pst.setInt(1, empid);
			pst.setString(2, "Pending");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				leavemange = new Leavemange(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getString(9));

				list.add(leavemange);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public void leavegrantedbyadmin(Leavemange leavemange) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("update leavemange set status=? where serialno=?");
			pst.setString(1, leavemange.status);
			pst.setInt(2, leavemange.serialno);
			pst.executeUpdate();
			System.out.println(" leavestatus Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public int updatepass(Employee employee) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/officemanage", "root", "nh123456");
			pst = cn.prepareStatement("update employee set password=? where empid=?");
			pst.setString(1, employee.password);
			pst.setInt(2, employee.empid);
			
			pst.executeUpdate();
			
			if(pst.executeUpdate() > 0) {
				return  1;
			}
			System.out.println(" pass Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	

}
