package com.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class checkDuplicatedIdServlet
 */
@WebServlet("/checkDuplicatedId")
public class checkDuplicatedIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkDuplicatedIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("come serv");
		
		
		String userId = request.getParameter("userIdCheck");
		System.out.println(userId);
		
		Member m = new MemberService().checkDuplicateId(userId);
		
		
		System.out.println("serv"+ m);
		
		request.setAttribute("result", m);
		request.getRequestDispatcher("/views/member/checkDuplicateId.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
