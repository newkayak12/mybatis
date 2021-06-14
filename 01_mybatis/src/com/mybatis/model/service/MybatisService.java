package com.mybatis.model.service;

import static com.mybatis.common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;
import com.mybatis.model.vo.Student;
public class MybatisService {
	private MybatisDao dao = new MybatisDao();

	public int insertStudent() {
		SqlSession session = getSession();
		
		int result = dao.insertStudent(session);
		
				if(result>0) {
					session.commit(); 
				} else {
					
					session.rollback();
				}
			session.close();
		return result;
	}

	public int insertName(String name) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		
		int result = dao.insertName(session, name);
			
				if(result>0) {
					session.commit();
				} else {
					session.rollback();
				}
			session.close();
		return result;
	}

	public int emailInsert(String email) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		
		int result = dao.emailInsert(session, email);
		
			if(result>0) {
				session.commit();
			} else {
				session.rollback();
			}
		
			session.close();
		return result;
	}

	public int insertAll(Student student) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		
		int result =  dao.insertAll(session, student);
		
			if(result>0) {
				session.commit();
			} else {
				session.rollback();
			}
		
			session.close();
		return result;
	}

	public int insertParamMap(Map<String, String> param) {
		SqlSession session = getSession();
		
		int result = dao.insertParamMap(session, param);
		
			if(result>0) {
				session.commit();
			} else {
				session.rollback();
			}
		
			session.close();
		return result;
	}

	public int update(Student s) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		
		int result = dao.update(session, s);

		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
	
		session.close();
		
		return result;
	}

	public int delete(String parameter) {
		// TODO Auto-generated method stub
SqlSession session = getSession();
		
		int result = dao.delete(session, parameter);

		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
	
		session.close();
		
		return result;

	}

	public int selectCount() {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		int result = dao.selectCount(session);
		session.close();
		
		return result;
	}

	public Student selectOne(int no) {
		// 
		SqlSession session = getSession();
		Student s = dao.selectOne(session, no);
		return s;
	}

	public List<Student> selectAll() {
		// 
		SqlSession session =getSession();
		List<Student> list = dao.selectAll(session);
		
		session.close();
		return list;
	}

	public Map selectMap(int no) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		
		
		Map student =  dao.selectMap( session , no);
		
		
		session.close();
		return student;
	}

	public Student searchKeyword(String keyword) {
		
		SqlSession session = getSession();
		Student student = dao.searchKeyword(session, keyword);
		session.close();
		return student;
	}

	public List<Map> mappAll() {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		List<Map> list = dao.mapAll(session);
		session.close();
		return list;
	}
	
}
