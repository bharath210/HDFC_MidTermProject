package com.hdfc.olms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.olms.entity.LeaveRequest;
import com.hdfc.olms.service.ILeaveRequestService;
import com.hdfc.olms.utils.enums.LeaveType;
import com.hdfc.olms.vo.LeaveRequestVO;


/**
 *@author Bharath Kumar
 *@created 14-Apr-2023
*
 */
@RestController
@RequestMapping("/api/leave-request")
public class LeaveRequestController {
	
	@Autowired
	ILeaveRequestService leaveRequestService;
	
	@PostMapping("/apply-leave")
	public LeaveRequestVO applyLeave(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("leaveType") LeaveType leaveType, @RequestParam("reason") String reason) {
		return leaveRequestService.applyForLeave(startDate, endDate, leaveType, reason);
	}
	
	@PutMapping("/modify-leave")
	public LeaveRequestVO modifyLeave(@RequestBody LeaveRequest leaveRequest) {
		return leaveRequestService.modifyLeave(leaveRequest);
	}
	
	@GetMapping("/leave-status/{leaveRequestId}")
	public LeaveRequestVO getLeaveRequestStatus(@PathVariable long leaveRequestId) {
		return leaveRequestService.getLeaveRequestStatus(leaveRequestId);
	}
	
	@GetMapping("/leave-history")
	public List<LeaveRequestVO> getCurrentUserLeaveHistory(){
		return leaveRequestService.getCurrentUserLeaveHistory();
	}
	
	@GetMapping("/pending-leaves")
	public List<LeaveRequestVO> getMyPendingLeaves(){
		return leaveRequestService.getCurrentUserPendingLeaves();
	}
}
