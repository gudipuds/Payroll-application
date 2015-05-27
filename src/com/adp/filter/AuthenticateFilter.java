package com.adp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adp.data.*;


public class AuthenticateFilter implements Filter {

	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		 HttpServletResponse resp = (HttpServletResponse)response;
		 HttpSession hs = req.getSession();
	     Admin admin = (Admin)hs.getAttribute("admin");
	     EmpLogin elogin = (EmpLogin)hs.getAttribute("emplogin") ;
		 			 
			if( admin == null && elogin == null)
				 resp.sendRedirect("index");
			 else
				 chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
	

}
