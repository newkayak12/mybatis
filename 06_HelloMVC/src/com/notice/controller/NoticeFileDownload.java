package com.notice.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class NoticeFileDownload
 */
@WebServlet("/notice/fileDownload")
public class NoticeFileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//파일 다운로드> 바이너리로 있는 파일을 그대로 보냄. 
		
//		1. 클라이언트가 보낸 파일 명 가져오기
		String fileName = request.getParameter("fName");
		
//	    2. 파일명이랑 일치하는 파일을 서버의 저장경로에서 가져오기> InputStream이용
		String path = request.getServletContext().getRealPath("/upload/notice/");
		path = path + fileName;
		
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
//		3. 클라이언트에게 보낼 파일명 인코딩 처리하기 > 한글 파일명이 꺠지지 않게
		String fileRName =  " ";
		String header = request.getHeader("user-agent");
		boolean isMSIE = header.indexOf("MSIE") != -1||header.indexOf("Trident")!= -1;
		
		if(isMSIE) {
			fileRName = URLEncoder.encode("fileName","utf-8").replaceAll("\\+", "%20");
		} else {
			fileRName = new String (fileName.getBytes("utf-8"),"ISO_8859_1");
		}
		
//		4. 파일에 대한 (응답)MIME타입 설정하기 / header 설정 
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;fileName="+fileRName);
		
		
//		5. 클라이언트와 연결된 스트림으로 파일 전송 
//		ServletOutputStream이라는 것이 있음
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		
		int read = -2;
			while((read= bis.read())!=-1) {
				bos.write(read);
			}
			
			
		
		
//		6. 모든 스트림 닫기
		
			bis.close();
			bos.close();
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
