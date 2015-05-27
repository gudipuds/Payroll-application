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

import com.adp.dao.BusinessUnitDAO;
import com.adp.dao.ConnectionFactory;
import com.adp.data.BusinessUnit;


public class BusinessUnitDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	static Logger log = Logger.getLogger(BusinessUnitDetailsController.class);

	ConnectionFactory conf;   
    BusinessUnitDAO businessunitdao;
    boolean ans;
    
    public BusinessUnitDetailsController() {
       
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
				log.info("New Business unit [buCode = " + buCode + "] added.");
				response.sendRedirect("Home.view");
			}
			else
			{
				
			}
			
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
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
