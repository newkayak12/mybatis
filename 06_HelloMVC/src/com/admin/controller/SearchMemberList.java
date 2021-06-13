package com.admin.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.admin.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class SearchMemberList
 */
@WebServlet("/admin/searchmemberlist")
public class SearchMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchKeyword = request.getParameter("searchKeyword");
		String searchType = request.getParameter("searchType");
		
		
		
		
		
		
		String pageBar = "";
		int cPage = 1;
				try {
						cPage = Integer.parseInt(request.getParameter("cPage"));
						
					} catch(NumberFormatException e) {
						cPage = 1;
					}
				
		
		int numPerPage = 10;
					try {
						
						 numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
					} catch(NumberFormatException e) {
						numPerPage = 4;
					}
					
		List<Member> result = new AdminService().conditionalSearch(searchKeyword, searchType, cPage, numPerPage);
		int resultCount = new AdminService().conditionalcount(searchKeyword, searchType);
		System.out.println(resultCount);
		int totalData = resultCount;
		int totalPage = (int) Math.ceil((double)totalData/numPerPage);
		int pageBarSize = 4;
		
		int pageNo = ((cPage-1)/pageBarSize) * pageBarSize +1;
		int pageEnd = pageNo + pageBarSize - 1;
		
		
		
//		 이전
					if(pageNo == 1) {
						pageBar +="<span> &nbsp;&nbsp; </span>";
					}else {
						
						pageBar += "<a href = '"+request.getContextPath()+"/admin/searchmemberlist?cPage="+ pageNo +"&numPerPage="+numPerPage+"&searchType"+searchType+"&serachKeyword="+searchKeyword+"'>[이전]</a>";
					}
					
					
		
		
		
//		 내용
		
					while(!(pageNo>pageEnd || pageNo>totalPage)) {
						if(cPage == pageNo) {
							pageBar += "<span>&nbsp;&nbsp"+ pageNo + "&nbsp;&nbsp;</span>";
						} else {
							pageBar += "<a href = '"+ request.getContextPath() +"/admin/searchmemberlist?cPage="+ pageNo +"&numPerPage="+numPerPage+"&searchType"+searchType+"&serachKeyword="+searchKeyword+"'>&nbsp;&nbsp;"+pageNo+"&nbsp;&nbsp;</a>";
						}
						
						
						pageNo ++;
					}
					
		
		
		
		
		
		
//		 다음 
		
					if(pageNo > totalPage) {
						pageBar +="<span> &nbsp;&nbsp; </span>";
					}else {
						
						pageBar += "<a href = '"+request.getContextPath()+"/admin/searchmemberlist?cPage="+ pageNo +"&numPerPage="+numPerPage+"&searchType"+searchType+"&serachKeyword="+searchKeyword+"'>[다]</a>";
					}
					
		
			
		
			request.setAttribute("pageBar", pageBar);
			request.setAttribute("list", result);
			request.setAttribute("numPerPage", numPerPage);
			 request.setAttribute("where", "searchMemberList");
			 
			 
			request.setAttribute("searchType", searchType);
			request.setAttribute("searchKeyword", searchKeyword);
			
			
			request.getRequestDispatcher("/views/admin/memberlist.jsp").forward(request, response);
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
