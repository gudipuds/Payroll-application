package com.adp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PerformanceFilter implements Filter {


	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long begin;
		long end;
		long timeTaken;
		
		begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		end = System.currentTimeMillis();
		
		timeTaken = end - begin;
		
		System.out.println(((HttpServletRequest)request).getRequestURL() + " Time taken: " +timeTaken);
		
	}

	public void init( FilterConfig config) throws ServletException {
		
	}
}