package com.notice.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.notice.model.service.*;
import com.notice.model.vo.*;

/**
 * Servlet implementation class NoticeDetail
 */
@WebServlet("/notice/noticedetail")
public class NoticeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNo = request.getParameter("notice_no");
		String noticeWriter = request.getParameter("notice_writer");
		
		Notice result = new NoticeService().showDetail(noticeNo);
		
		
		request.setAttribute("result2", result);
		System.out.println("detail"+ result);
		request.getRequestDispatcher("/views/notice/noticedetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
