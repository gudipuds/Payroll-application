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
import com.adp.dao.EmployerDAO;
import com.adp.data.Employer;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class viewEmployerEmpController
 */
public class viewEmployerEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionFactory conFactory;
	HttpSession hs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewEmployerEmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
    
    conFactory = new ConnectionFactory();
    EmployerDAO emprdao = new EmployerDAO(conFactory);
    Employer emp = emprdao.showAllDetails();
	hs = request.getSession();
    hs.setAttribute("emp",emp);
    
    response.sendRedirect("viewEmployer.view");
   
    
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
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
		// TODO Auto-generated method stub
	}

}
