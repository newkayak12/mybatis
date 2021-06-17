package com.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.service.MybatisService;
import com.employee.model.vo.Employee;

/**
 * Servlet implementation class MybatisSelectAll
 */
@WebServlet("/selectall")
public class MybatisSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisSelectAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cPage;
		int numPerPage;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}

		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (NumberFormatException e) {
			numPerPage = 5;
		}
		
		int totalData = new MybatisService().total();
		int totalPage = (int)Math.ceil((double) totalData/numPerPage);
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		
//		request.getContextPath()/selectall?cPage="+cPage+"&numPerPage="+numPerPage+"
		
		String pageBar="<ul class='pagination justify-content-center pagination-sm'>";
				if(pageNo == 1) {
					pageBar += "<li class='page-item disabled'>";
					pageBar += "<a class='page-link' href ='#' tabindex='-1'> 이전 </a>";
					pageBar += "</li>";
				} else {
					pageBar += "<li class='page-item'>";
					pageBar += "<a class='page-link' href ='javascript:fn_pageing("+(pageNo-1)+")'> 이전 </a>";
					pageBar += "</li>";
				}
				
				while(!(pageNo>pageEnd||pageNo>totalPage)){
					
					if(pageNo== cPage) {
						pageBar += "<li class='page-item active'>";
						pageBar += "<a class='page-link'>" +pageNo+"</a>";
						pageBar += "</li>";
					} else {
						
						pageBar += "<li class='page-item'>";
						pageBar += "<a class='page-link' href ='javascript:fn_pageing("+pageNo+")'>"+pageNo+"</a>";
						pageBar += "</li>";
					}
					
					pageNo++;
					
					
				}
				
				if(pageNo>totalPage) {
					pageBar += "<li class='page-item disabled'>";
					pageBar += "<a class='page-link'> 다음 </a>";
					pageBar += "</li>";
				} else {
					pageBar += "<li class='page-item'>";
					pageBar += "<a class='page-link' href ='javascript:fn_pageing("+pageNo+")'> 다음 </a>";
					pageBar += "</li>";
				}
				
				pageBar+="</ul>";
				
				pageBar+="<script>";
				pageBar+="function fn_pageing(cPage) { location.assign('"+request.getRequestURI()+"?cPage='+cPage);}";
				pageBar+="</script>";
//				
		List<Employee> list = new MybatisService().selectAll(cPage,numPerPage);
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/selectAll.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
