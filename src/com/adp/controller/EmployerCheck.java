package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adp.dao.AdminDAO;
import com.adp.dao.ConnectionFactory;

public class EmployerCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionFactory conf;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processrequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processrequest(request, response);
	}

	protected void processrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		conf = new ConnectionFactory();
		boolean ans;
		try {
			AdminDAO a = new AdminDAO(conf);
			ans = a.showUsers();
			if(ans){
				response.sendRedirect("index");
			}
			else
				response.sendRedirect("EmployerRegister");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
