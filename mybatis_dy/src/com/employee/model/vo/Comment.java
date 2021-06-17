package com.employee.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {
	private int commentNo;
	private String commentContent, commentWriter;
	private Date  commentDate;
	private int commentLevel;
	private int commentref;
	
}
