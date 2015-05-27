package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.adp.data.Employment;

public class EmploymentDAO {

	
	ConnectionFactory conf ;
	Connection con ;
	PreparedStatement pstm ;

	public EmploymentDAO( ConnectionFactory conf) throws ClassNotFoundException, SQLException, NamingException {
		this.conf = conf ;
		con = conf.getConnection() ;
	}

	public boolean insertEmployment(Employment employment) throws SQLException {
	
		boolean ans = false;
		String query = "INSERT INTO EMPLOYMENT VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
		
		pstm = con.prepareStatement(query) ;
		
		pstm.setString(1,employment.getEmployeeCode());
		pstm.setDate(2,new java.sql.Date((employment.getEmplHireDate()).getTime()));
		pstm.setDate(3,new java.sql.Date((employment.getEmplTermDate()).getTime()));
		pstm.setString(4,employment.getEeStatus());
		pstm.setString(5,employment.getFullPartTime());
		pstm.setString(6,employment.getPermanentTemp());
		pstm.setString(7,employment.getLeavingReason());
		pstm.setLong(8,employment.getNoticePeriod());
		pstm.setString(9,employment.getNoticePeriodUnit());
		pstm.setLong(10,employment.getProbPeriod());
		pstm.setString(11,employment.getProbPeriodUnit());
		pstm.setString(12,employment.getPayFrequency());
		pstm.setString(13,employment.getEmployerCode());
		

		int result = pstm.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
						
	}
	
	public boolean updateEmployment(Employment employment) throws SQLException {
		
		boolean ans = false;
		String query = "UPDATE EMPLOYMENT SET EMPL_HIRE_DATE= ? , EMPL_TERM_DATE = ? , EE_STATUS = ? , FULL_TIME_PART = ? , PERMENT_TEMP = ? , LEAVING_REASON = ? , NOTICE_PERIOD = ? , NOTICE_PERIOD_UNIT = ? , PROB_PERIOD = ? , PROB_PERIOD_UNIT = ? , PAY_FREQUENCY = ? , EMPLOYER_CODE = ? WHERE EMPLOYEE_CODE = ?" ;
		
		pstm = con.prepareStatement(query) ;
		
		pstm.setDate(1,new java.sql.Date((employment.getEmplHireDate()).getTime()));
		pstm.setDate(2,new java.sql.Date((employment.getEmplTermDate()).getTime()));
		pstm.setString(3,employment.getEeStatus());
		pstm.setString(4,employment.getFullPartTime());
		pstm.setString(5,employment.getPermanentTemp());
		pstm.setString(6,employment.getLeavingReason());
		pstm.setInt(7,employment.getNoticePeriod());
		pstm.setString(8,employment.getNoticePeriodUnit());
		pstm.setInt(9,employment.getProbPeriod());
		pstm.setString(10,employment.getProbPeriodUnit());
		pstm.setString(11,employment.getPayFrequency());
		pstm.setString(12,employment.getEmployerCode());
		
		pstm.setString(13,employment.getEmployeeCode());

		int result = pstm.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
						
	}
	
