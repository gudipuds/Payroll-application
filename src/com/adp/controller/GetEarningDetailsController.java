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
import com.adp.dao.EarningDao;
import com.adp.dao.EmploymentDAO;
import com.adp.data.Earning;


public class GetEarningDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetEarningDetailsController() {
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
		String earnCode = request.getParameter("name");
		ConnectionFactory conFactory = new ConnectionFactory();
		 
		EarningDao edao = new EarningDao(conFactory);
		
		Earning earning = edao.getEarningDetailsByEarnCode(earnCode);
		
		 HttpSession hs = request.getSession();
		 
		 hs.setAttribute("earning", earning);
		
		 response.sendRedirect("EmployeeEarnings.view");
	}
}
