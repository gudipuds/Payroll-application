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
import com.adp.dao.EeEarningDao;
import com.adp.data.EeEarning;


public class EmployeeEarningController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     DateFormat formatter;  
  
    public EmployeeEarningController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException, ParseException {
    	formatter = new SimpleDateFormat("dd-mm-yyyy");
		String empCode = request.getParameter("empCode");
		System.out.println(empCode);
		String earnCode = request.getParameter("earningCode");
		System.out.println(earnCode);

		Date sDate = (Date)formatter.parse(request.getParameter("sDate"));
		Date eDate = (Date)formatter.parse(request.getParameter("eDate"));
		Double amount = Double.valueOf(request.getParameter("amount"));
		String status = request.getParameter("status");
		
		 ConnectionFactory conFactory = new ConnectionFactory();
		 EeEarningDao edao = new EeEarningDao(conFactory);
		 EeEarning eeEarning = new EeEarning(empCode, earnCode, sDate, eDate, status, amount);
		 if(edao.addEeEarning(eeEarning))
		 {
			 response.sendRedirect("Home.view");
		 }
		 else
		 {
			 
		 }
	}

}
