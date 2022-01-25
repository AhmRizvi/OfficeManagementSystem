package com.example.demo;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	String name = "Administrator";
	int empid=0;

	@RequestMapping(value = "/adminaccess", method = RequestMethod.POST)
	public String m3(@ModelAttribute() Admin admin, Model m) {
		AdmindataAccess ada = new AdmindataAccess();
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("Totaolemp", eda.allemployeeData().size());
		m.addAttribute("allattendance", eda.todayattAttendance());
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("TotaolDepart", cao.alldepartment().size());
		m.addAttribute("TotaolBranch", cao.allbranchname().size());
		m.addAttribute("name", name);
		if (ada.login(admin) == 1) {
			System.out.println("Admin Access");

			return "admindeshboard";

		} else {
			return "adminlogin";
		}

	}

	@RequestMapping("adminlogin")
	public String m1() {
		return "adminlogin";
	}

	@RequestMapping("logout")
	public String logout() {
		return "index";
	}

	@RequestMapping("admindeshboard")
	public String admindeshboard(Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("Totaolemp", eda.allemployeeData().size());
		m.addAttribute("allattendance", eda.todayattAttendance());

		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("TotaolDepart", cao.alldepartment().size());
		m.addAttribute("TotaolBranch", cao.allbranchname().size());

		return "admindeshboard";
	}

