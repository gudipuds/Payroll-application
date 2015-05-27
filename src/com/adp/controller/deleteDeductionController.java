package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.DeductionDao;

/**
 * Servlet implementation class deleteDeductionController
 */
public class deleteDeductionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(deleteDeductionController.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteDeductionController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException {
    
    	boolean ans;
    	ConnectionFactory conFactory = new ConnectionFactory();
        DeductionDao ddao = new DeductionDao(conFactory);
    	String dedCode=request.getParameter("eCode");
    	ans=ddao.deleteDeduction(dedCode);
    	if(ans)
    	{
    		response.sendRedirect("Home.view");
			log.info("Deduction Record Deleted");

    	}
    	else
    	{
    		response.sendRedirect("DeleteDeduction.view");
			log.info("Deduction Record Deletion Failed");

    	}
    	
    
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
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
			processRequest(request, response);
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
