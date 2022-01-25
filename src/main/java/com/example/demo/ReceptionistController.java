
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReceptionistController {
	String name = "Receptionist";
	

	@RequestMapping("receptionistlogin")
	public String receptionistlogin(Model m) {
		m.addAttribute("name", name);
		return "receptionistloginpage";
	}
	
	@RequestMapping("receptionistdeshboard")
	public String receptionistdeshboard(Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allattendance", eda.todayattAttendance());
		return "receptionistdeshboard";
	}
	
	
	@RequestMapping(value = "/receptionistaccess", method = RequestMethod.POST)
	public String receptionistaccess(@ModelAttribute() Employee employee, Model m) {
		ReceptionistDataAccess rda = new ReceptionistDataAccess();
		m.addAttribute("name", name);
		if (rda.receptionistlogin(employee) == 1) {
			System.out.println("receptionist Access");

			return "receptionistdeshboard";

		} else {
			return "receptionistloginpage";
		}

	}
	
	
	@RequestMapping("/receptionloginattendance")
	public String receptionloginattendance(@ModelAttribute() Attendance attendance, Model m) {
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());	
		m.addAttribute("name", name);
		m.addAttribute("allattendance", eda.todayattAttendance());	
		return "receptionloginattendance";
	}
	
	@RequestMapping("/receptinsertloginattendance")
	public String loginattendance(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		if(eda.todayattendencecheck(attendance.empid, attendance.attendancedate) == 0) {
		eda.loginattendance(attendance);
		}
		m.addAttribute("allemployee", eda.allemployeeid());	
		m.addAttribute("allattendance", eda.todayattAttendance());	
		return "receptionloginattendance";
	}
	@RequestMapping("/receplogoutattendanceentry")
	public String receplogoutattendanceentry(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.logoutentry(attendance);
		m.addAttribute("allemployee", eda.allprensentemployeeid());	
		m.addAttribute("allattendance", eda.todayattAttendance());	
		return "receptionlogoutattendancepage";
	}
	
	
	@RequestMapping("/receptionlogoutattendancepage")
	public String receptionlogoutattendancepage(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allprensentemployeeid());	
		m.addAttribute("allattendance", eda.todayattAttendance());	
		return "receptionlogoutattendancepage";
	}
	@RequestMapping("/recepsearchforidlogout")
	public String searchforidlogout(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());	
		m.addAttribute("allattendance", eda.searchforidlogout(attendance));
		return "receptionlogoutattendancepage";
	}
	
	@RequestMapping("/receptionattendancepage")
	public String allattendance(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());	
		m.addAttribute("allattendance", eda.allattendance());
		return "receptionattendancepage";
	}
	
	@RequestMapping("/recepsearchattendece")
	public String recepsearchattendece(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());	
		m.addAttribute("allattendance", eda.attendencesearchbydate(attendance));
		return "receptionattendancepage";
	}
	
	@RequestMapping("/recsearchattendbyid")
	public String recsearchattendbyid(@ModelAttribute() Attendance attendance, Model m) {
		m.addAttribute("name", name);
		EmployeeDataAccess eda = new EmployeeDataAccess();
		m.addAttribute("allemployee", eda.allemployeeid());	
		m.addAttribute("allattendance", eda.attendencesearchbyid(attendance));
		System.out.println( eda.attendencesearchbyid(attendance));
		return "receptionattendancepage";
	}
	
	

}
