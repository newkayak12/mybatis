package com.common.filter;

import java.io.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;

import javax.servlet.http.*;

public class PasswordEncryptWrapper extends HttpServletRequestWrapper{

	public PasswordEncryptWrapper(HttpServletRequest request) {
		super(request);
		
	}
	
	//암호 getParameter로 패스워드를 호출하면 암호화해서 보내주자!
	
		@Override
	public String getParameter(String name) {
			//매개변수 name의 값이 password일 때 암호화 처리 
		String value = "";
			
			
			
			if(name.equals("password")||name.equals("password_new") ) {
//				암호화 시켜서 반환하는 구간
					System.out.println("암호화 전 " + super.getParameter(name));
					
				value = getSHA512(super.getParameter(name));
				
				
					System.out.println("암호화 후 " + value);
			} else {
				
				value = super.getParameter(name);
			}
			
			
			return value;
	}
		
		

		private String getSHA512(String parameter) {
			
			
			String encPwd = " ";
//			암호화 처리 객체 선언
			MessageDigest md = null;
			
				try {
//					암호 알고리즘을 선택해서 객체 생성
						md = MessageDigest.getInstance("SHA-512");
					
				}catch( NoSuchAlgorithmException e){
					
					e.printStackTrace();
					
				}
			
			//암호화는 bit연산을 한다. 
				
					
					byte[] bytes = parameter.getBytes(Charset.forName("UTF-8"));
					md.update(bytes);
					
			// 비트 연산을 한 것을 STRING으로 변환
					
					encPwd = Base64.getEncoder().encodeToString(md.digest());
			
			
			return encPwd;
		}
		
		
}
