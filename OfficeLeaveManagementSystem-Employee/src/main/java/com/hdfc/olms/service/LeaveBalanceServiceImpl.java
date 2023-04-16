package com.hdfc.olms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hdfc.olms.entity.Employee;
import com.hdfc.olms.entity.LeaveBalance;
/**
 *@author Bharath Kumar
 *@created 13-Apr-2023
*
 */
@Service
public class LeaveBalanceServiceImpl implements ILeaveBalanceService{

	String baseUrl = "http://localhost:7000/api/admin/leave-balance";
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	IEmployeeService employeeService;
	public Employee getEmployee() {
		return employeeService.getCurrentUser();
	}
	
	@Override
	public List<LeaveBalance> getLeaveBalance() {
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
		return restTemplate.getForObject(baseUrl + "/get-by-employee/" + getEmployee().getEmployeeId(), List.class);
	}
	
	

}
