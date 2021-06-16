package com.employee.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {
	private String empId, empName,empNo, email, phone, deptCode, jobCode, salLevel;
	private int  salary;
	private double bonus;
	private String managerId;
	private Date hireDate, entDate;
	private char entYN;
	private char gender;
	
	
}
