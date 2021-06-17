package com.employee.model.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String boardWriter, boardContent;
	private Date  boardDate;
	private List<Comment> comments;
	

}
