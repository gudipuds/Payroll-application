package com.adp.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.text.DateFormat;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EmployeeInfoDAO;
import com.adp.data.EmployeeInfo;

/**
 * Servlet implementation class UpdateEmployeeInfoController
 */
public class UpdateEmployeeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(UpdateEmployeeInfoController.class);
	  SimpleDateFormat formatter;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeInfoController() {
        super();
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException, ParseException {
    	boolean ans;
    	ConnectionFactory confactory;
    	confactory = new ConnectionFactory();

    	formatter = new SimpleDateFormat("dd-MM-yyyy");

    	DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

        EmployeeInfoDAO employeeinfodao=new EmployeeInfoDAO(confactory);
    	String employeeCode=request.getParameter("empcode");
    	String lastName=request.getParameter("lastname");
    	String middleName=request.getParameter("middlename");
        String firstName=request.getParameter("firstname");
        String title=request.getParameter("title");

      
		Date birthDate=(Date)formatter.parse(request.getParameter("birthdate"));

      

        String gender=request.getParameter("gender");
    	String maritalStatus=request.getParameter("maritalstatus");
    	String nationality=request.getParameter("nationality");
    	String addLn1=request.getParameter("addln1");
    	String addLn2=request.getParameter("addln2");
    	String town=request.getParameter("town");
    	String state=request.getParameter("state");
        String postCode=request.getParameter("postcode");
        String phone=request.getParameter("phone");
    	
        EmployeeInfo employeeinfo=new EmployeeInfo(employeeCode,lastName,middleName, firstName, title, birthDate,gender,maritalStatus,nationality,addLn1,addLn2,town,state,postCode,phone);
    	 ans=employeeinfodao.UpdateEmployeeInfo(employeeinfo);
         if(ans){
        	 log.info("Emoloyee [ eeCode =  "  + employeeCode + " ] Info Updated ");
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
		} catch (ParseException e) {
			log.error("Parse Exception Raised");

		}
	}

}
