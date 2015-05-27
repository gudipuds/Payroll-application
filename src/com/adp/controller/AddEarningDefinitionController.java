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

import com.adp.dao.BusinessUnitDAO;
import com.adp.dao.ConnectionFactory;
import com.adp.dao.EarningDao;
import com.adp.data.BusinessUnit;
import com.adp.data.Earning;

/**
 * Servlet implementation class EarningDefinitionController
 */
public class AddEarningDefinitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(AddEarningDefinitionController.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEarningDefinitionController() {
        super();
       
    }
    private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
    	
    	boolean ans=false;
		DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
    	
		try {
		String earnCode = request.getParameter("earnCode");
		String earnDesc = request.getParameter("earnDesc");
		Date earnStartDate = (Date)formatter.parse(request.getParameter("earnStartDate"));
		Date earnEndDate = (Date)formatter.parse(request.getParameter("earnEndDate"));
		String earnTaxability = request.getParameter("earnTaxability");
		double earnDfltAmount =Double.valueOf(request.getParameter("earnDfltAmount"));
		ConnectionFactory conf = new ConnectionFactory();
		EarningDao earningdao = new EarningDao(conf); 
	
		Earning earning= new Earning(earnCode, earnDesc, earnStartDate, earnEndDate, earnTaxability, earnDfltAmount);

            
			ans=earningdao.addEarning(earning);
			System.out.println(earnTaxability);

			if(ans == true)
			{
				response.sendRedirect("Home.view");
				log.info("Earning Table Modified !");
			}
			else
			{
				
			}
			
		} catch (ClassNotFoundException e) {
			log.error("Class Not Found Exception Raised");
			e.printStackTrace();
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
