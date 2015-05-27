package com.adp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adp.dao.DeductionDao;
import com.adp.dao.EarningDao;
import com.adp.dao.EeDedResultDAO;
import com.adp.dao.EeDeductionDao;
import com.adp.dao.EeEarnResultDAO;
import com.adp.dao.EeEarningDao;
import com.adp.dao.EeTaxResultDAO;
import com.adp.dao.EmploymentDAO;
import com.adp.dao.PayCalendarDAO;
import com.adp.dao.ConnectionFactory;
import com.adp.data.Deduction;

import com.adp.data.Earning;
import com.adp.data.EeDedResult;
import com.adp.data.EeDeduction;
import com.adp.data.EeEarnResult;
import com.adp.data.EeEarning;
import com.adp.data.EeTaxResult;
import com.adp.data.Employment;


public class PayrunEmployeeController extends HttpServlet {
	ConnectionFactory conFactory;
	HttpSession hs;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		conFactory = new ConnectionFactory();
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, NamingException, ParseException {
		 double amount = 0;
		 double earnSum = 0;
		 double dedSum = 0;
		 double wage = 0;
		 double tax = 0;
		 System.out.println("xxxxxxxxxx");
		 ArrayList<String> empCodes = new ArrayList<String>();
		 ArrayList<EeEarning> eeEarning = new ArrayList<EeEarning>();
		 ArrayList<EeDeduction> eeDeduction = new ArrayList<EeDeduction>();
		 Earning earning;
		 Deduction deduction;
		 
		 String payFrequency = request.getParameter("payFrequency");
		 String taxYear = request.getParameter("taxYear");
		 int payPeriod = Integer.parseInt(request.getParameter("payPeriod"));
		 
		 EmploymentDAO employmentDao = new EmploymentDAO(conFactory);
		 PayCalendarDAO payCalDao = new PayCalendarDAO(conFactory);
		 EeDeductionDao eeDedDao = new EeDeductionDao(conFactory);
		 EeEarningDao eeEarnDao = new EeEarningDao(conFactory);
		 EarningDao earnDao = new EarningDao(conFactory);
		 DeductionDao dedDao = new DeductionDao(conFactory);
		 EeEarnResultDAO eeEarnResultDao = new EeEarnResultDAO(conFactory);
		 EeDedResultDAO eeDedResultDao = new EeDedResultDAO(conFactory);
		 EeTaxResultDAO eeTaxResultDao = new EeTaxResultDAO(conFactory);
		 
		 
		 ArrayList<Date> arrDates = payCalDao.getDates(payPeriod);
		 Date payStartDate = arrDates.get(0);
		 Date payEndDate = arrDates.get(1);
		 
		 ArrayList<Employment> arrDet = employmentDao.getEmployCode(payFrequency);
		 for(Employment emp: arrDet) {
			 if((emp.getEmplHireDate().compareTo(payEndDate)<= 0) && ((emp.getEmplTermDate() == null) || (emp.getEmplTermDate().compareTo(payStartDate) >= 0))) {
				 empCodes.add(emp.getEmployeeCode());
			 }
		 }
		 
		 for(String empCode : empCodes) {
			 earnSum=0;
			 dedSum=0;
			 //earning
			 
			 eeEarning = eeEarnDao.getEEEarning(empCode);
			 for(EeEarning eeearning : eeEarning)
			 {
				 System.out.println(empCode);
				 System.out.println(eeearning.toString());
				 if(((eeearning.getEeEarnStartDate()).compareTo(payStartDate) <= 0) && (((eeearning.getEeEarnEndDate()).compareTo(payEndDate) >= 0)||(eeearning.getEeEarnEndDate() == null))){
					 earning = earnDao.getEarning(eeearning.getEarnCode());
					 if((eeearning.getEeEarnDfltAmt()) == 0) {
						 amount = earning.getEarnDfltAmount();
					 }
					 else {
						 amount = eeearning.getEeEarnDfltAmt();
					 }
					 System.out.println(amount);
					 EeEarnResult eeEarnResult = new EeEarnResult(empCode, payFrequency, taxYear, payPeriod, eeearning.getEarnCode(), amount, earning.getEarnTaxability());
					 eeEarnResultDao.insertEEEarnResult(eeEarnResult);
					 earnSum += amount;		 
				 }
			 }
			 
			 //deduction
			 
			 eeDeduction = eeDedDao.getEEDeduction(empCode);
			 for(EeDeduction eededuction : eeDeduction)
			 {
				 System.out.println("111123234");
				 if(((eededuction.getEeDedStartDate()).compareTo(payStartDate) <= 0) && (((eededuction.getEeDedEndDate()).compareTo(payEndDate) >= 0)||(eededuction.getEeDedEndDate() == null))){
					 System.out.println("2334");
					 deduction = dedDao.getDeduction(eededuction.getDedCode());
					 if((eededuction.getEeDedDfltAmt()) == 0) {
						 amount = deduction.getDedDfltAmount();
					 }
					 else {
						 amount = eededuction.getEeDedDfltAmt();
					 }
					 EeDedResult eeDedResult = new EeDedResult(empCode, payFrequency, taxYear, payPeriod, eededuction.getDedCode(), amount, deduction.getDedTaxability());
					 eeDedResultDao.insertEEDedResult(eeDedResult);
					 dedSum += amount;		 
				 }
			 }
			 
			 wage = earnSum - dedSum;
			 tax = 0.1 * wage;
			 
			 EeTaxResult eeTaxResult = new EeTaxResult(empCode, payFrequency, taxYear, payPeriod, wage , tax);
			 eeTaxResultDao .insertEETaxResult(eeTaxResult);
			 
		 }
		 
		 RequestDispatcher rs = request.getRequestDispatcher("Home.view");
			rs.forward(request, response);
		 
	 }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
