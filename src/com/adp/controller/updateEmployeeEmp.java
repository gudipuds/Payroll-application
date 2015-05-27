package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EmployeeInfoDAO;
import com.adp.data.EmployeeInfo;


public class updateEmployeeEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(UpdateEmpDetailsController.class);
    DateFormat formatter;
  
  
    public updateEmployeeEmp() {
        super();
    }

	
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		}catch (ClassNotFoundException e) {
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
	
	private void processRequest(HttpServletRequest request,	HttpServletResponse response) throws ParseException, ClassNotFoundException, SQLException, NamingException, IOException {
    	formatter = new SimpleDateFormat("dd-mm-yyyy");

		String eeCode = request.getParameter("eeCode");
    	String lastName=request.getParameter("lastName");
    	String middleName=request.getParameter("middleName");
        String firstName=request.getParameter("firstName");
        String title=request.getParameter("title");
        System.out.println(request.getParameter("birthDate"));
       // System.out.println((Date)formatter.parse(request.getParameter("birthDate")));
        Date birthDate = (Date)formatter.parse(request.getParameter("birthDate"));
        String gender=request.getParameter("gender");
    	String maritalStatus=request.getParameter("maritalStatus");
    	String nationality=request.getParameter("nationality");
    	String addLn1=request.getParameter("addrline1");
    	String addLn2=request.getParameter("addrline2");
    	String town=request.getParameter("town");
    	String state=request.getParameter("state");
        String postCode=request.getParameter("postcode");
        String phone=request.getParameter("phone");
        
		 ConnectionFactory conFactory = new ConnectionFactory();
		 EmployeeInfoDAO edao = new EmployeeInfoDAO(conFactory);
		 EmployeeInfo empinfo = new EmployeeInfo(eeCode, lastName, middleName, firstName, title, birthDate, gender, maritalStatus, nationality, addLn1, addLn2, town, state, postCode, phone);
		 
		 if(edao.UpdateEmployeeInfo(empinfo))
		 {
			 response.sendRedirect("EmpHome.view");
        	 log.info("Emoloyee [eeCode = " + eeCode + "]Info Updated ");

		 }
		 else
		 {
			 
		 }
	}
}
