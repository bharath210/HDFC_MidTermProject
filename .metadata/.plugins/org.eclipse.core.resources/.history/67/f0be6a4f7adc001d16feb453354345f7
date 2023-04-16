package com.hdfc.olms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.olms.entity.Employee;
import com.hdfc.olms.service.IEmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;
	
	@GetMapping("/me")
	public Employee getCurrentUser() {
		return employeeService.getCurrentUser();
	}

}
