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
import com.adp.dao.EmploymentDAO;


public class GetEmpStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetEmpStatusController() {
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
		String ecode = request.getParameter("name");
		System.out.println(ecode);
		ConnectionFactory conFactory = new ConnectionFactory();
		 
		EmploymentDAO edao = new EmploymentDAO(conFactory);
		System.out.println("jaodfn");
		String estatus = edao.getEmpStatus(ecode);
		 HttpSession hs = request.getSession();
		 
		 hs.setAttribute("estatus", estatus);
		 hs.setAttribute("ecode", ecode);
		 
		 response.sendRedirect("EmployeeEarnings.view");
	}
	
}
