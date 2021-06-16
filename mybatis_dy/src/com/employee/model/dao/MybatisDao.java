package com.employee.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.employee.model.vo.Employee;

public class MybatisDao {

	public List<Employee> selectAll(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("emp.selectAll");
	}

	public List<Employee> conditionalSearch(SqlSession session, Map<String, String> parameter) {
		// TODO Auto-generated method stub
		return session.selectList("emp.conditionalSearch", parameter);
		
	}

}
