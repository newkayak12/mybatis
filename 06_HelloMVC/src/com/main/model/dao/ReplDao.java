package com.main.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.common.JDBCTemplate.*;
import com.main.model.vo.Repl;

public class ReplDao {
	Properties prop = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
			
	
	public ReplDao() {
		String path = ReplDao.class.getResource("/sql/main.properties").getPath();
		prop= new Properties();
		try {
			prop.load(new FileReader(path));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public List<Repl> select(Connection conn) {
		// TODO Auto-generated method stub
		List<Repl> list = new ArrayList();
		Repl repl = null;
		try {
				pstmt = conn.prepareStatement(prop.getProperty("select"));
				rs = pstmt.executeQuery();
					while(rs.next()) {
						repl = new Repl();
						repl.setSeq(rs.getString("repl_seq"));
						repl.setContent(rs.getString("content"));
						
						list.add(repl);
						
					}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return list;
		
	}

	public int insert(Connection conn, String content) {
		// TODO Auto-generated method stub
		int result = 0;
			
		try {
				pstmt = conn.prepareStatement(prop.getProperty("insert"));
				pstmt.setString(1, content);
				result = pstmt.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public int delete(Connection conn, String seq) {
		// TODO Auto-generated method stub
		int result = 0;
			
			try {
				pstmt = conn.prepareStatement(prop.getProperty("delete"));
				pstmt.setString(1, seq);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		return result;
	}

}
