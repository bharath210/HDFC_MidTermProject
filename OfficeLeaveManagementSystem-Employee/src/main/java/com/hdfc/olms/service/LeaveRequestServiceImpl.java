package com.hdfc.olms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hdfc.olms.entity.Employee;
import com.hdfc.olms.entity.LeaveRequest;
import com.hdfc.olms.utils.enums.LeaveType;
import com.hdfc.olms.vo.LeaveRequestVO;
/**
 *@author Bharath Kumar
 *@created 13-Apr-2023
*
 */
@Service
public class LeaveRequestServiceImpl implements ILeaveRequestService{
		
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	IEmployeeService employeeService;
	public Employee getEmployee() {
		return employeeService.getCurrentUser();
	}
	
	String baseUrl = "http://localhost:7000/api/admin/leave-request";

	@Override
	public LeaveRequestVO applyForLeave(String startDate, String endDate, LeaveType leaveType, String reason) {
		LeaveRequest leaveRequest = new LeaveRequest();
		 leaveRequest.setEmployee(getEmployee());
		 leaveRequest.setStartDate(LocalDate.parse(startDate));
		 leaveRequest.setEndDate(LocalDate.parse(endDate));
		 leaveRequest.setLeaveType(leaveType);
		 leaveRequest.setReason(reason);
		 

//		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<?> requestEntity = new HttpEntity<>(leaveRequest, headers);
		
		  LeaveRequestVO leaveRequestVO =restTemplate.postForObject(baseUrl+"/apply-leave", leaveRequest,
		  LeaveRequestVO.class); 
		  return leaveRequestVO;
		 
	}

	@Override
	public LeaveRequestVO modifyLeave(LeaveRequest leaveRequest) {
		leaveRequest.setEmployee(getEmployee());
		LeaveRequestVO leaveRequestVO = restTemplate.postForObject(baseUrl + "/apply-leave", leaveRequest, LeaveRequestVO.class);
		return leaveRequestVO;
	}

	@Override
	public LeaveRequestVO getLeaveRequestStatus(long leaveRequestId) {	
//		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
		LeaveRequestVO leaveRequestVO = restTemplate.getForObject(baseUrl + "/get/leave-status/" + leaveRequestId, LeaveRequestVO.class);
		return leaveRequestVO;
	}

	@Override
	public List<LeaveRequestVO> getCurrentUserPendingLeaves() {
//		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
	List<LeaveRequestVO> leaveRequests = restTemplate.getForObject(baseUrl + "/get/pending-leaves/" +getEmployee().getEmployeeId(), List.class);
		return leaveRequests;
	}

	@Override
	public List<LeaveRequestVO> getCurrentUserLeaveHistory() {
//		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
		List<LeaveRequestVO> leaveRequests = restTemplate.getForObject(baseUrl + "/get/leave-history/by-id/"+getEmployee().getEmployeeId(), List.class);
		return leaveRequests;
	}
	
}
