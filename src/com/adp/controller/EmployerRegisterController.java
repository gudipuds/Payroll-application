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

import com.adp.dao.AdminDAO;
import com.adp.dao.ConnectionFactory;
import com.adp.data.Admin;


public class EmployerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(RegisterController.class);
	RequestDispatcher rs;
	ConnectionFactory conf ;
	boolean ans;
	AdminDAO admin;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nm = request.getParameter("nm");
		String pwd = request.getParameter("pwd");
		
		conf = new ConnectionFactory();
		try {
			admin = new AdminDAO(conf);
			Admin a = new Admin(nm,pwd);
			ans = admin.createEmployer(a);
			if(ans == true){
				HttpSession hs = request.getSession() ;
				hs.setAttribute("snm",nm);
				hs.setAttribute("pwd",pwd);
				hs.setAttribute("sconf", conf) ;
		    	hs.setAttribute("admin", a);
		    	response.sendRedirect("employerDetails.view");
			}
			else
				response.sendRedirect("index");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
