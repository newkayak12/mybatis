package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

public class MybatisDao {

	public int insertStudent(SqlSession session) {
		// TODO Auto-generated method stub
		
		//session이 제공하는 sql실행 메소드를 호출하면 끝
			int result = session.insert("student.insertStudent");
//					String mapper 중 하나 골라라 / Object insert 할 녀석
//						mapper는 namespace이름.태그(insert,update,delete,select)의 id값
			
		return result;
	}

}
