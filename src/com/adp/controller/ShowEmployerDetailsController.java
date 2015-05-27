package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EmployerDAO;
import com.adp.data.Employer;


public class ShowEmployerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession hs;
	static Logger log = Logger.getLogger(ShowEmployerDetailsController.class);
    
    public ShowEmployerDetailsController() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
    
    	ConnectionFactory conFactory = new ConnectionFactory();
		EmployerDAO edao = new EmployerDAO(conFactory);
		Employer employer = edao.showAllDetails();
		System.out.println(employer.getEmployerCode());
		hs = request.getSession();
		hs.setAttribute("emp", employer);
		
		response.sendRedirect("showEmployer.view");
		
		
		
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
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
