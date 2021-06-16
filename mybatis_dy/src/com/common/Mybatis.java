package com.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatis {
	
	
	public static SqlSession getSession() {
		SqlSession  session = null;
		String path = "/mybatis.xml";
		
		try {
//				InputStream is = Resources.getResourceAsStream(path);
//				SqlSessionFactoryBuilder sb = new SqlSessionFactoryBuilder();
//				SqlSessionFactory sf = sb.build(is);
//				
//				session = sf.openSession(false);
				
				session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("/mybatis.xml")).openSession(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return session;
	}

}
