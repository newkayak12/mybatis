package com.mybatis.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/paramMybatis/update")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
//		Student s = Student.builder().studentName(request.getParameter("name")).studentTel(request.getParameter("tel")).studentAddr(request.getParameter("addr")).build();
		Student s = Student.builder().student_Name(request.getParameter("name")).student_Tel(request.getParameter("tel")).student_Addr(request.getParameter("addr")).build();
		
			/*
			 * 
			 * Map<String,Object param = new HashMap();
			 * 
			 */
		
			response.getWriter().append(new MybatisService().update(s)>0? "success":"fail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
