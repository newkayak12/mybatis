package com.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;

/**
 * Servlet implementation class UpdatePasswordEnd
 */
@WebServlet(name="updatePasswordEnd",urlPatterns = "/updatePasswordEnd")
public class UpdatePasswordEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String userId = (String) request.getAttribute("userId");
		
		String userId = request.getParameter("userId");
		String passwordOld = request.getParameter("password");
		String passwordNew = request.getParameter("password_new");
		
			System.out.println(userId + " " + passwordOld + " " + passwordNew);	
			
		int flag = new MemberService().checkPw(userId, passwordOld, passwordNew);
			
		System.out.println("result fin : " +flag);
		
		String loc = (flag>0)? "/":("/passwordUpdate?userId="+userId);
		String msg = (flag>0)? "비밀번호 변경에 성공했습니다.":"비밀번호 변경에 실패했습니다.";
		String script = (flag>0)? "window.close();":"";
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.setAttribute("script", script);
		
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
