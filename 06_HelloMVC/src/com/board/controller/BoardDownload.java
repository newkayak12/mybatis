package com.board.controller;

import java.io.*;
import java.net.*;import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.service.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

/**
 * Servlet implementation class BoardDownload
 */
@WebServlet("/board/boarddownload")
public class BoardDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oriname = request.getParameter("oriname");
		String rename = request.getParameter("rename");
		
		
		
		
		
		String path = request.getServletContext().getRealPath("/upload/board/");
		
		
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path+rename));
		String fileRename = " ";
		String checkMSIE = request.getHeader("user-agent");
		boolean isMSIE = checkMSIE.indexOf("MSIE") != -1 || checkMSIE.indexOf("Trident") !=-1;
		
		if(isMSIE) {
			
			fileRename = URLEncoder.encode(oriname,"utf-8").replaceAll("\\+", "%20");
		} else {
			
			fileRename = new String(oriname.getBytes("utf-8"),"ISO-8859-1");
		}
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;fileName="+fileRename);
		
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		int read = -2;
		while((read= bis.read())!=-1) {
			bos.write(read);
		}
		
		
	
	
//	6. 모든 스트림 닫기
	
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
