package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.service.*;
import com.board.model.vo.*;

/**
 * Servlet implementation class InsertBoardComment
 */
@WebServlet("/board/insertboardcomment")
public class InsertBoardComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardRef = Integer.parseInt(request.getParameter("boardRef"));
		String commentWriter = request.getParameter("commentWriter");
		int boardCommentLevel = Integer.parseInt(request.getParameter("boardCommentLevel"));
		int boardCommentRef = Integer.parseInt(request.getParameter("boardCommentRef"));
		String content = request.getParameter("content");
		
		BoardComment bc = new BoardComment();
		bc.setBoardRef(boardRef);
		bc.setBoardCommentLevel(boardCommentLevel);
		bc.setBoardCommentRef(boardCommentRef);
		bc.setBoardCommentWriter(commentWriter);
		bc.setBoardCommentContent(content);
		
		
		int result = new BoardService().insertBoardComment(bc);
		if(result>0) {
			request.setAttribute("loc", "/board/boarddetail?no="+boardRef);
			request.setAttribute("msg", "성공적으로 작성했습니다.");
		} else {
			request.setAttribute("loc", "/board/boarddetail?no="+boardRef);
			request.setAttribute("msg", "실패.");
			
		}
		
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
