package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EmployeeInfoDAO;
import com.adp.data.EmployeeInfo;

/**
 * Servlet implementation class UpdateControllerShow
 */
public class UpdateControllerShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession hs;
	static Logger log = Logger.getLogger(UpdateControllerShow.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateControllerShow() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
        
    	ConnectionFactory conFactory = new ConnectionFactory();
		EmployeeInfoDAO edao = new EmployeeInfoDAO(conFactory);
		String ecode = (String) hs.getAttribute("eid");
		EmployeeInfo empinfo = edao.selectEmployeeInfoByID(ecode);
		
		hs.setAttribute("einfo", empinfo);
		
		response.sendRedirect("updateEmployeeDetails.view");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
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

}
