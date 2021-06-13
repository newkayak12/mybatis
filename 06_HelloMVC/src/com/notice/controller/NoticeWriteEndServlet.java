package com.notice.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.servlet.*;

import com.notice.model.service.*;
import com.notice.model.vo.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

/**
 * Servlet implementation class NoticeWirteEndServlet
 */
@WebServlet("/notice/noticeWriteend")
public class NoticeWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Notice n = new Notice();
		
//		String title = request.getParameter("noticeTitle");
//		String writer = request.getParameter("noticeWriter");
//		String filePath = request.getParameter("up_file");
//		String content = request.getParameter("content");
//		n.setNoticeTitle(title);
//		n.setNoticeWriter(writer);
//		n.setFilepath(filePath);
//		n.setNoticeContent(content);
//		
		
//		파일 업로드 처리하기 위해 cos.jar라는 라이브러리에서 제공항하는 클래스를 이용
//		cos.jar의 multipartrequest를 이용함
//		1. 일단 파일이 바이너리 파일로 넘어왔는지(multipart형식인지) 확인하기
		
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			//잘못된 요청이기 때문에 
			request.setAttribute("msg", "알 수 없는 오류");
			request.setAttribute("loc", "/views/notice/noticelist");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		} 
		
//		2.파일 업로드 처리를 위해 필요한 값을 설정하기
//			1) 파일 업로드 위치 > 절대 경로로 가져와야함 
		String path = request.getServletContext().getRealPath("/upload/notice/");
		System.out.println("real path : "+path);
//			2) 저장할 파일에 대한 최대 크기를 설정
		int maxSize = 1024*1024*10;
//			3) 문자열에 대해서 인코딩처리를 해야함 
		String encode  = "utf-8";
//			4) 업로드된 파일에 대해서 이름 재정의(rename)
//			> 개발자가 직접 작성할 수도 있고, 기본으로 제공하는 클래스가 있다. (DefaultFileRenamaPolicy)
		
//		3. 파일 업로드
//			MultipartRequest클래스를 생성 > request로 전송된 데이터가 지정한 경로에 저장이 된다. 
//			MultipartRequest클래스는 생성자는 5개의 매개변수를 받는다. 
//				1.HttpServletRequest
//				2.파일 경로
//				3.파일 최대 크기
//				4.인코딩
//				5.rename 규칙
		
		
		MultipartRequest mr = new MultipartRequest(request,path,maxSize,encode,new DefaultFileRenamePolicy());
		n.setNoticeTitle(mr.getParameter("noticeTitle"));
		n.setNoticeWriter(mr.getParameter("noticeWriter"));
		n.setNoticeContent(mr.getParameter("content"));
		n.setFilepath(mr.getFilesystemName("up_file"));
		System.out.println(mr.getFilesystemName("up_file"));
		
//		4. 파일 명을 DB에 저장하기		
//		rename된 파일을 가져오려면 n.setFilePath(mr.getFileSystemName("up_file"))
		
		int result = new  NoticeService().noticeWrite(n);
		
		
		String loc = "";
		String msg = "";
			if(result>0) {
				loc = "/notice/noticelist";
				msg = "작성에 성공했습니다.";
			
			} else {
				loc = "/notice/noticeForm";
				msg = "작성에 실패했습니다.";
				
			}
			
			
		request.setAttribute("loc", loc);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
