package com.member.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;
import static com.common.MybatisTemplate.connectSession;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
public class MemberService {
	
	private MemberDao dao=new MemberDao();
	
	
	public Member login(String userId, String pw) {
//		Connection conn=getConnection();
//		Member m=dao.login(conn,userId,pw);
//		close(conn);
		SqlSession session = connectSession();
		Member m=dao.login(session,userId,pw);
		
		session.close();
		
		return m;
	}
	
	public int insertMember(Member m){
		
//		Connection conn=getConnection();
//		int result=dao.insertMember(conn,m);
//		if(result>0) commit(conn);
//		else rollback(conn);
//		
//		close(conn);		
		SqlSession session = connectSession();
		int result=dao.insertMember(session,m);
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	
	
	public Member checkDuplicateId(String userId) {
		
		
//			Connection conn = getConnection();
//			Member m = dao.checkDuplicateId(userId, conn);
//			close(conn);
		SqlSession session = connectSession();
		Member m = dao.checkDuplicateId(userId, session);
		session.close();
			
		return m;
		
		
	}

	public int updateMember(Member mUpdate) {
//		Connection conn = getConnection();
//		
//		int result = dao.updateMember(mUpdate, conn);
//		if(result>0) {
//			
//			commit(conn);
//		} else {
//			
//			rollback(conn);
//		}
//		
//		close(conn);
		
		SqlSession session = connectSession();
		int result = dao.updateMember(mUpdate, session);
		
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		return result;
	}

	public int memberDelete(String userId) {
		
		Connection conn =  getConnection();
		
		
		int result = dao.memberDelete(userId, conn);
		
		if(result >0) {
			commit(conn);
		} else {
			
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int checkPw(String userId,  String passwordOld, String passwordNew) {
		// TODO Auto-generated method stub
			Connection conn = getConnection();
			System.out.println("Service "+userId + " " + passwordOld + " " + passwordNew);
			int result = dao.checkPw(userId,passwordOld, passwordNew, conn);
			if(result>0) {
				commit(conn);
			}  else {
				rollback(conn);
			}
			
			
			close(conn);
		
		return result;
	}
	
	
	
}






