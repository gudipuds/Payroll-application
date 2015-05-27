package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EmpLoginDAO;
import com.adp.dao.EmployeeInfoDAO;
import com.adp.data.EmpLogin;
import com.adp.data.EmployeeInfo;

public class EmpLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmpLoginCheck.class);
	RequestDispatcher rs;
	ConnectionFactory conf ;
	EmpLoginDAO elogin;
	boolean ans ;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empCode = request.getParameter("nm");
		String pwd = request.getParameter("pwd");
		response.setContentType("text/html");
		
		if(empCode == null || pwd == null){
			response.sendRedirect("index") ;
		}
		else {
			HttpSession hs = request.getSession() ;
			hs.setAttribute("eCode",empCode);
			hs.setAttribute("ePwd",pwd);
			conf = new ConnectionFactory();
	    	try {
	    		EmployeeInfoDAO edao = new EmployeeInfoDAO(conf);
	    		EmployeeInfo einfo = edao.getEmployeeInfoByCode(empCode);
	    		hs.setAttribute("einfo", einfo);
	    		System.out.println(einfo.getAddLn1()+einfo.getEmployeeCode());
		    	elogin = new EmpLoginDAO(conf) ;
		    	EmpLogin e = new EmpLogin(empCode,pwd);
		    	hs.setAttribute("sconf", conf) ;
		    	hs.setAttribute("emplogin", e);
			    ans = elogin.validateLogin(e) ;
			
		    	if(ans == true)
		    	{
		    			response.sendRedirect("EmpHome.view");
						log.info( "Employee [" + empCode +"] Login Successfully !");


		    	}
		    	else 
		    	{
					response.sendRedirect("index");
					log.info( "Employee [" + empCode +"] Login Failed !");

		     	}
		    	
		        } 
	    		catch (ClassNotFoundException e) 
	    		{
					log.error("Class Not Found Exception Raised");
				}
	    		catch (SQLException e) {
					log.error("SQL Exception Raised");
				}
	    		catch (NamingException e) {
					log.error("Naming Exception Raised");
				}
	    		catch (IOException e) {
					log.error("IO Exception Raised");
				}
		
	}
	}

}
