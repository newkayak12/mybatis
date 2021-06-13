package com.common.filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet Filter implementation class PasswordEncryptFilter
 */

//필터링 기준은 꼭 주소 매핑뿐만 아니라 Servlet이름으로도 가능하다고 했음
@WebFilter(servletNames = {"loginservlet", "memberupdateservlet", "enrollendservet", "updatePasswordEnd", "passwordUpdate","ajaxMember" })
public class PasswordEncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PasswordEncryptFilter() {
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
		
		PasswordEncryptWrapper pew = new PasswordEncryptWrapper((HttpServletRequest)request);
		
		chain.doFilter(pew, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
