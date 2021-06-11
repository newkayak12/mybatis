package com.mybatis.contoller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;

/**
 * Servlet implementation class InsertAll
 */
@WebServlet("/paramMybatis/multi")
public class InsertAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String addr =  request.getParameter("addr");
		
		Student student = new Student();
//			student.setStudentName(name);
//			student.setStudentEmail(email);
//			student.setStudentTel(phone);
//			student.setStudentAddr(addr);
		
		
		//builder
//			student= Student.builder().studentName(name).studentAddr(addr).studentEmail(email).studentTel(phone).build();
		student= Student.builder().student_Name(name).student_Addr(addr).student_Email(email).student_Tel(phone).build();
			//매개변수 생성자를 기반으로 setter로 넣는..
			
		

			Map<String,String[]> param = request.getParameterMap();
			Map<String, String> result = new HashMap<String,String>();
			result.put("name", param.get("name")[0]);
			result.put("phone", param.get("phone")[0]);
			result.put("email", param.get("email")[0]);
			result.put("addr", param.get("addr")[0]);
			
//			response.getWriter().append(new MybatisService().insertAll(student)>0? "success":"fail");
			response.getWriter().append(new MybatisService().insertParamMap(result)>0? "success":"fail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