//designation
	@RequestMapping("createdesignation")
	public String createdesignation(Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("alldesignation", cao.alldesignation());
		return "createdesignation";
	}

	@RequestMapping(value = "/savedesignation", method = RequestMethod.POST)
	public String savedesignation(@ModelAttribute() Designation designation, Model m) {
		CompanydataAccess cao = new CompanydataAccess();
		cao.designationinsert(designation);
		m.addAttribute("name", name);
		m.addAttribute("alldesignation", cao.alldesignation());
		return "createdesignation";
	}

	// designation finish
	///////////////////////////////
	// department
	@RequestMapping("createdepartment")
	public String createdepartment(Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("alldep", cao.alldepartment());

		return "department";
	}

	@RequestMapping(value = "/updatedeapartmenthead", method = RequestMethod.POST)
	public String updatedeapartmenthead(@ModelAttribute() Department department, Model m) {
		CompanydataAccess cao = new CompanydataAccess();
		cao.departmenthead(department);
		m.addAttribute("name", name);
		m.addAttribute("alldep", cao.alldepartment());

		return "department";
	}

	@RequestMapping(value = "/savedepartment", method = RequestMethod.POST)
	public String savedesignation(@ModelAttribute() Department department, Model m) {
		CompanydataAccess cao = new CompanydataAccess();
		cao.designationinsert(department);
		m.addAttribute("mess", "Department Insert");

		m.addAttribute("name", name);
		m.addAttribute("alldep", cao.alldepartment());

		return "department";
	}

	// department finish

	@RequestMapping("createemployee")
	public String employeeform() {
		return "createemployee";
	}

	// branch
	@RequestMapping("addbranch")
	public String addbranch(Model m) {

		CompanydataAccess dao = new CompanydataAccess();
		m.addAttribute("name", name);
		m.addAttribute("allbranch", dao.doShow());

		return "addbranch";
	}

	@RequestMapping(value = "/savebrench", method = RequestMethod.POST)
	public String savebrench(@ModelAttribute() Branch branch, Model m) {
		CompanydataAccess dao = new CompanydataAccess();
		dao.insert(branch);
		m.addAttribute("name", name);
		m.addAttribute("allbranch", dao.doShow());
		return "addbranch";
	}

	@RequestMapping(value = "/updatebranchstatus", method = RequestMethod.POST)
	public String updatebranchstatus(@ModelAttribute() Branch branch, Model m) {
		CompanydataAccess cao = new CompanydataAccess();
		cao.branchstatusupdate(branch);

		m.addAttribute("name", name);
		m.addAttribute("allbranch", cao.doShow());
		return "addbranch";
	}

	// branch finish

	/// employee
	@RequestMapping("/employee")
	public String employeeform(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemp", eda.allemployeeData());
		return "createemployee";
	}

	@RequestMapping("/allemployee")
	public String allemployee(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemp", eda.allemployeeData());
		return "allemployee";
	}

	@RequestMapping("/shiftemployee")
	public String shiftemployee(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemp", eda.allemployeeData());
		return "shiftemployee";
	}

	@RequestMapping("/searchdataallemp")
	public String searchdataallemp(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemp", eda.searchbyemployeeid(employee.empid));
		return "allemployee";
	}

	@RequestMapping("/shiftingemployee")
	public String shiftingemployee(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.shiftingemployeeinanother(employee);
		m.addAttribute("allemp", eda.allemployeeData());
		return "shiftemployee";
	}

	@RequestMapping("/searchdata")
	public String searchdata(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemp", eda.searchbyemployeeid(employee.empid));
		return "shiftemployee";
	}

	@RequestMapping("/saveemployee")
	public String saveemployee(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.insertemployee(employee);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		m.addAttribute("allemp", eda.allemployeeData());
		return "createemployee";
	}

	// employee information update
	@RequestMapping("/searchdataupdate")
	public String searchdataupdate(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemp", eda.searchbyemployeeid(employee.empid));
		return "empinfoupdate";
	}

	@RequestMapping("/empinfoupdate")
	public String empinfoupdate(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemp", eda.allemployeeData());
		return "empinfoupdate";
	}

	@RequestMapping("/empinfoupdatebtn")
	public String empinfoupdatebtn(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.updateEmpinfoupdate(employee);
		m.addAttribute("allemp", eda.allemployeeData());
		return "empinfoupdate";
	}

	///////////// employee status

	@RequestMapping("/empstatus")
	public String empstatus(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemp", eda.allemployeeData());
		return "empstatusupdate";
	}

	@RequestMapping("/empstatusSearch")
	public String empstatusSearch(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemp", eda.searchbyemployeeid(employee.empid));
		return "empstatusupdate";
	}

	@RequestMapping("/statusupdatebtn")
	public String statusupdatebtn(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", name);
		CompanydataAccess cao = new CompanydataAccess();
		m.addAttribute("designation", cao.alldesignationname());
		m.addAttribute("branch", cao.allbranchname());
		m.addAttribute("department", cao.alldepartmentname());
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.statusupdteforemp(employee);
		m.addAttribute("allemp", eda.searchbyemployeeid(employee.empid));
		return "empstatusupdate";
	}

	/// employee finish

	// salary part
	@RequestMapping("/salary")
	public String salarysheet(@ModelAttribute() Salary salary, Model m) {
//		@ModelAttribute() Salary salary,
		m.addAttribute("name", name);

		EmployeeDataAccess eda = new EmployeeDataAccess();

		if (eda.lastdateget() != null) {
			m.addAttribute("lastDate", eda.nextSalarystartdate(eda.lastdateget()));
		}
		m.addAttribute("salary", eda.allsalarysheet());
		System.out.println(eda.allsalarysheet());

		return "salarysheet";
	}

	@RequestMapping("/makesalary")
	public String makesalary(@ModelAttribute() Salary salary, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.createsalarysheet(salary, salary.startingdate, salary.endingdate);
		m.addAttribute("salary", eda.allsalarysheet());
		if (eda.lastdateget() != null) {
			m.addAttribute("lastDate", eda.nextSalarystartdate(eda.lastdateget()));
		}
		return "salarysheet";
	}

	@RequestMapping("/salarydetails")
	public String salarydetails(@ModelAttribute() Salary salary, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("salary", eda.allsalarysheet());
		return "salaryallinfo";
	}

	@RequestMapping("/salarysearchbyid")
	public String salarysearchbyid(@ModelAttribute() Salary salary, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("salary", eda.salarysearchbyidmehtod(salary));
		return "salaryallinfo";
	}

	@RequestMapping("/searchbymonthyear")
	public String searchbymonthyear(@ModelAttribute() Salary salary, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		System.out.println("sala");
		m.addAttribute("salary", eda.salarysearchbymonthyearmehtod(salary));
		return "salaryallinfo";
	}

	////////// attendance
	@RequestMapping("/loginattendance")
	public String attendance(@ModelAttribute() Attendance attendance, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("name", name);
		m.addAttribute("allattendance", eda.allattendance());
		return "loginattendance";
	}

	@RequestMapping("/insertloginattendance")
	public String loginattendance(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		if (eda.todayattendencecheck(attendance.empid, attendance.attendancedate) == 0) {
			eda.loginattendance(attendance);
		}
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("allattendance", eda.allattendance());
		return "loginattendance";
	}

	@RequestMapping("/logoutattendancepage")
	public String logoutattendancepage(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("allattendance", eda.allattendance());
		return "logoutattendance";
	}

	@RequestMapping("/searchforidlogout")
	public String searchforidlogout(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("allattendance", eda.allattendance());
		return "logoutattendance";
	}

	@RequestMapping("/logoutattendanceentry")
	public String logoutattendanceentry(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.logoutentryAdmin(attendance);
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("allattendance", eda.allattendance());
		return "logoutattendance";
	}

	@RequestMapping("/searchattendbyidlogout")
	public String searchattendbyidlogout(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("allattendance", eda.attendencesearchbyid(attendance));
		System.out.println(eda.attendencesearchbyid(attendance));
		return "logoutattendance";
	}

	//// attendance page
	@RequestMapping("/attendancepage")
	public String allattendance(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("allattendance", eda.allattendance());
		return "attendancepage";
	}

	@RequestMapping("/searchattendece")
	public String searchattendece(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("allattendance", eda.attendencesearchbydate(attendance));
		return "attendancepage";
	}

	@RequestMapping("/searchattendbyid")
	public String searchattendbyid(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());
		m.addAttribute("allattendance", eda.attendencesearchbyid(attendance));
		System.out.println(eda.attendencesearchbyid(attendance));
		return "attendancepage";
	}
