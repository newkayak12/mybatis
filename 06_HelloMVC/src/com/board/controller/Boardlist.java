package com.board.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.board.model.service.*;
import com.board.model.vo.*;

/**
 * Servlet implementation class Boardlist
 */
@WebServlet("/board/boardlist")
public class Boardlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Boardlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage = 1;
		int numPerPage = 5;
			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
			
			try {
				numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
			
			
		
		
		int totalData = new BoardService().showAllCount();
		System.out.println("totalData " +totalData);
		int totalPage = (int) Math.ceil(((double) totalData/numPerPage));
		System.out.println("totalPage " + totalPage);
		List<Board> result = new BoardService().showAll(cPage, numPerPage);
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/numPerPage)*numPerPage+1;
		int pageEnd = pageNo+pageBarSize-1;
		
		
		String html = "";
		
			if(pageNo==1) {
				
				html+="<span>&nbsp;&nbsp;</span>";
			} else {
				
				html += "<a href = '"+request.getContextPath()+"/board/boardlist?cPage="+ (pageNo-1) +"&numPerPage="+numPerPage+"'>[이전]</a>";
			}
			
			
			while(!(pageNo>pageEnd || pageNo>totalPage)) {
				if(cPage==pageNo) {
					html+="<span>"+pageNo+"</span>";
				} else {
					

					html += "<a href = '"+request.getContextPath()+"/board/boardlist?cPage="+ (pageNo) +"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
				}
				
				pageNo++;
			}
			

			if(pageNo>totalPage) {
   				html+= "<span>&nbsp;&nbsp;</span>";
   				
   			} else {
   				html += "<a href ='" + request.getContextPath()+"/board/boardlist?cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
   			}
			
			
			
			
			
			System.out.println(html);
		
			
			request.setAttribute("pageBar", html);
			request.setAttribute("result", result);
			request.getRequestDispatcher("/views/board/boardlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
