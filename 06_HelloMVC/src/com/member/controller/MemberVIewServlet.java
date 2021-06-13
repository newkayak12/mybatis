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
 * Servlet implementation class MemberVIewServlet
 */
@WebServlet(name = "memberViewServ", urlPatterns = "/memberview.do")
public class MemberVIewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberVIewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		클라이언트가 보낸 아이디를 기준으로 정보를 가져옴
		String userId = request.getParameter("userId");
		Member m = new MemberService().checkDuplicateId(userId);
		
		try {
			
			m.setEmail(AESCryptor.decrypt(m.getEmail()));
			m.setPhone(AESCryptor.decrypt(m.getPhone()));
			
		} catch (Exception e) {
			
		}
		
		
		//m이 null이면 회원정보 수정 불가
		//msg페이지로 이동해서 알람를 출력한다. 로그인을 취소하고 메인화면으로 이동
		
		
		//m이 null이 아니면 회원정보 수정으로 들어감 
		//회원 수정 페이지로 이동시킴 
		
		
		String view ="";
		String loc = "/logout";
		String msg = "";
		
		if(m != null) {
			
			view="/views/member/memberview.jsp";
			
		} else {
		
			view="/views/common/msg.jsp";
			msg="가입된 회원이 아닙니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc",loc);
		request.setAttribute("member", m);
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
