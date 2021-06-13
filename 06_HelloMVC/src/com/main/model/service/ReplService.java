package com.main.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.main.model.dao.ReplDao;
import com.main.model.vo.Repl;

public class ReplService {
	ReplDao repl = new ReplDao();
	
	
	public List<Repl> select() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		List<Repl> list = repl.select(conn);
		close(conn);	
		
		return list;
	}

	public int insert(String content) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = repl.insert(conn, content);
			
			if(result>0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		
		close(conn);	
		return result;
	}

	public int delete(String seq) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = repl.delete(conn,seq);
		
			if(result>0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
		close(conn);	
		return result;
		
	}

}
