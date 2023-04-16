package com.hdfc.olms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hdfc.olms.entity.LeaveRequest;
import com.hdfc.olms.utils.enums.LeaveType;
import com.hdfc.olms.vo.LeaveRequestVO;
/**
 *@author Bharath Kumar
 *@created 13-Apr-2023
*
 */
public interface ILeaveRequestService {
	public LeaveRequestVO applyForLeave(String startDate, String endDate, LeaveType leaveType, String reason);
	public LeaveRequestVO modifyLeave(LeaveRequest leaveRequest);
	public LeaveRequestVO getLeaveRequestStatus(long leaveRequestId);
	public List<LeaveRequestVO> getCurrentUserPendingLeaves();
	public List<LeaveRequestVO> getCurrentUserLeaveHistory();
}