	public boolean deleteEmployment(String employeeCode , String employerCode) throws SQLException{
		 
		   int ans;
		   boolean state=false;
		   String deletequery="delete from EMPLOYMENT where EMPLOYEE_CODE = ? AND EMPLOYER_CODE = ?";
		   pstm =con.prepareStatement(deletequery);
		   pstm.setString(1,employeeCode);
		   pstm.setString(2,employerCode);

		   ans=pstm.executeUpdate();
		   
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	public ArrayList<String> selectActiveEmployee(String payfrequecy,int payPeriod) throws SQLException{
		 
		   
		   ArrayList<String> employees= new ArrayList<String>();
		   ResultSet rs;
		   String query="select EMPLOYEE_CODE from EMPLOYMENT as e,PAY_CALENDAR as p " +
		   		"        where e.PAY_FREQUENCY=?  and  PAY_PERIOD_NO=? and EE_STATUS=? and " +
		   		"        e.EMPL_HIRE_DATE<=p.PAY_PERIOD_START and " +
		   		"        (e.EMPL_TERM_DATE>=p.PAY_PERIOD_END or e.EMPL_TERM_DATE=NULL) " ;
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,payfrequecy);
		   pstm.setString(2,"Current");
		   pstm.setInt(3,payPeriod);

		   rs=pstm.executeQuery();
		   while(rs.next()){
			   employees.add(rs.getString(1));
		   
		   }
		   return employees;
		   
		   
	   }
	public boolean selectEarningEmployee(String empcode,String payPeriod) throws SQLException{
		 
		   boolean ans=false;
		   ArrayList<String> employees= new ArrayList<String>();
		   ResultSet rs;
		   String query="select EMPLOYEE_CODE from EE_EARNING as ee,PAY_CALENDAR as p " +
		   		"        where EMPLOYEE_CODE=?,EE_EARN_STATUS_CODE=? and PAY_PERIOD_NO=?" +
		   		"        ee.EE_EARN_START_DATE<=p.PAY_PERIOD_END and " +
		   		"        (ee.EE_EARN_END_DATE>=p.PAY_PERIOD_START or ee.EE_EARN_END_DATE=NULL)" ;
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,empcode);
		   pstm.setString(2,"active");
     	   pstm.setString(3,payPeriod);

