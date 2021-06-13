package com.mybatis.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//기본적으로 getter/setter/기본생성자/toString/hashcode/equals 를 생성
@NoArgsConstructor
//기본생성자
@AllArgsConstructor
//매개변수 생성자
@Builder
//set~를 한 줄로...?
public class Student {
	
	private int studentNo;
	private String studentName, studentTel, studentAddr, studentEmail;
	private Date regDate;
	
	
	
}
