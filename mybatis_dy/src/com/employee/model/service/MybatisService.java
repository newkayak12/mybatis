package com.employee.model.service;

import static com.common.Mybatis.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.employee.model.dao.MybatisDao;
import com.employee.model.vo.Employee;

public class MybatisService {

	public List<Employee> selectAll() {
		SqlSession session = getSession();
		List<Employee> list = new MybatisDao().selectAll(session);
		
			session.close();
		return list;
	}

	public List<Employee> conditionalSearch(Map<String, String> parameter) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		List<Employee> list = new MybatisDao().conditionalSearch(session, parameter);
		session.close();
		return list;
	}

}
