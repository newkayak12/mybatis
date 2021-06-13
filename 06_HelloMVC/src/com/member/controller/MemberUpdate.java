package com.member.controller;

import java.io.*;
import java.security.*;

import javax.crypto.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.common.*;
import com.member.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class MemberUpdate
 */
@WebServlet(name = "memberupdateservlet", urlPatterns = "/memberupdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
//		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
			
			
			
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		
		Member mUpdate = new Member();
		mUpdate.setUserId(userId);
		mUpdate.setPassword(null);
		mUpdate.setUserName(userName);
		mUpdate.setAge(age);
		mUpdate.setEmail(email);
		mUpdate.setPhone(phone);
		mUpdate.setAddress(address);
		mUpdate.setGender(gender);
		mUpdate.setHobby(String.join(",", hobby));
		
		int result = new MemberService().updateMember(mUpdate);
		
		
		String msg = "";
		String loc = "";
		if(result>0) {
			msg = "정보 수정에 성공했습니다.";
			loc = "/memberview.do?userId="+userId;
		} else {
			
			msg = "정보 수정에 실패했습니다.";
			loc = "/logout";
			
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);;
	
		
		
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