////attendance page

	@RequestMapping("/demo")
	public String demo(Model m) {

		return "demo";
	}

	@RequestMapping("/addholiday")
	public String holiday(Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allholiday", eda.allhoiliday());

		return "addholiday";
	}

	@RequestMapping("/insertholiday")
	public String insertholiday(@ModelAttribute() Holiday holiday, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.addHoliday(holiday);
		m.addAttribute("allholiday", eda.allhoiliday());
		return "addholiday";
	}

	@RequestMapping("/updateholidayForm")
	public String updateholidayForm(@ModelAttribute() Holiday holiday, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("holiday", holiday);
		m.addAttribute("allholiday", eda.allhoiliday());
		return "manageholiday";
	}

	@RequestMapping("/deleteholidayaction")
	public String deleteholidayaction(@ModelAttribute() Holiday holiday, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.deleteHoliday(holiday);
		m.addAttribute("allholiday", eda.allhoiliday());
		return "addholiday";
	}
	@RequestMapping("/updateholiday")
	public String updateholiday(@ModelAttribute() Holiday holiday, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.updateHoliday(holiday);
		m.addAttribute("allholiday", eda.allhoiliday());
		return "manageholiday";
	}
	@RequestMapping("/manageholiday")
	public String manageholiday(@ModelAttribute() Holiday holiday, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allholiday", eda.allhoiliday());
		return "manageholiday";
	}
	
	
	
	
	//////////////////////////////////////////
	////////////////
	
	@RequestMapping("/leaveconfirmpage")
	public String manageholiday(@ModelAttribute() Leavemange leavemange, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allleave", eda.allleave());
		return "leaveconfirmpage";
	}
	
	@RequestMapping("/leavelistpageadmin")
	public String leavelistpageadmin(@ModelAttribute() Leavemange leavemange, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allleave", eda.allleave());
		return "leavelistpageadmin";
	}
	
	@RequestMapping("approvelist")
	public String approvelist(@ModelAttribute() Leavemange leavemange, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allleave", eda.allapproveleave(leavemange.status));
		return "leavelistpageadmin";
	}
	@RequestMapping("denylist")
	public String denylist(@ModelAttribute() Leavemange leavemange, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allleave", eda.allapproveleave(leavemange.status));
		return "leavelistpageadmin";
	}
	@RequestMapping("pendinglist")
	public String pendinglist(@ModelAttribute() Leavemange leavemange, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allleave", eda.allapproveleave(leavemange.status));
		return "leavelistpageadmin";
	}
	@RequestMapping("alllist")
	public String alllist(@ModelAttribute() Leavemange leavemange, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allleave", eda.allleave());
		return "leavelistpageadmin";
	}
	
	@RequestMapping("/leavegranted")
	public String leavegranted(@ModelAttribute() Leavemange leavemange, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.leavegrantedbyadmin(leavemange);		
		
		m.addAttribute("allleave", eda.allleave());
		return "leaveconfirmpage";
	}
	@RequestMapping("/leavedeny")
	public String leavedeny(@ModelAttribute() Leavemange leavemange, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.leavegrantedbyadmin(leavemange);
		
		m.addAttribute("allleave", eda.allleave());
		return "leaveconfirmpage";
	}
	
	
	
	
	////////////////////////////////
	///employee////////
	
	
	
	
	@RequestMapping("/employeelogin")
	public String employeelogin(Model m) {
		
		return "employeelogin";
	}
	
	@RequestMapping("/employeedeshboard")
	public String employeedeshboard(@ModelAttribute() Employee employee,Model m) {
		m.addAttribute("name", "Employee");
		m.addAttribute("emp", empid);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allholiday", eda.allhoiliday());
		
		return "employeedeshboard";
	}
	
	@RequestMapping("/leaveapplyypage")
	public String leaveapplyypage(@ModelAttribute()  Leavemange leavemange,Model m) {
		m.addAttribute("name", "Employee");
		m.addAttribute("emp", empid);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("pendingleave", eda.leaveapply(leavemange.empid));
		return "leaveapplyypage";
	}
	@RequestMapping("/leavelist")
	public String leavelistpage(@ModelAttribute()  Leavemange leavemange,Model m) {
		m.addAttribute("name", "Employee");
		m.addAttribute("emp", empid);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("pendingleave", eda.allleaveapply(leavemange.empid));
		return "leavelistpage";
	}
	@RequestMapping("/leaveapply")
	public String leaveapply(@ModelAttribute() Leavemange leavemange,Model m) {
		m.addAttribute("name", "Employee");
		m.addAttribute("emp", empid);
		EmployeeDataAccess eda =  new EmployeeDataAccess();	
		if (leavemange.fromdate.before(leavemange.todate)) {
			eda.leaverequest(leavemange);
			System.out.println(leavemange.fromdate+"+"+leavemange.todate);
		}
		m.addAttribute("pendingleave", eda.leaveapply(leavemange.empid));		
		return "leaveapplyypage";
	}
	
	
	
	/////////////////////
	//// employeelogin
	@RequestMapping(value = "/employeeaccess", method = RequestMethod.POST)
	public String employeeaccess(@ModelAttribute() Employee employee, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("name", "Employee");
		empid = employee.empid;		
		m.addAttribute("emp", empid);
		m.addAttribute("allholiday", eda.allhoiliday());
		if (eda.employeelogin(employee) == 1) {
			
			return "employeedeshboard";
		} else {
			return "employeelogin";
		}

	}
	
	
	
	/////////////notice "empchangepassword"
	
	@RequestMapping("/empchangepassword")
	public String empchangepassword(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", "Employee");
		m.addAttribute("emp", empid);
		return "empchangepassword";
	}
	@RequestMapping("/updatepass")
	public String updatepass(@ModelAttribute() Employee employee, Model m) {
		m.addAttribute("name", "Employee");
		m.addAttribute("emp", empid);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		if(eda.updatepass(employee) > 0) {
			m.addAttribute("updatepassword", "Update password is "+employee.getPassword());
		}else {
			m.addAttribute("updatepassword", "Not updated ");
		}
		
		return "empchangepassword";
	}
	
	
	
	

}
