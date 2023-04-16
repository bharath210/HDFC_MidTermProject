package com.hdfc.olms.entity;

import java.time.LocalDate;

import com.hdfc.olms.utils.enums.LeaveStatusType;
import com.hdfc.olms.utils.enums.LeaveType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *@author Bharath Kumar
 *@created 12-Apr-2023
*
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LeaveRequest {

	private long leaveRequestId;
	private Employee employee;
	private LocalDate startDate;
	private LocalDate endDate;
	private LeaveType leaveType;
	private String reason;

}
