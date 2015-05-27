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
import com.adp.dao.EarningDao;
import com.adp.data.Earning;



	public class EditEarningDefinitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EditEarningDefinitionController.class);


    public EditEarningDefinitionController() {
        super();
       

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
	
		
    	boolean ans=false;
		DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
    	
		try {
		String earnCode = request.getParameter("earnCode");
		String earnDesc = request.getParameter("earnDesc");
		Date earnStartDate = (Date)formatter.parse(request.getParameter("earnStartDate"));
		Date earnEndDate = (Date)formatter.parse(request.getParameter("earnEndDate"));
		String earnTaxability = request.getParameter("earnTaxability");
		double earnDfltAmount =Double.valueOf(request.getParameter("earnDfltAmount"));

		ConnectionFactory conf = new ConnectionFactory();
		EarningDao earningdao = new EarningDao(conf); 
			
		
		
		Earning earning= new Earning(earnCode, earnDesc, earnStartDate, earnEndDate, earnTaxability, earnDfltAmount);
			ans=earningdao.updateEarning(earning);
			if(ans == true)
			{
				response.sendRedirect("Home.view");
				log.info( "Earning Defination Record Updated !");

			}
			else
			{
				
			}
			
		} catch (ClassNotFoundException e) {
			log.error("Class Not Found Exception Raised");
		} catch (SQLException e) {
			log.error("SQL Exception Raised");
		} catch (NamingException e) {
			log.error("Naming Exception Raised");
		} catch (ParseException e) {
			log.error("IO Exception Raised");				}
    	
    	
		
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
		}
    	
	
	}

	
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
