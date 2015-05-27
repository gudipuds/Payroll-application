package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.BusinessUnitDAO;
import com.adp.dao.ConnectionFactory;
import com.adp.data.BusinessUnit;

public class BusinessUnitOptionController {

 	static Logger log = Logger.getLogger(BusinessUnitOptionController.class);

	
		ConnectionFactory conf;   
	    BusinessUnitDAO businessunitdao;
	    boolean ans;
	    
	    public BusinessUnitOptionController() {
	       
	    }

		
	    
	    private void processRequest(HttpServletRequest request,
				HttpServletResponse response) {
			DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
	    	
			try {
			String buCode = request.getParameter("bu");
			String name = request.getParameter("nm");
			Date effectiveFrom = (Date)formatter.parse(request.getParameter("wef"));
			Date effectiveTo = (Date)formatter.parse(request.getParameter("wet"));
			String buType = request.getParameter("type");
			String buParent = request.getParameter("bup");

			conf = new ConnectionFactory();

			
				businessunitdao = new BusinessUnitDAO(conf); 
				
				BusinessUnit businessunit = new BusinessUnit(buCode, name, effectiveFrom, effectiveTo, buType, buParent) ;
				ans = businessunitdao.insert(businessunit);

				
				if(ans == true)
				{
					log.info("New Business unit added.");
					response.sendRedirect("Home.view");
				}
				else
				{
					
				}
				
			} catch (ClassNotFoundException e) {
				log.error("Class Not Found Exception Raised in BusinessUnitOptionController ");
				e.printStackTrace();
			} catch (SQLException e) {
				log.error("SQL Exception Raised in BusinessUnitOptionController");
			} catch (NamingException e) {
				log.error("Naming Exception Raised in BusinessUnitOptionController");
			} catch (IOException e) {
				log.error("IO Exception Raised in BusinessUnitOptionController");
			} catch (java.text.ParseException e) {
				log.error("Parse Exception Raised in BusinessUnitOptionController");
			}
	    	
	    	
	    	
		}
	    
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}

		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}

	}

	

