package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.DeductionDao;
import com.adp.data.Deduction;

/**
 * Servlet implementation class deleteDeductionController
 */
public class getDeductionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(getDeductionController.class);
    
    public getDeductionController() {
        super();
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException {
    
    	ConnectionFactory conFactory = new ConnectionFactory();
        DeductionDao ddao = new DeductionDao(conFactory);
    	String dedCode=request.getParameter("name");
    	   	
    	Deduction ded = ddao.getDedCodeById(dedCode);
    	request.setAttribute("obj", ded);
    	request.getRequestDispatcher("UpdateDeduction.view").forward(request, response);
    	
    
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
