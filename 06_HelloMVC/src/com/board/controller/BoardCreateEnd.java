package com.board.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.servlet.*;

import com.board.model.service.*;
import com.board.model.vo.*;
import com.common.*;
import com.oreilly.servlet.*;

/**
 * Servlet implementation class BoardCreateEnd
 */
@WebServlet("/board/boardcreateend")
public class BoardCreateEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCreateEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "잘못된 요청입니다.");
			request.setAttribute("loc", "/board/boardlist");
			request.getRequestDispatcher("views/common/msg.jsp").forward(request, response);
			return;
			
		}
		
		
		String path = request.getServletContext().getRealPath("/upload/board/");
		MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*10, "utf-8", new Myfile());
		
		
		Board b = new Board();
		b.setBoardTitle(mr.getParameter("boardTitle"));
		b.setBoardWriter(mr.getParameter("boardWriter"));
		b.setBoardOriginalFileName(mr.getOriginalFileName("boardFile"));
		b.setBoardRenameFileName(mr.getFilesystemName("boardFile"));
		b.setBoardContent(mr.getParameter("boardContent"));
		
		
		
		int result = new BoardService().createBoard(b);
		
		String msg = "";
		String loc = "";
		
			if(result>0) {
				msg= "등록 완료";
				loc="/board/boardlist";
			} else {
				msg="등록 실패";
				loc="/board/boardcreate?id="+mr.getParameter("boardWriter");
			}
			
		request.setAttribute("loc", loc);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
