package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.adp.data.EeTaxResult;

public class EeTaxResultDAO {
	ConnectionFactory connectionfactory;
	Connection connection;
	PreparedStatement pst;

	public EeTaxResultDAO( ConnectionFactory connectionfactory) throws ClassNotFoundException, SQLException, NamingException {
		this.connectionfactory = connectionfactory ;
		connection = connectionfactory.getConnection() ;
	}
	
	public boolean insertEeTaxResult(EeTaxResult eeTaxResult) throws SQLException
	{	
		boolean ans = false;
		String insertQuery = "INSERT INTO EE_TAX_RESULT VALUES(?,?,?,?,?,?)";
		pst=connection.prepareStatement(insertQuery);
		pst.setString(1, eeTaxResult.getEmployeeCode());
		pst.setString(2, eeTaxResult.getPayFrequency());
		pst.setString(3, eeTaxResult.getTaxYear());
		pst.setInt(4, eeTaxResult.getPayPeriodNo());
		pst.setDouble(5, eeTaxResult.getTaxableWageAmt());
		pst.setDouble(6, eeTaxResult.getTaxAmt());
		int rst = pst.executeUpdate();
		if(rst > 0)
			ans = true;
		return ans;
	  }
	
	  public ResultSet displayEeTaxResult() throws SQLException
	  {
		 String selectQuery = "SELECT * FROM EE_TAX_TAXABILITY";
		 pst= connection.prepareStatement(selectQuery);
		 ResultSet rs = pst.executeQuery();
		return rs;
		  
	  }
	  
	  public boolean insertEETaxResult(EeTaxResult taxResult) throws SQLException {
			
			String query = "insert into EE_TAX_RESULT values (?,?,?,?,?,?);";
			boolean flag = false ; 

			pst = connection.prepareStatement(query);
			pst.setString(1,taxResult.getEmployeeCode());
			pst.setString(2, taxResult.getPayFrequency());
			pst.setString(3, taxResult.getTaxYear());
			pst.setInt(4, taxResult.getPayPeriodNo());
			pst.setDouble(5, taxResult.getTaxableWageAmt());
			pst.setDouble(6, taxResult.getTaxAmt());
			
			int ans = pst.executeUpdate();
			if ( ans > 0 ) { 
				flag = true ; 
			}
			return flag ;
		}
}
