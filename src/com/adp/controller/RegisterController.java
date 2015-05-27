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
import com.adp.data.EmpLogin;


public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(RegisterController.class);
	RequestDispatcher rs;
	ConnectionFactory conf ;
	EmpLoginDAO elogin;
	boolean ans;
       
    public RegisterController() {
        super();
    }

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
			elogin = new EmpLoginDAO(conf);
			EmpLogin emp = new EmpLogin(nm,pwd) ;
			ans = elogin.createAccount(emp) ;
			log.info("Employee [Name = " + nm + "] Created");
			
			if(ans == true) {
				HttpSession hs = request.getSession();
				hs.setAttribute("eCode", nm);
				hs.setAttribute("ePwd", pwd);
				hs.setAttribute("emplogin", emp);
				response.sendRedirect("EmpHome.view");
				log.info("New Employee [ " + nm + " ]  Registered in Database");

			}
			else {
				response.sendRedirect("empLogin");
			}
		} catch (ClassNotFoundException e) {
			log.error("Class Not Found Exception Raised");
		} catch (SQLException e) {
			log.error("SQL Exception Raised");
		} catch (NamingException e) {
			log.error("Naming Exception Raised");
		} catch (IOException e) {
			log.error("IO Exception Raised");
		}
	}

}
