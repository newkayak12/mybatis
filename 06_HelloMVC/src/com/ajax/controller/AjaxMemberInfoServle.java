package com.ajax.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class AjaxMemberInfoServle
 */
@WebServlet(name="ajaxMember", urlPatterns = "/memberInfo")
public class AjaxMemberInfoServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMemberInfoServle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId= request.getParameter("userId");
		String password= request.getParameter("password");
		Member m = new MemberService().login(userId, password);
		
		PrintWriter out = response.getWriter();
		out.append(m.getUserId()+" "+m.getPassword()+" "+m.getUserName()+" "+m.getAge());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
