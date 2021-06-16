package com.employee.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.service.MybatisService;
import com.employee.model.vo.Employee;

/**
 * Servlet implementation class SearchEmpSevlet
 */
@WebServlet("/searchemp")
public class SearchEmpSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmpSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		
		String gender = request.getParameter("gender");
		String keyword = request.getParameter("searchKeyword");
		String type = request.getParameter("searchType");
		String salary = request.getParameter("salary");
		String le_ge = request.getParameter("le_ge");
		String hiredate = request.getParameter("hiredate");
		String h_le_ge = request.getParameter("h_le_ge");
		System.out.println(hiredate + " " + h_le_ge);
		
		Map<String,String> parameter = new HashMap();
		parameter.put("searchKeyword", keyword);
		parameter.put("searchType", type);
		parameter.put("gender", gender);
		parameter.put("le_ge", le_ge);
		parameter.put("salary", salary);
		parameter.put("hiredate", hiredate);
		parameter.put("h_le_ge", h_le_ge);
		
		
				
		
		List<Employee> list = new MybatisService().conditionalSearch(parameter);
		
			request.setAttribute("list", list);
			request.setAttribute("keyword",request.getParameter("searchKeyword"));
			request.setAttribute("type",request.getParameter("searchType"));
			request.getRequestDispatcher("views/selectAll.jsp").forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
