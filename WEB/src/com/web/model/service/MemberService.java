package com.web.model.service;

import static com.common.Mybatis.getConnection;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.model.dao.MemberDao;
import com.web.model.vo.Member;

public class MemberService {

	public List<Member> all() {
		SqlSession session = getConnection();
		List<Member> result = new MemberDao().all(session);
		session.close();
		return result;
	}

	public List<Member> search(String keyword) {
		SqlSession session = getConnection();
		List<Member> result = new MemberDao().search(session, keyword);
		session.close();
		return result;
	}

	public List<Member> checkid(String id) {
		SqlSession session = getConnection();
		List<Member> result = new MemberDao().checkid(session, id);
		session.close();
		return result;
	}

	public int modify(String name, String phone) {
		// TODO Auto-generated method stub
		
		SqlSession session= getConnection();
		int result = new MemberDao().modify(session, name, phone);
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int enroll(Member m) {
		// TODO Auto-generated method stub
		SqlSession session= getConnection();
		int result = new MemberDao().enroll(session, m);
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int delete(String name) {
		SqlSession session= getConnection();
		int result = new MemberDao().delete(session,name );
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public List<Member> searcharrd(String keyword) {
		SqlSession session = getConnection();
		List<Member> result = new MemberDao().searchaddr(session, keyword);
		session.close();
		return result;
	}

}
