package com.common;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTemplate {
	
	
	public static SqlSession connectSession() {
		SqlSession session = null;
		String path = "/myBatis-configuration.xml";
		
		
		
		try {
				InputStream is = Resources.getResourceAsStream(path);
				SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
				SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
				
				session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return session;
	}
	
	
}
