package com.notice.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.notice.model.service.*;
import com.notice.model.vo.*;

/**
 * Servlet implementation class NoticeList
 */
@WebServlet("/notice/noticelist")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		int cPage = 1;
			
			try {
				
					cPage= Integer.parseInt(request.getParameter("cPage"));

			} catch (NumberFormatException e) {

					cPage = 1;
			}
			
		
		int numPerPage = 5;
		
			try {
				
				
					numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
			} catch (NumberFormatException e) {
			
					numPerPage = 5;
			}
			
		
		int totalData = new NoticeService().showAllCount();
		int totalPage = (int)  Math.ceil(((double)totalData/numPerPage));
		int pageBarSize = 5;
		
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
			
		List<Notice> result = new NoticeService().showAll(cPage, numPerPage);
		
		
		String html = "";
		
			if(pageNo==1) {
				
				html+="<span>&nbsp;&nbsp;</span>";
			} else {
				
				html += "<a href = '"+request.getContextPath()+"/notice/noticelist?cPage="+ (pageNo-1) +"&numPerPage="+numPerPage+"'>[이전]</a>";
			}
			
			
			while(!(pageNo>pageEnd || pageNo>totalPage)) {
				if(cPage==pageNo) {
					html+="<span>&nbsp;"+pageNo+"&nbsp;</span>";
				} else {
					

					html += "<a href = '"+request.getContextPath()+"/notice/noticelist?cPage="+ (pageNo) +"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
				}
				
				pageNo++;
			}
			
			
			
			if(pageNo>totalPage) {
   				html+= "<span>&nbsp;&nbsp;</span>";
   				
   			} else {
   				html += "<a href ='" + request.getContextPath()+"/notice/noticelist?cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
   			}
			
			
			System.out.println(html);
		
			
			request.setAttribute("pageBar", html);
			request.setAttribute("result", result);
			request.getRequestDispatcher("/views/notice/notice.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
