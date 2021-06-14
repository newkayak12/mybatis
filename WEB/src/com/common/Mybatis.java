package com.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatis {
	
	public static SqlSession getConnection() {
		SqlSession  session = null;
		
		String path = "/sqlconnection.xml";
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				try {
						InputStream is = Resources.getResourceAsStream(path);
						SqlSessionFactory factory =  builder.build(is);
						
							session = factory.openSession();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return session;
	}
	
	
}
