package com.notice.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import static com.common.JDBCTemplate.*;
import com.notice.model.vo.*;

public class NoticeDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	
	
	 public NoticeDao() {
		 prop = new Properties();
			 try {
				 
			String file = NoticeDao.class.getResource("/sql/notice_sql.properties").getPath();
				prop.load(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	 }
	
	public List<Notice> showAll(Connection conn, int cPage, int numPerPage) {
		Notice notice = null;
		List<Notice> result = new ArrayList<Notice>();
				try {
					pstmt = conn.prepareStatement(prop.getProperty("showAll"));
					pstmt.setInt(1, (cPage-1)*numPerPage+1);
					pstmt.setInt(2, cPage*numPerPage);
					rs = pstmt.executeQuery();
					
						while(rs.next()) {
							notice = new Notice();
							notice.setNoticeNo(rs.getInt("NOTICE_NO"));
							notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
							notice.setNoticeWriter(rs.getString("NOTICE_WRITER"));
							notice.setNoticeContent(rs.getString("NOTICE_CONTENT"));
							notice.setNoticeDate(rs.getString("NOTICE_DATE"));
							notice.setFilepath(rs.getString("FILEPATH"));
							notice.setStatus(rs.getString("STATUS"));
							
							
							result.add(notice);
							
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

	public Notice showDetail(Connection conn, String noticeNo) {
		Notice notice = null;
		try {
				pstmt = conn.prepareStatement(prop.getProperty("showDetail"));
				pstmt.setString(1, noticeNo);
				
				rs =pstmt.executeQuery();
				
					if(rs.next()) {
						
						notice = new Notice();
						notice.setNoticeNo(rs.getInt("NOTICE_NO"));
						notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
						notice.setNoticeWriter(rs.getString("NOTICE_WRITER"));
						notice.setNoticeContent(rs.getString("NOTICE_CONTENT"));
						notice.setNoticeDate(rs.getString("NOTICE_DATE"));
						notice.setFilepath(rs.getString("FILEPATH"));
						notice.setStatus(rs.getString("STATUS"));
						
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		
		
		
		return notice;
	}

	public int showAll(Connection conn) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("showAllCount"));
		
			
			rs =pstmt.executeQuery();
			
				if(rs.next()) {
					
					result = rs.getInt(1);
					
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

	public int noticeWrite(Notice n, Connection conn) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("noticeInsert"));
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeWriter());
			pstmt.setString(3, n.getNoticeContent());
			pstmt.setString(4, n.getFilepath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public int noticeDelete(Connection conn, int no) {
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("noticeDelete"));
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public int noticeUpdate(Notice n, Connection conn) {
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("noticeupdate"));
			pstmt.setString(1,	n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeWriter());
			pstmt.setString(3, n.getNoticeContent());
			pstmt.setString(4,  n.getFilepath());
			pstmt.setInt(5, n.getNoticeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		// TODO Auto-generated method stub
		return result;
	}

}
