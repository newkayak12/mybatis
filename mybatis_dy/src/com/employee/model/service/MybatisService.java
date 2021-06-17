package com.employee.model.service;

import static com.common.Mybatis.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.employee.model.dao.MybatisDao;
import com.employee.model.vo.Board;
import com.employee.model.vo.Emp;
import com.employee.model.vo.Employee;

public class MybatisService {

	public List<Employee> selectAll(int cPage, int numPerPage) {
		SqlSession session = getSession();
		List<Employee> list = new MybatisDao().selectAll(session, cPage, numPerPage);
		
			session.close();
		return list;
	}

	public List<Employee> conditionalSearch(Map<String, Object> parameter, int cPage, int numPerPage) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		List<Employee> list = new MybatisDao().conditionalSearch(session, parameter,cPage,numPerPage);
		session.close();
		return list;
	}

	public int total() {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		int count  = new MybatisDao().total(session);
		session.close();
		return count;
	}

	public int conditionalSearchCount(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		SqlSession session= getSession();
		int result = new MybatisDao().conditionalSearchCount(session,parameter);
		session.close();
		return result;
	}
	
	/////////////////////////////////////////

	public Emp selectOne(String no) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		Emp e = new MybatisDao().selectOne(session,no);
		session.close();
		return e;
	}

	public Board selectBoard(String no) {
		// 
		
		SqlSession session = getSession();
		Board b = new MybatisDao().selectBoard(session, no);
		session.close();
		return b;
	}

}
