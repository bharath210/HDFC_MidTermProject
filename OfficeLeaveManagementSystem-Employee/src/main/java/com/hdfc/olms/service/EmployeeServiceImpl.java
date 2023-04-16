package com.hdfc.olms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hdfc.olms.entity.Employee;
/**
 *@author Bharath Kumar
 *@created 13-Apr-2023
*
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	RestTemplate restTemplate;
	
	
	String baseUrl = "http://localhost:7000/api/admin/employees";
	
	public String getUserName() {
	String currentUserName= null;
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	if (!(authentication instanceof AnonymousAuthenticationToken)) {
	     currentUserName =userDetails.getUsername();
		}
	System.err.println("Current username -----> "+currentUserName);
	return currentUserName;
	}
	
	@Override
	public Employee getCurrentUser() {
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
		Employee employee =  restTemplate.getForObject(baseUrl + "/get-by-email/" + getUserName(), Employee.class);
		return employee;
	}

}
