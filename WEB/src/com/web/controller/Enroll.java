package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.service.MemberService;
import com.web.model.vo.Member;

/**
 * Servlet implementation class Enroll
 */
@WebServlet("/enroll")
public class Enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enroll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member m = Member.builder().userid(request.getParameter("id")).password(request.getParameter("password")).username(request.getParameter("username")).gender(request.getParameter("gender")).age(request.getParameter("age")).email(request.getParameter("email")).phone(request.getParameter("phone")).address(request.getParameter("address")).build();
		m.setHobby("none");
		int result = new MemberService().enroll(m);
		
		if(result>0) {
			response.getWriter().write("success");
		} else {
			response.getWriter().write("fail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
