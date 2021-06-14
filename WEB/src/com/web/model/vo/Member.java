package com.web.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Member {
	private String userid, password, username, gender, age, email, phone, address, hobby;
	private Date enrolldate;
}
