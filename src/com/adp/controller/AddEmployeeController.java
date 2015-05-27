package com.adp.controller;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EmployeeInfoDAO;
import com.adp.data.EmployeeInfo;


public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DateFormat formatter;
	static Logger log = Logger.getLogger(AddEmployeeController.class);

    
    public AddEmployeeController() {
        super();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException, ParseException {
    	boolean ans;
    	ConnectionFactory confactory;
    	formatter = new SimpleDateFormat("dd-mm-yyyy");

    	DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

    	confactory = new ConnectionFactory();
        EmployeeInfoDAO employeeinfodao=new EmployeeInfoDAO(confactory);
    	String employeeCode=request.getParameter("empCode");
    	String lastName=request.getParameter("lastName");
    	String middleName=request.getParameter("middleName");
        String firstName=request.getParameter("firstName");
        String title=request.getParameter("title");
        Date birthDate=(Date)formatter.parse(request.getParameter("birthDate"));
        String gender=request.getParameter("gender");
    	String maritalStatus=request.getParameter("maritalStatus");
    	String nationality=request.getParameter("nationality");
    	String addLn1=request.getParameter("addln1");
    	String addLn2=request.getParameter("addln2");
    	String town=request.getParameter("town");
    	String state=request.getParameter("state");
        String postCode=request.getParameter("postcode");
        String phone=request.getParameter("phone");
    	
        
        EmployeeInfo employeeinfo=new EmployeeInfo(employeeCode,lastName,middleName, firstName, title, birthDate,gender,maritalStatus,nationality,addLn1,addLn2,town,state,postCode,phone);
    	 ans=employeeinfodao.insertEmployeeInfo(employeeinfo);
         log.debug("processRequest() : Created employee [ EmployeeCode = " + employeeCode +" ]");
         if(ans){
        	 response.sendRedirect("Home.view");
			 log.info("New Employee Added [ EmployeeCode = " + employeeCode +" ] in Database");

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

}
