package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class SqlSessionTemplate {

	
	public static SqlSession getSession() {
//		sqlsession만들기
		SqlSession session = null;
		
		
//		myBatis 설정 xml 가져오기
		String resource = "/mybatis-config.xml";
				try {
					//mybatis-config.xml파일을 InputStream을 통해서 가져옴
						InputStream is = Resources.getResourceAsStream(resource);
						
						
	//				sqlSessionFactoryBuilder 클래스를 생성
						SqlSessionFactoryBuilder  sfb = new SqlSessionFactoryBuilder();
	
	//				sqlsessionfacotry클래스를 생성
						SqlSessionFactory sf = sfb.build(is);
						
	//					session을 생성
							session = sf.openSession(false);
						
						
				}catch(IOException e) {
					e.printStackTrace();
				}
			
		
		return session;
	}
	
	
	
	public static void getParamMap(Map<String,Object> param, Map<String, String[]> reqParam) {
		for(String key : reqParam.keySet()) {
			
			param.put(key, reqParam.get(key)[0]);
			
		}
		
		
	}
}