		   rs=pstm.executeQuery();
		   if(rs.next()){
			   ans=true;
		   
		   }
		   return ans;
		   
		   
	   }
	public ArrayList<String> getEarningEmployee(String empcode,int payPeriod) throws SQLException{
		 
		   ArrayList<String> employees= new ArrayList<String>();
		   ResultSet rs;
		   String query="select EMPLOYEE_CODE,EARN_CODE from EE_EARNING as ee,PAY_CALENDAR as p " +
		   		"        where EMPLOYEE_CODE=?,EE_EARN_STATUS_CODE=? and PAY_PERIOD_NO=?" +
		   		"        ee.EE_EARN_START_DATE<=p.PAY_PERIOD_END and " +
		   		"        (ee.EE_EARN_END_DATE>=p.PAY_PERIOD_START or ee.EE_EARN_END_DATE=NULL)" ;
		   
		   
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,empcode);
		   pstm.setString(2,"active");
  	       pstm.setInt(3,payPeriod);

		   rs=pstm.executeQuery();
		   if(rs.next()){
			   employees.add(rs.getString(1));
			   employees.add(rs.getString(2));
		   
		   }
		   return employees;
		   
		   
	   }
	
	public double getAmount(String empcode,String earncode) throws SQLException{
		 
		   ArrayList<String> employees= new ArrayList<String>();
		   ResultSet rs;
		   double amount=0,temp1,temp2;
		   String query="select EE_EARN_DFLT_AMT from EE_EARNING where EMPLOYEE_CODE=? and EARN_CODE=? ";
		   
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,empcode);
		   pstm.setString(2,earncode);

		   rs=pstm.executeQuery();
		   if(rs.next()){
		       temp1=rs.getDouble(1);
		   
			   if(temp1==0){
				   String query1="select EARN_DFLT_AMOUNT from EARNING where EARN_CODE=? ";
				   pstm =con.prepareStatement(query1);
				   pstm.setString(1,earncode);
			       rs=pstm.executeQuery();
			       if(rs.next()){
				       temp2=rs.getDouble(1);
				   
					   if(temp2==0){
						   amount=0;
					   }
					   else{
						   amount=temp2; 
					   }
			       }			  
				   
			    }
			   else
				   amount=temp1;
		   }
			  
		   
		   
		   return amount;
		   
		   
	   }
	public String getTax(String earncode) throws SQLException{
		 
		   
		   ResultSet rs;
		   String tax=null;
		   String query="select EARN_TAXABILITY from EARNING where EARN_CODE=? " ;
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,earncode);
		  

		   rs=pstm.executeQuery();
		   if(rs.next()){
			  tax=rs.getString(1);
		   
		   }
		   return tax;
		   
	}
	
	public ArrayList<String> getDeductionEmployee(String empcode,int payPeriod) throws SQLException{
		 
		   ArrayList<String> employees= new ArrayList<String>();
		   ResultSet rs;
		   String query="select EMPLOYEE_CODE,DED_CODE from EE_DEDUCTION as dd,PAY_CALENDAR as p " +
		   		"        where EMPLOYEE_CODE=?,EE_DED_STATUS_CODE=? and PAY_PERIOD_NO=?" +
		   		"        dd.EE_DED_START_DATE<=p.PAY_PERIOD_END and " +
		   		"        (dd.EE_DED_END_DATE>=p.PAY_PERIOD_START or dd.EE_DED_END_DATE=NULL)" ;
		   
		   
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,empcode);
		   pstm.setString(2,"active");
	       pstm.setInt(3,payPeriod);

		   rs=pstm.executeQuery();
		   if(rs.next()){
			   employees.add(rs.getString(1));
			   employees.add(rs.getString(2));
		   
		   }
		   return employees;
		   
		   
	   }
	public double getDedAmount(String empcode,String dedcode) throws SQLException{
		 
		   ArrayList<String> employees= new ArrayList<String>();
		   ResultSet rs;
		   double amount=0,temp1,temp2;
		   String query="select EE_DED_DFLT_AMT from EE_DEDUCTION where EMPLOYEE_CODE=? and DED_CODE=? ";
		   
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,empcode);
		   pstm.setString(2,dedcode);

		   rs=pstm.executeQuery();
		   if(rs.next()){
		       temp1=rs.getDouble(1);
		   
			   if(temp1==0){
				   String query1="select DED_DFLT_AMOUNT from DEDUCTION where DED_CODE=? ";
				   pstm =con.prepareStatement(query1);
				   pstm.setString(1,dedcode);
			       rs=pstm.executeQuery();
			       if(rs.next()){
				       temp2=rs.getDouble(1);
				   
					   if(temp2==0){
						   amount=0;
					   }
					   else{
						   amount=temp2; 
					   }
			       }			  
				   
			    }
			   else
				   amount=temp1;
		   }
			  
		   
		   
		   return amount;
		   
		   
	   }
	public String getDedTax(String dedcode) throws SQLException{
		 
		   
		   ResultSet rs;
		   String tax=null;
		   String query="select DED_TAXABILITY from DEDUCTION where DED_CODE=? " ;
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,dedcode);
		  

		   rs=pstm.executeQuery();
		   if(rs.next()){
			  tax=rs.getString(1);
		   
		   }
		   return tax;
		   
	}
	public String getPreTaxEarning(String empcode) throws SQLException{
		 
		   
		   ResultSet rs;
		   String tax=null;
		   String query="select EE-EARN_AMT from EE_EARN_RESULT where EMPLOYEE_CODE=? " ;
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,empcode);
		  

		   rs=pstm.executeQuery();
		   if(rs.next()){
			  tax=rs.getString(1);
		   
		   }
		   return tax;
		   
	}
	public String getPreTaxDeduction(String empcode) throws SQLException{
		 
		   
		   ResultSet rs;
		   String tax=null;
		   String query="select EE-DED_AMT from EE_DED_RESULT where EMPLOYEE_CODE=? " ;
		   pstm =con.prepareStatement(query);
		   pstm.setString(1,empcode);
		  

		   rs=pstm.executeQuery();
		   if(rs.next()){
			  tax=rs.getString(1);
		   
		   }
		   return tax;
		   
	}

	public String getEmpStatus(String ecode) throws SQLException {
		String query="SELECT EE_STATUS FROM EMPLOYMENT WHERE EMPLOYEE_CODE = ?";
		pstm=con.prepareStatement(query);
		pstm.setString(1, ecode);
		ResultSet rs = pstm.executeQuery();
		rs.next();
		return (rs.getString(1));
	}
	
	public ArrayList<Employment> getEmployCode(String payFreq) throws SQLException {
		ArrayList<Employment> empDet = new ArrayList<Employment>();
		String query = "select * from EMPLOYMENT where EE_STATUS=? and PAY_FREQUENCY=?";
		pstm = con.prepareStatement(query);
		
		pstm.setString(1, "current");
		pstm.setString(2, payFreq);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			empDet.add(new Employment(rs.getString(1),rs.getDate(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13)));
			
		}
		return empDet;
	}
	
}
