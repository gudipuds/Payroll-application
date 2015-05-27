package com.adp.controller;

import hirondelle.date4j.DateTime;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.PayCalendarDAO;
import com.adp.data.PayCalendar;

/**
 * Servlet implementation class calculatePayPeriods
 */
public class PayCalculatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String payFrequency;
	String taxYear;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayCalculatorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, Throwable {
		taxYear = request.getParameter("taxYear");
		payFrequency = request.getParameter("payFrequency");
		boolean ans[] ={false, false, false, false, false, false,false, false, false, false, false, false };
		String start = taxYear.split("/")[0];
		int startYear = Integer.parseInt(start);
		
		String end = taxYear.split("/")[1];
		ConnectionFactory conf = new ConnectionFactory();
		PayCalendarDAO insert = new PayCalendarDAO(conf);
		if(startYear >= 2000){
			end = "20" + end;
		}
		else{
			end = "19" + end;
		}
		
	//	int endYear = Integer.parseInt(end);
		
		insert.deletePayCalendar();
		if(payFrequency.equalsIgnoreCase("Monthly")){
			int month = 4;
			int day = 1;
			int year = startYear;
			int payPeriod = 1;
			
		for(int i = 1; i <=12; i++)
		{
		
			if(month > 12)
			{
				year = year + 1;
				month = 1;
			}
			DateTime dt = DateTime.forDateOnly(year, month, day);
		    String startMonth = dt.getStartOfMonth().format("DD-MM-YYYY");
		    Date startOfMonth = stringToDate(startMonth);
			String endMonth = dt.getEndOfMonth().format("DD-MM-YYYY");
		    Date endOfMonth = stringToDate(endMonth);

			int noOfDays = dt.numDaysFrom(dt.getEndOfMonth());
			DateTime newdt = dt.plusDays(noOfDays-2);
			String procesDate = newdt.format("DD-MM-YYYY");
			Date processDate = stringToDate(procesDate);

			PayCalendar payCalander = new PayCalendar(payFrequency,taxYear,payPeriod,start,end, startOfMonth, endOfMonth, endOfMonth, processDate);
			
			boolean isInserted = insert.insertPayCalendar(payCalander);
			
			if(isInserted){
				ans[i-1] = true;
			}
			else
			{
				RequestDispatcher rs = request.getRequestDispatcher("payCalendar.view");
				rs.forward(request, response);
			}
			month++;
			payPeriod++;
			
		}
		
	}

		RequestDispatcher rs = request.getRequestDispatcher("Home.view");
		rs.forward(request, response);
		
	}

	public Date stringToDate(String date) throws ParseException{
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date d = (Date)formatter.parse(date);
		
		return d;
	}
	
}