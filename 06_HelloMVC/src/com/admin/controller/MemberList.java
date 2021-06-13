package com.admin.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.admin.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/admin/memberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//관리자 아닌 사람 접근에 예외처리
		HttpSession session = request.getSession(false);
		Member loginMember = (Member) session.getAttribute("loginMember");
				if((session == null) || loginMember== null || !loginMember.getUserId().equals("admin")){
					
//					잘못된 접근입니다.
					request.setAttribute("msg", "잘못된 접근입니다.");
					request.setAttribute("loc", "/");
					
					request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
					
					
					
				} else {
					
					 
		               /*  
		                 데이터를 가져올 떄 원하느 구역 가져오기 
		                 
		                 1. 사용자가 원하는 page(현재 페이지)를 가져와야한다.
		                 
		                */
		               		  int cPage = 1;
		                  /* 2. 페이지당 데이터수  _ 사용자가 설정 */
				               		  try {
				               			  	cPage = Integer.parseInt(request.getParameter("cPage"));
				               			  	
				               		  } catch(NumberFormatException e) {
				               			  cPage = 1;
				               		  }
				               		  
		                   int numPerPage = 10;
		                   		
				                   		try {
				                   				numPerPage = Integer.parseInt(request.getParameter("numPerPage"));	
				                   		} catch (NumberFormatException e) {
				                   			
				                   		}
		                   		
		       System.out.println(numPerPage);             		
           	/*
           	 *  사용자가 원하는 페이지를 호출할 수 있게 pageBar를 구성해보자!
           	 *  
           	 *  1. 전체 페이지에 대한 수 : 전체 자료에서 page당 수를 나누면 됨  만약 5.5가 나오면...? 무조건 올림으로 계산 
           	 */
                
               		int totaldata = new AdminService().countMember();
               		int totalPage = (int)Math.ceil((double) totaldata/numPerPage);
               		
               		int pageBarSize = 4;  //페이지바에 한 번에 노출 될 페이지의 개수 
               		//pageNo는 pageBar에 출력되는 페이지 숫자의 시작값 
               		/* 
	               		4페이지를 기준으로 
	               		cPage가 2면 pageNo 1
	               		cPage가 3이면 pageNo 1
	               		cPage가 4이면 pageNo 1
	               		
	               		cPage가 6면 pageNo 5
	               		cPage가 9면 pageNo 9
               		*/
               		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
               		
               		/*
               		 	pageNo 1 pageEnd 4
               		 	pageNo 5 pageEnd 8
               		 	pageNo 9 pageEnd 12
               		 	
               		 */
               		
               		int pageEnd = pageNo + pageBarSize - 1;
//               		
           	 /*
           	  * pageBar 구성하기 > html 방식으로 
           	  * 
           	  * 사용자가 클릭할 수 있는 페이지 바를 구성해보자 
           	  * 
           	  *  */	
               		
               		String pageBar = "";
               		
//               		시작
               			if(pageNo == 1) {
//               				1이면 이전이 없곘죠
               				pageBar += "<span>&nbsp;&nbsp;</span>";
               				
               			} else {
               				
               				pageBar += "<a href ='"+request.getContextPath()+"/admin/memberList?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";
               			}
               			
               			
               			
//               			안의 페이지 구성
               			while(!(pageNo >pageEnd || pageNo>totalPage)) {
	               				if(cPage==pageNo) {
	               					pageBar += "<span>"+"&nbsp;&nbsp;"+pageNo+"&nbsp;&nbsp;"+"</span>";
	               					
	               				} else {
	               					pageBar+="<a href = '" + request.getContextPath()+"/admin/memberList?cPage="+pageNo+"&numPerPage=" +numPerPage+"'>"+"&nbsp;&nbsp;"+pageNo+"&nbsp;&nbsp;"+"</a>";
	               				}
               				pageNo++;
               			}
               			
//               			c 1/no 1
//               			1은 span  no++  
//               			2는 c가 2 no가 2 pp가 4   no ++  >> 이 상태에서 이 페이지로 쿼리스트링을 보내면 
//               			3은 c가 3 no가 3 pp가 4   no ++ 
               			
               			
               			
//               		끝
               			if(pageNo>totalPage) {
               				pageBar+= "<span>&nbsp;&nbsp;</span>";
               				
               			} else {
               				pageBar += "<a href ='" + request.getContextPath()+"/admin/memberList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
               			}
               			
               			
               			
               			
               			
			                   		
			             request.setAttribute("nPerPage", numPerPage);      		
			             request.setAttribute("pageBar", pageBar); 	
			             request.setAttribute("where", "MemberList");
       				List<Member> result =  new AdminService().showAllMember(cPage, numPerPage);
					request.setAttribute("list", result);
					
					
					request.getRequestDispatcher("/views/admin/memberlist.jsp").forward(request, response);
					//도착 페이지?
					
					
				} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
