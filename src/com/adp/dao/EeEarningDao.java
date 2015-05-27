package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;


import com.adp.data.EeEarning;

public class EeEarningDao {
	ConnectionFactory conFactory;
	   Connection con;
	   PreparedStatement preparedstatement;
	   public EeEarningDao(ConnectionFactory conFactory) throws ClassNotFoundException, SQLException, NamingException {
		this.conFactory = conFactory;
		con = conFactory.getConnection();
	   }
	   public boolean addEeEarning(EeEarning eearning) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String insertquery="insert into EE_EARNING values(?,?,?,?,?,?)";
		   preparedstatement=con.prepareStatement(insertquery);
		   preparedstatement.setString(1,eearning.getEmployeeCode());
		   preparedstatement.setString(2,eearning.getEarnCode());
		   preparedstatement.setDate(3,new java.sql.Date( eearning.getEeEarnStartDate().getTime() ));
		   preparedstatement.setDate(4,new java.sql.Date( eearning.getEeEarnEndDate().getTime() ));
		   preparedstatement.setString(5,eearning.getEeEarnStatusCode());
		   preparedstatement.setDouble(6,eearning.getEeEarnDfltAmt());
		  
		   ans=preparedstatement.executeUpdate();
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	  
	   public boolean updateEeEarning(EeEarning eearning) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String query="update EARNING set EE_EARN_START_DATE=?,EE_EARN_END_DATE=?, EE_EARN_STATUS_CODE=?, EE_EARN_DFLT_AMT =? where EARN_CODE=? AND EMPLOYEE_CODE=?";
		   preparedstatement=con.prepareStatement(query);
		 
		   preparedstatement.setDate(1,new java.sql.Date( eearning.getEeEarnStartDate().getTime() ));
		   preparedstatement.setDate(2,new java.sql.Date( eearning.getEeEarnEndDate().getTime() ));
		   preparedstatement.setString(3,eearning.getEeEarnStatusCode());
		   preparedstatement.setDouble(4,eearning.getEeEarnDfltAmt());
		   preparedstatement.setString(5,eearning.getEarnCode());
		   preparedstatement.setString(6,eearning.getEmployeeCode());
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
	   public boolean deleteEeEarning(String earncode ,String employeecode) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String deletequery="delete from EE_EARNING where EARN_CODE=? and EMPLOYEE_CODE =?";
		   preparedstatement=con.prepareStatement(deletequery);
		   preparedstatement.setString(1,earncode);
		   preparedstatement.setString(2,employeecode);
		    ans=preparedstatement.executeUpdate();
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	   
		
		public ArrayList<EeEarning> getEEEarning (String empCode) throws SQLException {
			ArrayList<EeEarning> eeEarning = new ArrayList<EeEarning>();
			String query = "select * from EE_EARNING where EMPLOYEE_CODE=? and EE_EARN_STATUS_CODE=?";
			preparedstatement = con.prepareStatement(query);
			preparedstatement.setString(1, empCode);
			preparedstatement.setString(2, "active");
			ResultSet rs = preparedstatement.executeQuery();
			
			while(rs.next()) {
				eeEarning.add(new EeEarning(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getDouble(6)));
			}
			
			return eeEarning;
		}

}
