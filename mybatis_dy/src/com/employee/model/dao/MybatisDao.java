package com.employee.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.employee.model.vo.Board;
import com.employee.model.vo.Emp;
import com.employee.model.vo.Employee;

public class MybatisDao {

	public List<Employee> selectAll(SqlSession session, int cPage, int numPerPage) {
		// TODO Auto-generated method stub
		
//		RowBounds 클래스는 생성할 때 매개변수 값으로 page의 범위를 결정
//		2개의 매개변수를 가짐 offset == (cPage-1)*numPerPage  limit ==  numPerPage
		
		return session.selectList("emp.selectAll",null,new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	public List<Employee> conditionalSearch(SqlSession session, Map<String, Object> parameter, int cPage, int numPerPage) {
		// TODO Auto-generated method stub
		return session.selectList("emp.conditionalSearch", parameter, new RowBounds((cPage-1)*numPerPage, numPerPage));
		
	}

	public int total(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("emp.total");
	}

	public int conditionalSearchCount(SqlSession session, Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return session.selectOne("emp.totalcount",parameter);
	}

	public Emp selectOne(SqlSession session, String no) {
		// TODO Auto-generated method stub
		return session.selectOne("emp.selectOne");
	}

	public Board selectBoard(SqlSession session, String no) {
		// TODO Auto-generated method stub
		return session.selectOne("emp.selectBoard", no);
	}

}
