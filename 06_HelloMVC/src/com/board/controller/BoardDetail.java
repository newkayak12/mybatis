package com.board.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.board.model.service.*;
import com.board.model.vo.*;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/board/boarddetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("detail : "+no);
		HttpSession session = request.getSession(false);

		
		Board result = new BoardService().boardDetail(no);
		List<BoardComment> comment = new BoardService().selectBoardComment(no);
		
		
		//쿠키에 저장하는 값
		//boardRead를 키로 읽은 게시글의 번호르 저장
		
		Cookie[] cookies = request.getCookies();
		String boardRead ="";
		boolean readFlag = false;
		
		if(cookies !=null) {
			for(Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				
					if(name.equals("boardRead")) {
						boardRead = value;
						
						if(value.contains("|"+no+"|")) {
							
							readFlag = true;
							break;
						}  else {
							
							int count = result.getBoardReadCount();
							++count;
							new BoardService().boardDetailReadCount(count, no);
							result.setBoardReadCount(count);
							
							
							break;
							
						}
						
					} 
						

						
						
						
					
			}
		}
		
		
		if(!readFlag) {
			
			Cookie cookie = new Cookie("boardRead" , boardRead+ "|"+no+"|");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		} 
		
		
		
		
		
		request.setAttribute("result", result);
		request.setAttribute("comment", comment);
		
		request.getRequestDispatcher("/views/board/boarddetail.jsp").forward(request, response);
		
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
