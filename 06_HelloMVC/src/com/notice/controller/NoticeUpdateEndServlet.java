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
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet("/notice/noticeupdateend")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "잘못된 접근 방식입니다!");
			request.setAttribute("loc", "/notice/noticeupdate?no="+request.getParameter("noticeNo"));
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = request.getServletContext().getRealPath("/upload/notice/");
		int maxSize = 1024*1024*10;
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		
		Notice n= new Notice();
		n.setNoticeTitle(mr.getParameter("noticeTitle"));
		n.setNoticeWriter(mr.getParameter("noticeWriter"));
		n.setNoticeContent(mr.getParameter("content"));
		
		String filePath = mr.getFilesystemName("up_file");
		//파일이 있는지 없는지 확인부터 해야겠지
		//file객체를 이용한다.
		File f= mr .getFile("up_file");
		//f가 null이거 file.length()가 0이면 파일이 없다.
		// !를 붙이면 반대의 경우가 되겠지
		if(f!= null&&f.length()>0) {
			//파일이 있음
			//이전 파일 지워줌
			File deletefile = new File(path+mr.getParameter("oriFile"));
				
				if(deletefile.exists()) {
					
					deletefile.delete();
				}
				
		}else {
			filePath = mr.getParameter("oriFile");
		}
		
		
		n.setFilepath(filePath);
		n.setNoticeNo(Integer.parseInt(mr.getParameter("noticeNo")));
		
		int result =new NoticeService().noticeUpdate(n);
		String msg = "";
		String loc = "";
		if(result>0) {
			msg="수정 성공";
			loc = "/notice/noticelist";
		} else {
			msg="수정 실패";
			loc = "/notice/noticeupdate?no="+n.getNoticeNo();
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
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
