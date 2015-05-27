package com.adp.controller;

import java.io.IOException;
import java.sql.SQLException;


import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EarningDao;



public class DeleteEarningController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DeleteEarningController.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEarningController() {
        super();
        // TODO Auto-generated constructor stub
    }
  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException {
	
		boolean ans=false;
        ConnectionFactory conFactory = new ConnectionFactory();
		EarningDao edao = new EarningDao(conFactory);
		String code = request.getParameter("code");	
		ans=edao.deleteEarning(code);
			if(ans == true)
			{
				response.sendRedirect("Home.view");
				log.info("Earning Record Deleted");

			}
			else
			{
				
			}
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			log.error("Class Not Found Exception Raised");
			e.printStackTrace();
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
		} catch (ClassNotFoundException e) {
			log.error("Class Not Found Exception Raised");
			e.printStackTrace();
		} catch (SQLException e) {
			log.error("SQL Exception Raised");
		} catch (NamingException e) {
			log.error("Naming Exception Raised");
		} catch (IOException e) {
			log.error("IO Exception Raised");
		}
    	
	}

}
