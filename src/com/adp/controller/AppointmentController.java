package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

import com.adp.dao.AppoinmentDAO;
import com.adp.dao.ConnectionFactory;
import com.adp.data.Appointment;

public class AppointmentController {
	
	
     	static Logger log = Logger.getLogger(AppointmentController.class);

		ConnectionFactory conf;   
	    AppoinmentDAO appoinmentdao;
	    boolean ans;
	    
	    public AppointmentController() {
	       
	    }

		
	    
	    private void processRequest(HttpServletRequest request,
				HttpServletResponse response) {
			DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
	    	
			try {
			String eCode = request.getParameter("ec");
			String apptNo = request.getParameter("an");
			Date effectiveFrom = (Date)formatter.parse(request.getParameter("wef"));
			Date effectiveTo = (Date)formatter.parse(request.getParameter("wet"));
			String bucode = request.getParameter("bc");
			String jobcode = request.getParameter("jc");
			String positionId = request.getParameter("pid");
			String reportsTo = request.getParameter("rt");

			
			
			conf = new ConnectionFactory();

			
				appoinmentdao = new AppoinmentDAO(conf); 
				
				Appointment appointment = new Appointment(eCode,apptNo,effectiveFrom , effectiveTo,bucode,jobcode,positionId,reportsTo);
				log.debug("Created  Appointment Ecode = " + eCode);
				ans = appoinmentdao.insertAppoinment(appointment);

				
				if(ans == true)
				{
					response.sendRedirect("Home.view");
					log.info("Appointment [Ecode = " + eCode+ "] Stored in Database !");

				}
				else
				{
					
				}
				
			} catch (ClassNotFoundException e) {
				log.error("Class Not Found Exception Raised ");
			} catch (SQLException e) {
				log.error("SQL Exception Raised ");
			} catch (NamingException e) {
				log.error("Naming Exception Raised ");
			} catch (IOException e) {
				log.error("IO Exception Raised ");
			} catch (java.text.ParseException e) {
				log.error("Parse Exception Raised ");
				 
			}
	    	
	    	
	    	
		}
	    
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}

		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}

	}


