package com.hdfc.olms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.olms.entity.LeaveBalance;
import com.hdfc.olms.service.ILeaveBalanceService;

@RestController
@RequestMapping("/api/leave-balance")
public class LeaveBalanceController {
	@Autowired
	ILeaveBalanceService leaveBalanceService;
	
	@GetMapping("/get")
	public List<LeaveBalance> getCurrentUserLeaveBalance() {
		return leaveBalanceService.getLeaveBalance();
	}

}
