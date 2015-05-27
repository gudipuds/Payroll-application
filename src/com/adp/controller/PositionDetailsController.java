package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.BusinessUnitDAO;
import com.adp.dao.ConnectionFactory;
import com.adp.dao.JobDAO;
import com.adp.dao.PositionDAO;
import com.adp.data.Position;


public class PositionDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(PositionDetailsController.class);
    public PositionDetailsController() {
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
		} 
		
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
		String buName = request.getParameter("buName");
		String jobTitle = request.getParameter("jobTitle");
		String posId = request.getParameter("posId");
		String posTitle = request.getParameter("posTitle");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String posStatus = request.getParameter("posStatus");
		
		ConnectionFactory conFactory = new ConnectionFactory();
		BusinessUnitDAO budao = new BusinessUnitDAO(conFactory);
		JobDAO jdao = new JobDAO(conFactory);
		String buCode = budao.getBuCodeByName(buName);
		String jobCode = jdao.getJobCodeByTitle(jobTitle);
		PositionDAO pdao = new PositionDAO(conFactory);
		Position position = new  Position(posId, posTitle, startDate, endDate, posStatus, jobCode, buCode);
		
		if(pdao.insert(position))
		{
		}
		else
		{
		
		}
		



		
	}

}
