package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public class MybatisDao {

	public int insertStudent(SqlSession session) {
		// TODO Auto-generated method stub
		
		//session이 제공하는 sql실행 메소드를 호출하면 끝
			
//					String mapper 중 하나 골라라 / Object insert 할 녀석
//						mapper는 namespace이름.태그(insert,update,delete,select)의 id값
			
		return  session.insert("student.insertStudent");
	}

	public int insertName(SqlSession session, String name) {
		// TODO Auto-generated method stub
		
		
		return session.insert("student.insertName", name);
	}

	public int emailInsert(SqlSession session, String email) {
		// TODO Auto-generated method stub
		return session.insert("student.insertEmail",email);
	}

	public int insertAll(SqlSession session, Student student) {
		// TODO Auto-generated method stub
		return session.insert("student.insertAll",student);
	}

	public int insertParamMap(SqlSession session, Map<String, String> param) {
		// TODO Auto-generated method stub
		return session.insert("student.insertParamMap", param);
	}

	public int update(SqlSession session, Student s) {
		// TODO Auto-generated method stub
		return session.update("student.update",s);
	}

	public int delete(SqlSession session, String parameter) {
		// TODO Auto-generated method stub
		return session.delete("student.delete",parameter);
	}

	public int selectCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("student.selectCount");
		
		//select 쿼리를 실행한 결과가 1개의 row만 가져온다면(최~대가 1개) >> selectOne ==사용자가 지정한 반환타입
		//select 쿼리를 실행한 결과가 1개 이상이라면 >> selectList ==list 단, 제네릭 타입을 정할 수 있다.
		//selectMap == map
		
	}

	public Student selectOne(SqlSession session, int no) {
		
		return session.selectOne("student.selectOne", no);
	}

	public List<Student> selectAll(SqlSession session) {
		List<Student> list = session.selectList("student.selectAll");
		
		
		return list;
	}

	public Map selectMap(SqlSession session, int no) {
		
		return session.selectOne("student.selectMap", no);
	}

	public Student searchKeyword(SqlSession session, String keyword) {
		// TODO Auto-generated method stub
		return session.selectOne("student.searchKeyword",keyword);
	}

	public List<Map> mapAll(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("student.mapAll");
	}
	
	

}
