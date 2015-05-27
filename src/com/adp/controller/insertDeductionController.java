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

import org.apache.log4j.Logger;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.DeductionDao;
import com.adp.data.Deduction;

/**
 * Servlet implementation class deleteDeductionController
 */
public class insertDeductionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionFactory conFactory;
	DeductionDao ddao;
	static Logger log = Logger.getLogger(insertDeductionController.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertDeductionController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException, ParseException {
    
    	boolean ans;
    	conFactory = new ConnectionFactory();
        ddao = new DeductionDao(conFactory);
        DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
    	String dedcode = request.getParameter("dedcode");
    	String deddesc = request.getParameter("deddesc");
    	Date sdate = (Date)formatter.parse(request.getParameter("sdate"));
    	Date edate = (Date)formatter.parse(request.getParameter("edate"));
    	String ercode = request.getParameter("type");
    	String taxability = request.getParameter("taxability");
    	double defaultamt = Double.parseDouble(request.getParameter("amt"));
    	Deduction deduction = new Deduction(dedcode, deddesc, sdate, edate, ercode, taxability, defaultamt);   	
		log.debug("Deduction Object Created");

    	ans=ddao.addDeduction(deduction);
    	
    	if(ans)
    	{
    		response.sendRedirect("Home.view");
			log.info("Deduction Record Created");

    	}
    	else
    	{
    		response.sendRedirect("InsertDeduction.view");
    	}
    	
    
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
		} catch (ParseException e) {
			log.error("Parse Exception Raised");

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
		} catch (ParseException e) {
			log.error("Parse Exception Raised");

		}
	}

}
