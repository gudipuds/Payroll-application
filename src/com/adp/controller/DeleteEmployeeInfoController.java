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
import com.adp.dao.EmployeeInfoDAO;

/**
 * Servlet implementation class DeleteEmployeeInfoController
 */
public class DeleteEmployeeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DeleteEmployeeInfoController.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeInfoController() {
        super();
      
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException {
    	boolean ans;
    	ConnectionFactory confactory;
    	confactory = new ConnectionFactory();
        EmployeeInfoDAO employeeinfodao=new EmployeeInfoDAO(confactory);
    	String employeeCode=request.getParameter("empcode");
    	
    	
       
    	 ans=employeeinfodao.deleteEmployeeInfo(employeeCode);
         if(ans){
			log.info("Employee Info Record Deleted.");
        	 RequestDispatcher rd= request.getRequestDispatcher("");
             rd.forward(request, response); 
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
			e.printStackTrace();
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
			e.printStackTrace();
		} catch (SQLException e) {
			log.error("SQL Exception Raised");
		} catch (NamingException e) {
			log.error("Naming Exception Raised");
		} catch (IOException e) {
			log.error("IO Exception Raised");
		}
    	
	}
	}
	
	
