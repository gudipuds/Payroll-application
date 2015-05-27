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
import com.adp.dao.EmployerDAO;
import com.adp.data.Employer;


public class EmployerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DateFormat formatter;
	static Logger log = Logger.getLogger(EmployerDetailsController.class);
    
    public EmployerDetailsController() {
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

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException, ParseException {
		formatter = new SimpleDateFormat("dd-mm-yyyy");
		
		String erCode = request.getParameter("erCode");
		String erName = request.getParameter("erName");
		Date startDate = (Date)formatter.parse(request.getParameter("startDate"));
		Date endDate = (Date)formatter.parse(request.getParameter("endDate"));
		String addrline1 = request.getParameter("addrline1");
		String addrline2 = request.getParameter("addrline2");
		String addrline3 = request.getParameter("addrline3");
		String town = request.getParameter("town");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String postcode = request.getParameter("postcode");
		String phone = request.getParameter("phone");
		
		ConnectionFactory conFactory = new ConnectionFactory();
		EmployerDAO adao = new EmployerDAO(conFactory);
		Employer employer = new Employer(erCode, erName, startDate, endDate, addrline1, addrline2, addrline3, town, state, country, postcode, phone);
        
		if(adao.insertEmployer(employer))
        {
        	response.sendRedirect("Home.view");
			log.info("Employer Record Added in Database");

        }
        else
        {
        	
        }

	}
}
