package com.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.main.model.service.ReplService;
import com.main.model.vo.Repl;

/**
 * Servlet implementation class ReplAjax
 */
@WebServlet("/replajax")
public class ReplAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sort = request.getParameter("sort");
		ReplService repl = new ReplService();
		
		
			if(sort.equals("select")) {
				
				List<Repl> list = repl.select();
				Gson gson = new Gson();
				
				response.setContentType("application/json;charset=utf-8");
				gson.toJson(list,response.getWriter());
				
			} else if(sort.equals("insert")) {
				
				String content = request.getParameter("content");
				int result = repl.insert(content);
				
			} else if(sort.equals("delete")) {
				
				String seq = request.getParameter("seq");
				int result = repl.delete(seq);
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
