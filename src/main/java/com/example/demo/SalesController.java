package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalesController {
	int employeeid ;
	@RequestMapping("saleslogin")
	public String saleslogin(Model m) {
		m.addAttribute("name", employeeid);
		return "salesloginpage";
	}
	@RequestMapping("salesmandeshboard")
	public String salesloginpage(Model m) {
		m.addAttribute("name", employeeid);
		return "salesmandeshboard";
	}
	
	
	@RequestMapping(value = "/salesmanaccess", method = RequestMethod.POST)
	public String salesmanaccess(@ModelAttribute() Employee employee, Model m) {
		SalesDataAccess sda= new SalesDataAccess();
		employeeid = employee.empid;
		m.addAttribute("name", employee.empid);
		if (sda.salesmanlogin(employee) == 1) {
			System.out.println("sales Access");

			return "salesmandeshboard";

		} else {
			return "salesloginpage";
		}

	}

}
