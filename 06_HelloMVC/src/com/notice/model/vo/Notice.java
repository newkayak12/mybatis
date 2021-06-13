package com.notice.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Notice {
	int noticeNo;
	String noticeTitle;
	String noticeWriter, noticeContent, noticeDate;
	String filepath, status;
	
	
	
	
}
