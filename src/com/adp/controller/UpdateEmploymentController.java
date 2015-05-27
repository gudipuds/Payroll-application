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

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EmployeeInfoDAO;
import com.adp.dao.EmploymentDAO;
import com.adp.data.EmployeeInfo;
import com.adp.data.Employment;

/**
 * Servlet implementation class UpdateEmploymentController
 */
public class UpdateEmploymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  DateFormat formatter;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmploymentController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException, ParseException {
    	boolean ans;
    	ConnectionFactory confactory;
    	formatter = new SimpleDateFormat("dd-mm-yyyy");
    	

    	DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

    	confactory = new ConnectionFactory();
        EmploymentDAO edao=new EmploymentDAO(confactory);
    	String empCode=request.getParameter("empCode");
    	Date emplHireDate= (Date)formatter.parse(request.getParameter("empHireDate"));
    	Date emplTermDate = (Date)formatter.parse(request.getParameter("empTermDate"));
		String eeStatus = request.getParameter("eStatus");
		String fullPartTime = request.getParameter("fullPart");
		String permanentTemp =request.getParameter("perTemp");
		String leavingReason = request.getParameter("reason");
		int noticePeriod =Integer.parseInt(request.getParameter("noticePeriod"));
		String noticePeriodUnit = request.getParameter("noticePeriodUnit");
		int probPeriod =Integer.parseInt(request.getParameter("probPeriod"));
		String probPeriodUnit =  request.getParameter("probPeriodUnit");
		String payFrequency =  request.getParameter("payFrequency");
		String employerCode =  request.getParameter("employerCode");
        Employment employment= new Employment(empCode,emplHireDate,emplTermDate,eeStatus,fullPartTime,permanentTemp,leavingReason, noticePeriod,noticePeriodUnit,probPeriod,probPeriodUnit,payFrequency,employerCode);
       
    	
     
    	 ans=edao.updateEmployment(employment);
         if(ans){
        	 response.sendRedirect("Home.view");
        	
         }
         
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
