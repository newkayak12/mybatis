package com.web.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.model.vo.Member;

public class MemberDao {

	public List<Member> all(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("member.all");
	}

	public List<Member> search(SqlSession session, String keyword) {
		// TODO Auto-generated method stub
		return session.selectList("member.search",keyword);
	}

	public List<Member> checkid(SqlSession session, String id) {
		// TODO Auto-generated method stub
		return session.selectList("member.checkid",id);
	}

	public int modify(SqlSession session, String name, String phone) {
		// TODO Auto-generated method stub
		Map<String,String> amap = new HashMap();
		amap.put("name", name);
		amap.put("phone", phone);
		
		return session.update("member.modify", amap);
	}

	public int enroll(SqlSession session, Member m) {
		// TODO Auto-generated method stub
		return session.insert("member.enroll",m);
	}

	public int delete(SqlSession session, String name) {
		// TODO Auto-generated method stub
		return session.insert("member.delete", name);
	}

	public List<Member> searchaddr(SqlSession session, String keyword) {
		// TODO Auto-generated method stub
		return session.selectList("member.searchaddr", keyword);
	}

}
