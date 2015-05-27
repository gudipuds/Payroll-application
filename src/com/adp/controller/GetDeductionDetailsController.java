package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.DeductionDao;
import com.adp.dao.EarningDao;
import com.adp.data.Deduction;
import com.adp.data.Earning;

public class GetDeductionDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public GetDeductionDetailsController() {
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
		}
	}

	private void processRequest(HttpServletRequest request,	HttpServletResponse response) throws ClassNotFoundException, SQLException, NamingException, IOException 
	{	
		String dedCode = request.getParameter("name");
		System.out.println(dedCode);
		ConnectionFactory conFactory = new ConnectionFactory();
		 
		DeductionDao ddao = new DeductionDao(conFactory);
		
		Deduction deduction = ddao.getDeductionDetailsByDedCode(dedCode);
		
		 HttpSession hs = request.getSession();
		 
		 hs.setAttribute("deduction", deduction);
		
		 response.sendRedirect("EmployeeDeduction.view");
	}

}
