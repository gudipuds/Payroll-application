package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.adp.data.EeDedResult;

public class EeDedResultDAO {
	ConnectionFactory connectionfactory;
	Connection connection;
	PreparedStatement pst;

	public EeDedResultDAO( ConnectionFactory connectionfactory) throws ClassNotFoundException, SQLException, NamingException {
		this.connectionfactory = connectionfactory ;
		connection = connectionfactory.getConnection() ;
	}
	
	public boolean insertEeDedResult(EeDedResult eeDedResult) throws SQLException
	{	
		boolean ans = false;
		String insertQuery = "INSERT INTO EE_DED_RESULT VALUES(?,?,?,?,?,?,?)";
		pst=connection.prepareStatement(insertQuery);
		pst.setString(1, eeDedResult.getEmployeeCode());
		pst.setString(2, eeDedResult.getPayFrequency());
		pst.setInt(4, eeDedResult.getPayPeriodNo());
		pst.setString(3, eeDedResult.getTaxYear());
		pst.setString(5, eeDedResult.getDedCode());
		pst.setDouble(6, eeDedResult.getEeDedAmt());
		pst.setString(7, eeDedResult.getDedTaxability());
		int rst = pst.executeUpdate();
		if(rst > 0)
			ans = true;
		return ans;
	  }
	
	  public ResultSet displayEeDedResult() throws SQLException
	  {
		 String selectQuery = "SELECT * FROM EE_DED_TAXABILITY";
		 pst= connection.prepareStatement(selectQuery);
		 ResultSet rs = pst.executeQuery();
		return rs;
		  
	  }
	  
		
	    public boolean insertEEDedResult(EeDedResult dedResult) throws SQLException {
			
			String query = "INSERT INTO EE_DED_RESULT  VALUES (?,?,?,?,?,?,?)";
			boolean flag = false ;
			
			pst = connection.prepareStatement(query);
				pst.setString(1,dedResult.getEmployeeCode());
				pst.setString(2,dedResult.getPayFrequency());
				pst.setString(3,dedResult.getTaxYear());
				pst.setInt(4,dedResult.getPayPeriodNo());
				pst.setString(5,dedResult.getDedCode());
				pst.setDouble(6,dedResult.getEeDedAmt());
				pst.setString(7, dedResult.getDedTaxability());
				
			    int ans = pst.executeUpdate();
			     
			    if ( ans > 0 ) { 
			    	flag = true ; 
			    }
			    
			    return flag ; 
			    	 
		}
}
