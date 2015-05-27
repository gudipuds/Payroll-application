package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EmployeeInfoDAO;


public class deleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(deleteEmployeeController.class);
    
    public deleteEmployeeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			log.error("Class Not Found Exception Raised");
			e.printStackTrace();
		} catch (SQLException e) {
			log.error("SQL Exception Raised");
		} catch (NamingException e) {
			log.error("Naming Exception Raised");
		} catch (IOException e) {
			log.error("IO Exception Raised");
		} catch (ParseException e) {
			log.error("Parse Exception Raised");

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			log.error("Class Not Found Exception Raised");
			e.printStackTrace();
		} catch (SQLException e) {
			log.error("SQL Exception Raised");
		} catch (NamingException e) {
			log.error("Naming Exception Raised");
		} catch (IOException e) {
			log.error("IO Exception Raised");
		} catch (ParseException e) {
			log.error("Parse Exception Raised");

		}
		
	}
	
	private void processRequest(HttpServletRequest request,	HttpServletResponse response) throws ParseException, ClassNotFoundException, SQLException, NamingException, IOException {
		 String ecode = request.getParameter("ecode");
		 ConnectionFactory conFactory = new ConnectionFactory();
		 EmployeeInfoDAO edao = new EmployeeInfoDAO(conFactory);
		 if(edao.deleteEmployeeInfo(ecode))
		 {
			 response.sendRedirect("Home.view");
			 log.info("Employee Info Record Deleted");
		 }
		 else
		 {
			 
		 }
	}

}
