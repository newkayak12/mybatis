package com.board.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import com.board.model.vo.Board;
import com.board.model.vo.BoardComment;
import com.common.JDBCTemplate;

public class BoardDao {
	private Properties prop = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public BoardDao() {
		prop = new Properties();
		try {
			String path = JDBCTemplate.class.getResource("/sql/board_sql.properties").getPath();
			prop.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public List<Board> showAll(Connection conn, int cPage, int numPerPage) {
		List<Board> result = new ArrayList();
		Board b = null;
			try {
				pstmt = conn.prepareStatement(prop.getProperty("boardshowall"));
				pstmt.setInt(1, (cPage-1)*numPerPage+1);
				pstmt.setInt(2, cPage*numPerPage);
				
				rs= pstmt.executeQuery();
				while(rs.next()) {
					b = new Board();
					b.setBoardNo(rs.getString("BOARD_NO"));
					b.setBoardTitle(rs.getString("BOARD_TITLE"));
					b.setBoardWriter(rs.getString("BOARD_WRITER"));
					b.setBoardContent(rs.getString("BOARD_CONTENT"));
					b.setBoardOriginalFileName(rs.getString("BOARD_ORIGINAL_FILENAME"));
					b.setBoardRenameFileName(rs.getString("BOARD_RENAMED_FILENAME"));
					b.setBoardDate(rs.getString("BOARD_DATE"));
					b.setBoardReadCount(rs.getInt("BOARD_READCOUNT"));
					
					result.add(b);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		
		
		
		
		return result;
	}

	public int showAllCount(Connection conn) {
		int resultCount = 0;
		
			try {
				pstmt = conn.prepareStatement(prop.getProperty("boardshowallcount"));
				rs=pstmt.executeQuery();
				if(rs.next()) {
					resultCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			
			
		
		return resultCount;
	}

	public Board boardDetail(int no, Connection conn) {
		Board result = null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("boardDetail"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result = new Board();
				result.setBoardNo(rs.getString("BOARD_NO"));
				result.setBoardTitle(rs.getString("BOARD_TITLE"));
				result.setBoardWriter(rs.getString("BOARD_WRITER"));
				result.setBoardContent(rs.getString("BOARD_CONTENT"));
				result.setBoardOriginalFileName(rs.getString("BOARD_ORIGINAL_FILENAME"));
				result.setBoardRenameFileName(rs.getString("BOARD_RENAMED_FILENAME"));
				result.setBoardDate(rs.getString("BOARD_DATE"));
				result.setBoardReadCount(rs.getInt("BOARD_READCOUNT"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}

	public int boardDetailReadCount(int count, Connection conn, int no) {
		int result =0; 
		try {
			pstmt= conn.prepareStatement(prop.getProperty("boardReadCount"));
			pstmt.setInt(1, count);
			pstmt.setInt(2, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public int createBoard(Connection conn, Board b) {
		// TODO Auto-generated method stub
		int result = 0;
			try {
				pstmt=conn.prepareStatement(prop.getProperty("boardinsert"));
				pstmt.setString(1, b.getBoardTitle());
				pstmt.setString(2, b.getBoardWriter());
				pstmt.setString(3, b.getBoardContent());
				pstmt.setString(4, b.getBoardOriginalFileName());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		
		
		System.out.println("dao" + result);
		return result;
	}

	public int boardDelete(int no, Connection conn) {
		int result =0;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("boardDelete"));
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public int insertBoardComment(BoardComment bc, Connection conn) {
		int result = 0;
		
		
					try {
						pstmt=conn.prepareStatement(prop.getProperty("insertBoardComment"));
						
			//			comment level, comment writer, comment content,
			//			board ref, board comment ref
						pstmt.setInt(1, bc.getBoardCommentLevel());
						pstmt.setString(2, bc.getBoardCommentWriter());
						pstmt.setString(3, bc.getBoardCommentContent());
						pstmt.setInt(4, bc.getBoardRef());
//						pstmt.setInt(5, bc.getBoardCommentRef()==0? null:bc.getBoardCommentRef());
						pstmt.setString(5, bc.getBoardCommentRef()==0? null:String.valueOf(bc.getBoardCommentRef()));
						result = pstmt.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						close(pstmt);
					}
					
		
		
		
		return result;
	}

	public List<BoardComment> selectBoardComment(Connection conn, int no) {
		
		List<BoardComment> result = new ArrayList();
		System.out.println(no);
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectBoardComment"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
					
					while(rs.next()) {
						BoardComment bc = new BoardComment();
						bc.setBoardCommentNo(rs.getInt("board_comment_no"));
						bc.setBoardCommentLevel(rs.getInt("board_comment_level"));
						bc.setBoardCommentWriter(rs.getString("board_comment_writer"));
						bc.setBoardCommentContent(rs.getString("board_comment_content"));
						bc.setBoardRef(rs.getInt("board_ref"));
						bc.setBoardCommentRef(rs.getInt("board_comment_ref"));
						bc.setBoardCommentDate(rs.getDate("board_comment_date"));
						
						result.add(bc);
						
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return result;
	}
/////////////////////////////////////////////////////mybatis
	public List<Board> showAll(SqlSession session, int cPage, int numPerPage) {
		// TODO Auto-generated method stub
		Map<String,Integer> combined = new HashMap<String,Integer>();
		combined.put("cPage", cPage);
		combined.put("numPerPage", numPerPage);
		return session.selectList("board.selectAll",combined);
	}

	public Board boardDetail(int no, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("board.boardDetail", no);
	}

	public int boardDetailReadCount(SqlSession session, int count, int no) {
		// TODO Auto-generated method stub
		Map<String,Integer> combined = new HashMap<String, Integer>();
		combined.put("count",count);
		combined.put("no",no);
		return session.update("board.boardDetailReadCount",combined);
	}

}
