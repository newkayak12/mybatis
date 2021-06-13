package com.notice.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.*;
import java.util.*;

import com.notice.model.dao.*;
import com.notice.model.vo.*;
public class NoticeService {
	private Connection conn = null;
	private NoticeDao dao = new NoticeDao();
	
	public List<Notice> showAll(int cPage, int numPerPage) {
		conn = getConnection();
		
		List<Notice> result = dao.showAll(conn, cPage, numPerPage);
		
		
		return result;
	}

	public Notice showDetail(String noticeNo) {
		conn = getConnection();
				
		Notice result = dao.showDetail(conn, noticeNo);	
				
		close(conn);
		
		
		return result;
	}

	public int showAllCount() {
		conn = getConnection();
		
		int result = dao.showAll(conn);	
				
		close(conn);
		
		
		return result;
	}

	public int noticeWrite(Notice n) {
		conn= getConnection();
		
		int result = dao.noticeWrite(n, conn);
		
		if(result>0){
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public int noticeDelete(int no) {
		conn = getConnection();
		
		int result = dao.noticeDelete(conn, no);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public int noticeUpdate(Notice n) {
		conn = getConnection();
		
		int result = dao.noticeUpdate(n,conn);
		
		if( result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

}
