package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.BusinessUnitDAO;
import com.adp.dao.ConnectionFactory;
import com.adp.data.BusinessUnit;


public class BusinessUnitDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	static Logger log = Logger.getLogger(BusinessUnitDetails.class);

	ConnectionFactory conf;   
    BusinessUnitDAO businessunitdao;
    boolean ans;
	DateFormat formatter;

    public BusinessUnitDetails() {
       
    }

	
    
    private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {

    	String buCode = request.getParameter("bu");
		String name = request.getParameter("nm");
		Date effectiveFrom = (Date)formatter.parse(request.getParameter("wef"));
		Date effectiveTo = (Date)formatter.parse(request.getParameter("wet"));
		String buType = request.getParameter("type");
		String buParent = request.getParameter("bup");

		conf = new ConnectionFactory();
    	
		try {
			businessunitdao = new BusinessUnitDAO(conf); 
			
			BusinessUnit businessunit = new BusinessUnit(buCode, name, effectiveFrom, effectiveTo, buType, buParent) ;
			ans = businessunitdao.insert(businessunit);
			
			
			if(ans == true)
				response.sendRedirect("#");
			else
				response.sendRedirect("#");
			
			
		
			} catch (ClassNotFoundException e) {
				log.error("Class Not Found Exception Raised in BusinessUnitDetails.java");
				e.printStackTrace();
			} catch (SQLException e) {
				log.error("SQL Exception Raised BusinessUnitDetails.java");
			} catch (NamingException e) {
				log.error("Naming Exception Raised BusinessUnitDetails.java");
			} catch (IOException e) {
				log.error("IO Exception Raised BusinessUnitDetails.java");
			}
    	
    	
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			log.error("Parse Exception Raised BusinessUnitDetails.java");

		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			log.error("Parse Exception Raised BusinessUnitDetails.java");

		}
	}

}
