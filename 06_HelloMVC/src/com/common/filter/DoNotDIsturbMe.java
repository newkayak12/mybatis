package com.common.filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.member.model.vo.*;

/**
 * Servlet Filter implementation class DoNotDIstubMe
 */
@WebFilter(filterName = "/DoNotDIstubMe", servletNames = {"memberupdateservlet", "memberViewServ"})
public class DoNotDIsturbMe implements Filter {

    /**
     * Default constructor. 
     */
    public DoNotDIsturbMe() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
//		DoNotDisturbMeWrapper dndall =  new DoNotDisturbMeWrapper((HttpServletRequest)request);
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpSession session = rq.getSession(false);
		
		Member m = (Member) session.getAttribute("loginMember");
		
			if(m!=null) {
					
				chain.doFilter(request, response);
				
			} else {
				
				rq.setAttribute("msg", "invalid Access!");
				rq.setAttribute("loc", "/");
				rq.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);;
				
				
			}
		
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
