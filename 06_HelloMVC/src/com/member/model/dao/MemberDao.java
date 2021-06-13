package com.member.model.dao;



import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import com.member.model.vo.Member;
import com.sun.net.httpserver.Authenticator.*;

import static com.common.JDBCTemplate.close;

public class MemberDao {

	private Properties prop=new Properties();
	
	public MemberDao() {
		try {
			String filePath=MemberDao.class.getResource("/sql/member_sql.properties").getPath();
			prop.load(new FileReader(filePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Member login(Connection conn, String userId, String pw) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMember"));
			pstmt.setString(1,userId);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				//조회된 row가 있다
				m=new Member();
				m.setUserId(rs.getString("userid"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("username"));
				m.setAge(rs.getInt("age"));
				//char형으로 데이터를 받을 때 사용
				//m.setGender(rs.getString("gender").charAt(0));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enrolldate"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	
	
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertMember"));
			pstmt.setString(1,m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7,m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	

	public Member checkDuplicateId(String userId, Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		
		System.out.println("dao in"+userId);
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberId"));
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				//조회된 row가 있다
				m=new Member();
				m.setUserId(rs.getString("userid"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("username"));
				m.setAge(rs.getInt("age"));
				//char형으로 데이터를 받을 때 사용
				//m.setGender(rs.getString("gender").charAt(0));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enrolldate"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println(m);
		return m;
	}

	public int updateMember(Member mUpdate, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
				
				try {
					pstmt = conn.prepareStatement(prop.getProperty("updateMember"));
//					pstmt.setString(1, mUpdate.getUserId());
//					pstmt.setString(2, mUpdate.getPassword());
					pstmt.setString(1, mUpdate.getUserName());
					pstmt.setString(2, mUpdate.getGender());
					pstmt.setInt(3, mUpdate.getAge());
					pstmt.setString(4, mUpdate.getEmail());
					pstmt.setString(5, mUpdate.getPhone());
					pstmt.setString(6, mUpdate.getAddress());
					pstmt.setString(7, mUpdate.getHobby());
					pstmt.setString(8, mUpdate.getUserId());
					
					result = pstmt.executeUpdate();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}finally {
					
					close(pstmt);
				}
		
		
		
		
		return result;
	}

	public int memberDelete(String userId, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
			try {
					pstmt = conn.prepareStatement(prop.getProperty("deleteMember"));
					pstmt.setString(1, userId);
					result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				close(pstmt);
				
			}
			
		
		
		
		
		
		return result;
	}

	public int checkPw(String userId, String passwordOld, String passwordNew, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		System.out.println("DAO "+userId + " " + passwordOld + " " + passwordNew);
			try {
					
					pstmt = conn.prepareStatement(prop.getProperty("checkMemberPW"));
					pstmt.setString(1, userId);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						System.out.println("DB  " + rs.getString("password"));
						
						if(passwordOld.equals(rs.getString("password"))){
							
							pstmt = conn.prepareStatement(prop.getProperty("updateMemberPW"));
							pstmt.setString(1, passwordNew);
							result = pstmt.executeUpdate();
							
							System.out.println("check2");
							
						}
						
						
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

	
//	mybatis ===========================================================================
	public Member login(SqlSession session, String userId, String pw) {
		Member m = Member.builder().userId(userId).password(pw).build();
		
		return session.selectOne("member.login", m);
		
	}

	public int insertMember(SqlSession session, Member m) {
	
		return session.insert("member.insertMember",m);
	}

	public Member checkDuplicateId(String userId, SqlSession session) {
		// TODO Auto-generated method stub
		
		return session.selectOne("member.checkDuplicationId", userId);
	}

	public int updateMember(Member mUpdate, SqlSession session) {
		// TODO Auto-generated method stub
		
		
		return session.update("member.updateMember",mUpdate);
	}
}








