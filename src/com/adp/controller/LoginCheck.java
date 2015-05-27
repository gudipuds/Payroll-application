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
import com.adp.dao.AdminDAO;
import com.adp.data.Admin;


public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(LoginCheck.class);

	RequestDispatcher rs;
	ConnectionFactory conf ;
	AdminDAO admin;
	boolean ans ;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nm = request.getParameter("nm");
		String pwd = request.getParameter("pwd");
		response.setContentType("text/html");
		
		if(nm == null || pwd == null){
			response.sendRedirect("index") ;
		}
		else {
			
			HttpSession hs = request.getSession() ;
			hs.setAttribute("snm",nm);
			hs.setAttribute("pwd",pwd);
		    conf = new ConnectionFactory();
	    	try {
	    		
		    	admin = new AdminDAO(conf) ;
		    	Admin adm = new Admin(nm,pwd) ;
		    	log.debug("Verified admin  [ Name = " + nm + "]");
		    	hs.setAttribute("sconf", conf) ;
		    	hs.setAttribute("admin", adm);
			    ans = admin.validateLogin(adm) ;
		    	if(ans == true){
		    		response.sendRedirect("Home.view");
					log.info( "User '" + nm +"' Login Successfully .");
		    	}
		    	else {
					response.sendRedirect("index");
					log.info("Login Failed for User '"+ nm + "' .");

		    	}
	    	  } catch(NullPointerException e){
	        		log.error("Null Pointer Exception Raised");
	    	  }	catch (ClassNotFoundException e) {
	        		log.error("Class Not Found Exception Raised");
	          } catch (SQLException e) {
	        	  	log.error("SQL Exception Raised");
		      } catch (NamingException e) {
		    	  	log.error("Naming Exception Raised");
		      }
	 
	    	
	    	
		}
	}
}