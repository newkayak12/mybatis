package com.employee.model.vo;

import lombok.Data;

@Data
public class Emp {
	private String emp_id, emp_name, emp_no, email, phone;
	private Department dept;
	private String job_code, sal_level;
	private int salary;
	private double bonus;

}
