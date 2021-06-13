package com.common;

import java.io.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;

import javax.crypto.*;

// 양방향 암호화를 지원하는 클래스'
// 양방향 암호화 처리 클래스는 기본 java api에서 제공하고 있음
// javax.crypto패키지와 javax.secruity패키지에 구성되어 있다.

// 키는 프로젝트에서 단 한 개만 있어야함 
// 

public class AESCryptor {
	private static SecretKey key;  //암호화를 위한 키 클래스 
	private String path; //키를 파일로 저장해놓고 자동으로 로드될 수 있게 만들어 놓을 것, <파일로 저장된 암호화 키의 위치>
	
	public AESCryptor() {
// 기본으로 클래스가 인스턴스화 될 떄 기본 설정을 해줘야한다.
//		1. key파일이 있으면, 키 파일에서 SecretKey객체를 불러온다. 
//							없으면, SecretKey 객체를 생성하여 파일로 저장한다. 
		
		
		this.path = AESCryptor.class.getResource("/").getPath();
		this.path = this.path.substring(0,this.path.indexOf("classes"));
		
		System.out.println(path);
		File f = new File(this.path+"bslove.bs");
		System.out.println(f);
		//키를 저장하고 있는 파일 이름이 bslove.bs이다. 
		
		
			if(f.exists()) {
//				키를 저장하는 파일이 있으면, 
				
					try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));) {
						
							
								this.key = (SecretKey) ois.readObject();
					
					} catch(IOException | ClassNotFoundException e) {
							
						e.printStackTrace();
					}
				
				
				
				
			} else {
//				 없으면 SecretKey를 생성하고
				
				
				
				
						if(key == null) {
	//						getGenerator();로 키 값을 생성한다. (밑에서 만듬)
							getGenerator();
						
						}
					
			}
	}// 여기까지 생성자
	
	
	
	private void getGenerator( ) {
		
//		SecretKey를 생성하는 메소드 
		SecureRandom ser = new SecureRandom();
//		키를 만들 랜덤값 (Salt)값을 
		
		//키를 생성하는 클래스 
		KeyGenerator keygen = null;
		
			try {
//					키를 생성하기 위한 기본적인 값을 세팅하기
//					1. 적용할 알고리즘  AES > 인당 한 벌의 키  RSA > 키가 두 개 (공개, 개인(암, 복호화키))
				
				keygen = KeyGenerator.getInstance("AES");
//				키 생성 초기화
				keygen.init(128,ser);
				
				this.key = keygen.generateKey();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}  //키는 단 하나여야함 > 얘는 메모리에 올려주고 
			
			File f= new File(this.path+"bslove.bs");
			
				System.out.println("before");
			
				try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream (f));){
					
					System.out.println("create?");
					
					oos.writeObject(this.key);
				} catch(IOException e) {
					e.printStackTrace();
				}
		
	}
	
	
	
	//암호화 처리하기 
	public static String encrypt(String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException{
		
		
//		key를 가지고 암호화 처리하는 클래스가 있음 
//		Cipher이다. 
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, AESCryptor.key);
		
		byte[] encrypt = str.getBytes(Charset.forName("utf-8"));
		byte[] result = cipher.doFinal(encrypt);
		String resultValue = Base64.getEncoder().encodeToString(result);
		
		return resultValue;
	}
	
//	복호
	public static String decrypt(String encryptedstr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException{
			
			
	//		key를 가지고 암호화 처리하는 클래스가 있음 
	//		Cipher이다. 
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, AESCryptor.key);
			
			byte[] decodeStr = Base64.getDecoder().decode(encryptedstr.getBytes(Charset.forName("utf-8")));
			byte[] oriVal = cipher.doFinal(decodeStr);
			
			return new String (oriVal);
		}
	
	
	
	
	

}
