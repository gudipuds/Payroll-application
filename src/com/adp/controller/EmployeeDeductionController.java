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
import com.adp.dao.EeDeductionDao;
import com.adp.dao.EeEarningDao;
import com.adp.data.EeDeduction;
import com.adp.data.EeEarning;

public class EmployeeDeductionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DateFormat formatter;
  
    public EmployeeDeductionController() {
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
		String dedCode = request.getParameter("deductionCode");
		Date sDate = (Date)formatter.parse(request.getParameter("sDate"));
		Date eDate = (Date)formatter.parse(request.getParameter("eDate"));
		Double amount = Double.valueOf(request.getParameter("amount"));
		String status = request.getParameter("status");
		
		 ConnectionFactory conFactory = new ConnectionFactory();
		 EeDeductionDao eddao = new EeDeductionDao(conFactory);
		 EeDeduction eeDeduction = new EeDeduction(empCode, dedCode, sDate, eDate, status, amount);
		 if(eddao.addEeDeduction(eeDeduction))
		 {
			 response.sendRedirect("Home.view");
		 }
		 else
		 {
			 
		 }
	}

}
