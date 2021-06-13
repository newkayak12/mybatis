package com.notice.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.notice.model.service.*;
import com.notice.model.vo.*;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/notice/noticeupdate")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String no = request.getParameter("no");
		//사용자가 수정하고자 하는 게시판의 번호를 번호를 보냈으니 notice를 가져온다.
		Notice n = new NoticeService().showDetail(no);
		
		request.setAttribute("notice", n);
		request.getRequestDispatcher("/views/notice/noticeupdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
