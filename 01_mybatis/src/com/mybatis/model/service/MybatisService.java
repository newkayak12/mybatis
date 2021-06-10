package com.mybatis.model.service;

import static com.mybatis.common.SqlSessionTemplate.getSession;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;
public class MybatisService {
	private MybatisDao dao = new MybatisDao();

	public int insertStudent() {
		SqlSession session = getSession();
		
		int result = dao.insertStudent(session);
		
		if(result>0) {
			session.commit(); 
		} else {
			
			session.close();
		}
		
		
		return result;
	}
	
}
