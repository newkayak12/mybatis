package com.board.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;
import static com.common.MybatisTemplate.connectSession;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.model.dao.BoardDao;
import com.board.model.vo.Board;
import com.board.model.vo.BoardComment;

public class BoardService {
	private Connection conn = null;
	private BoardDao bd = new BoardDao();
	private List<Board> result = null;
	
	

	public List<Board> showAll(int cPage, int numPerPage) {
//		conn = getConnection();
//		result = bd.showAll(conn, cPage, numPerPage);
//		close(conn);
		SqlSession session = connectSession();
		result = bd.showAll(session, cPage, numPerPage);
		session.close();
		return result;
	}

	public int showAllCount() {

		conn = getConnection();
		
		int result = bd.showAllCount(conn);
		
		close(conn);
		return result;
	}

	public Board boardDetail(int no) {
//		conn = getConnection();
//		
//		Board result = bd.boardDetail(no, conn);
//		
//		close(conn);
		
		SqlSession session = connectSession();
		Board result = bd.boardDetail(no, session);
		session.close();
		return result;
	}

	public void boardDetailReadCount(int count, int no) {
//		conn= getConnection();
//		
//		int result = bd.boardDetailReadCount(count,conn, no);
//		
//		if(result>0) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//		
//		close(conn);
		
		SqlSession session = connectSession();
		int result = bd.boardDetailReadCount(session, count, no);
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		// TODO Auto-generated method stub
		
	}

	public int createBoard(Board b) {
		// TODO Auto-generated method stub
		conn=getConnection();
		
		int result = bd.createBoard(conn, b);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int boardDelete(int no) {
		conn = getConnection();
		
		
		int result = bd.boardDelete(no, conn);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertBoardComment(BoardComment bc) {
		conn= getConnection();
		
		int result = bd.insertBoardComment(bc, conn);
		
				if(result>0) {
					commit(conn);
				} else {
					rollback(conn);
				}
		
		close(conn);
		return result;
	}

	public List<BoardComment> selectBoardComment(int no) {
		
		conn= getConnection();
		List<BoardComment> result = bd.selectBoardComment(conn, no);
				
		close(conn);
		// TODO Auto-generated method stub
		return result;
	}

	

	
}
