package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.adp.data.EeDeduction;


public class EeDeductionDao {
	ConnectionFactory conFactory;
	   Connection con;
	   PreparedStatement preparedstatement;
	   public EeDeductionDao (ConnectionFactory conFactory) throws ClassNotFoundException, SQLException, NamingException {
		this.conFactory = conFactory;
		con = conFactory.getConnection();
	   }
	   public boolean addEeDeduction(EeDeduction eededuction) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String insertquery="insert into EE_DEDUCTION values(?,?,?,?,?,?)";
		   preparedstatement=con.prepareStatement(insertquery);
		   preparedstatement.setString(1,eededuction.getEmployeeCode());
		   preparedstatement.setString(2,eededuction.getDedCode());
		   preparedstatement.setDate(3,new java.sql.Date(eededuction.getEeDedStartDate().getTime() ));
		   preparedstatement.setDate(4,new java.sql.Date(eededuction.getEeDedEndDate().getTime() ));
		   preparedstatement.setString(5,eededuction.getEeDedStatusCode());
		   preparedstatement.setDouble(6,eededuction.getEeDedDfltAmt());
		 
		   ans=preparedstatement.executeUpdate();
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	  
	   public boolean updateEeDeduction(EeDeduction eededuction) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String query="update DEDUCTION set EE_DED_START_DATE=?,EE_DED_END_DATE=?, EE_DED_STATUS_CODE=?, EE_DED_DFLT_AMT =? where DED_CODE=? AND EMPLOYEE_CODE=?";
		   preparedstatement=con.prepareStatement(query);
		 
		   preparedstatement=con.prepareStatement(query);
		   
		   preparedstatement.setDate(1,new java.sql.Date(eededuction.getEeDedStartDate().getTime() ));
		   preparedstatement.setDate(2,new java.sql.Date(eededuction.getEeDedEndDate().getTime() ));
		   preparedstatement.setString(3,eededuction.getEeDedStatusCode());
		   preparedstatement.setDouble(4,eededuction.getEeDedDfltAmt());
		   preparedstatement.setString(5,eededuction.getDedCode());
		   preparedstatement.setString(6,eededuction.getEmployeeCode());
		  
		   ans=preparedstatement.executeUpdate();
		   
		
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	   /**
	    * 
	    * @param 
	    * @param employeecode
	    * @return
	    * @throws SQLException
	    */
	   public boolean deleteEeDeduction(String dedcode ,String employeecode) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String deletequery="delete from EE_EARNING where DED_CODE=? and EMPLOYEE_CODE =?";
		   preparedstatement=con.prepareStatement(deletequery);
		   preparedstatement.setString(1,dedcode);
		   preparedstatement.setString(2,employeecode);
		    ans=preparedstatement.executeUpdate();
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	   
	   public ArrayList<EeDeduction> getEEDeduction (String empCode) throws SQLException {
			ArrayList<EeDeduction> eeDeduction = new ArrayList<EeDeduction>();
			String query = "select * from EE_DEDUCTION where EMPLOYEE_CODE=? and EE_DED_STATUS_CODE=?";
			preparedstatement = con.prepareStatement(query);
			preparedstatement.setString(1, empCode);
			preparedstatement.setString(2, "active");
			ResultSet rs = preparedstatement.executeQuery();
			
			while(rs.next()) {
				eeDeduction.add(new EeDeduction(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getDouble(6)));
			}
			
			return eeDeduction;
		}
		

}
