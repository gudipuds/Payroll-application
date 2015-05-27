package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.adp.data.EeEarnResult;

public class EeEarnResultDAO {
	ConnectionFactory connectionfactory;
	Connection connection;
	PreparedStatement pst;

	public EeEarnResultDAO( ConnectionFactory connectionfactory) throws ClassNotFoundException, SQLException, NamingException {
		this.connectionfactory = connectionfactory ;
		connection = connectionfactory.getConnection() ;
	}
	
	public boolean insertEeEarnResult(EeEarnResult eeEarnResult) throws SQLException
	{	
		boolean ans = false;
		String insertQuery = "INSERT INTO EE_EARN_RESULT VALUES(?,?,?,?,?,?,?)";
		pst=connection.prepareStatement(insertQuery);
		pst.setString(1, eeEarnResult.getEmployeeCode());
		pst.setString(2, eeEarnResult.getPayFrequency());
		pst.setInt(4, eeEarnResult.getPayPeriodNo());
		pst.setString(3, eeEarnResult.getTaxYear());
		pst.setString(5, eeEarnResult.getEarnCode());
		pst.setDouble(6, eeEarnResult.getEeEarnAmt());
		pst.setString(7, eeEarnResult.getEeTaxability());
	
		int rst = pst.executeUpdate();
		if(rst > 0)
			ans = true;
		return ans;
	  }
	
	  public ResultSet displayEeEarnResult() throws SQLException
	  {
		 String selectQuery = "SELECT * FROM EE_EARN_TAXABILITY";
		 pst= connection.prepareStatement(selectQuery);
		 ResultSet rs = pst.executeQuery();
		return rs;
		  
	  }
	  public boolean insertEEEarnResult(EeEarnResult earnResult) throws SQLException {
			
			String query = "INSERT INTO EE_EARN_RESULT VALUES (?,?,?,?,?,?,?)";
			boolean flag = false ;
			
			pst = connection.prepareStatement(query);
				pst.setString(1,earnResult.getEmployeeCode());
				pst.setString(2,earnResult.getPayFrequency());
				pst.setString(3, earnResult.getTaxYear());
				pst.setInt(4, earnResult.getPayPeriodNo());
				pst.setString(5, earnResult.getEarnCode());
				pst.setDouble(6,earnResult.getEeEarnAmt());
				pst.setString(7, earnResult.getEeTaxability());
				
			    int ans = pst.executeUpdate();
			     
			    if ( ans > 0 ) { 
			    	flag = true ; 
			    }
			    
			    return flag ; 
			    	 
		}
	
}
