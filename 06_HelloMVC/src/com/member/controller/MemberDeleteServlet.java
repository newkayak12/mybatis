package com.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/memberdelete.do")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.클라이언트가 보낸 id값을 기준으로  (pk라서) 
		
		
		
		String userId = request.getParameter("userId");
		int result = new MemberService().memberDelete(userId);
		
		String msg = (result==0? "탈퇴가 정상적으로 진행되지 않았습니다." : "탈퇴가 완료되었습니다.");
//		String loc = (result==0? "/memberview.do":"/logout");
		String loc = "/logout";
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
