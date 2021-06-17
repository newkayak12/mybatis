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
		String deptcode[] =request.getParameterValues("deptcode");
		
		
		
		
		Map<String,Object> parameter = new HashMap();
			parameter.put("searchKeyword", keyword);
			parameter.put("searchType", type);
			parameter.put("gender", gender);
			parameter.put("le_ge", le_ge);
			parameter.put("salary", salary);
			parameter.put("hiredate", hiredate);
			parameter.put("h_le_ge", h_le_ge);
			parameter.put("deptcode", deptcode);
			
		int cPage;
		 	try {
		 		
		 		cPage = Integer.parseInt(request.getParameter("cPage"));
		 	} catch(NumberFormatException e) {
		 		cPage=1;
		 	}
		int numPerPage;
		
			try {
				numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
				
			} catch(NumberFormatException e) {
				numPerPage =5;
			}
				
		int pageBarSize = 5;
		int totalData = new MybatisService().conditionalSearchCount(parameter);
		int totalPage = (int) Math.ceil((double)totalData/numPerPage);
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		List<Employee> list = new MybatisService().conditionalSearch(parameter,cPage,numPerPage);
		
		System.out.println(totalData+":");
		
		String pageBar="<ul class='pagination justify-content-center pagination-sm'>";
				
				
				if(pageNo==1) {
					pageBar += "<li class='page-item disabled'> <a href='#'class='page-link'  tabindex='-1' >이전</a> </li>";
				} else {
					pageBar +="<li class='page-item'>";
					pageBar += "<a class = 'page-link' href= 'javascript:fn_page("+(pageNo-1)+")>이전</a>";
					pageBar +="</li>";
				}
				
				
				while(!(pageNo>pageEnd||pageNo>totalPage)) {
					
					if(pageNo==cPage) {
						pageBar+="<li class='page-item active'>";
						pageBar +="<a class='page-link'>"+pageNo+"</a>";
						pageBar += "</li>";
					} else {
						pageBar+="<li class='page-item'>";
						pageBar+= "<a class='page-link' href= 'javascript:fn_page("+pageNo+")'>"+pageNo+"</a>";
						pageBar+= "</li>";
					}
					
					pageNo++;
				}
				
				if(pageNo>totalPage) {
					pageBar += "<li class='page-item' > <a href='#' class='page-link' disabled  >다음</a> </li>";
				} else {
					pageBar += "<li class='page-item' >";
					pageBar+= " <a class='page-link' href= 'javascript:fn_page("+pageNo+")' >다음</a>";
					pageBar+= "</li>";
				}
		
		pageBar+="</ul>";
		
		String dept ="";
		if(deptcode!=null) {
			for( String a : deptcode) {
				
				dept+= "&deptcode="+a;
			}
		}
		
		
		
		pageBar+= "<script> function fn_page(cPage){ location.assign('"+request.getRequestURI()+"?cPage='+cPage+'&gender="+gender+"&keyword="+keyword+"&type="+type+"&salary="+salary+"&le_ge="+le_ge+"&hiredate="+hiredate+"&h_le_ge="+h_le_ge+dept+"')}</script>";
		
		
//		request.setAttribute("gender",gender);
//		request.setAttribute("keyword",keyword);
//		request.setAttribute("type",type);
//		request.setAttribute("salary",salary);
//		request.setAttribute("le_ge",le_ge);
//		request.setAttribute("hiredate",hiredate);
//		request.setAttribute("h_le_ge",h_le_ge);
//		request.setAttribute("detpcode", deptcode);
//		request.setAttribute("pageBar", pageBar);
			request.setAttribute("list", list);
			request.setAttribute("cPage", cPage);
			request.setAttribute("pageBar", pageBar);
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
