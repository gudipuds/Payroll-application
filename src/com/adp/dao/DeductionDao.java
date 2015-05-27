package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.adp.data.Deduction;
import com.adp.data.Earning;

public class DeductionDao {
	ConnectionFactory conFactory;
	   Connection con;
	   PreparedStatement preparedstatement;
	   public DeductionDao(ConnectionFactory conFactory) throws ClassNotFoundException, SQLException, NamingException {
		this.conFactory = conFactory;
		con = conFactory.getConnection();
	   }
	   public boolean addDeduction(Deduction deduction) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String insertquery="insert into DEDUCTION values(?,?,?,?,?,?,?)";
		   preparedstatement=con.prepareStatement(insertquery);
		   preparedstatement.setString(1,deduction.getDedCode());
		   preparedstatement.setString(2,deduction.getDedDesc());
		   preparedstatement.setDate(3,new java.sql.Date(deduction.getDedStartDate().getTime()));
		   preparedstatement.setDate(4,new java.sql.Date(deduction.getDedEndDate().getTime()));
		   preparedstatement.setString(5,deduction.getEeErCode());
		   preparedstatement.setString(6,deduction.getDedTaxability());
		   preparedstatement.setDouble(7,deduction.getDedDfltAmount());
		  
		   ans=preparedstatement.executeUpdate();
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	   public boolean deleteDeduction(String dedcode) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String deletequery="delete from DEDUCTION where DED_CODE=?";
		   preparedstatement=con.prepareStatement(deletequery);
		   preparedstatement.setString(1,dedcode);
		    ans=preparedstatement.executeUpdate();
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	   public boolean updateDeduction(Deduction deduction) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String query="update DEDUCTION set DED_DESC=?,DED_START_DATE=?,DED_END_DATE=?,EE_ER_CODE=?,DED_TAXABILITY=?,DED_DFLT_AMOUNT=? where DED_CODE=?";
		   preparedstatement=con.prepareStatement(query);
		 
		   
		   preparedstatement.setString(1,deduction.getDedDesc());
		   preparedstatement.setDate(2,new java.sql.Date(deduction.getDedStartDate().getTime()));
		   preparedstatement.setDate(3,new java.sql.Date(deduction.getDedEndDate().getTime()));
		   preparedstatement.setString(4,deduction.getEeErCode());
		   preparedstatement.setString(5,deduction.getDedTaxability());
		   preparedstatement.setDouble(6,deduction.getDedDfltAmount());
		   preparedstatement.setString(7,deduction.getDedCode());
		   ans=preparedstatement.executeUpdate();
		   System.out.println(ans);
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	   
	   public ArrayList<String> getDedCodes() throws SQLException {
		
		   ArrayList<String> arr = new ArrayList<String>();
		   String selectQuery = "select * from DEDUCTION";
		   preparedstatement=con.prepareStatement(selectQuery);
		   ResultSet rs=preparedstatement.executeQuery();
		   while(rs.next()) {
			   arr.add(rs.getString(1));
		   }
		   return arr;
		   
	   }
	   
	   public Deduction getDedCodeById(String code) throws SQLException {
		   String selectQuery = "select * from DEDUCTION where DED_CODE=?";
		   preparedstatement=con.prepareStatement(selectQuery);
		   preparedstatement.setString(1, code);
		   ResultSet rs=preparedstatement.executeQuery();
		   rs.next();
		   Deduction ded = new Deduction(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(7));
		   return ded;
	   }
	public Deduction getDeductionDetailsByDedCode(String dedCode) throws SQLException {
		ResultSet rs ;
		String query = "SELECT * FROM DEDUCTION WHERE DED_CODE = ?" ;
		preparedstatement= con.prepareStatement(query);
		preparedstatement.setString(1, dedCode);
	    rs = preparedstatement.executeQuery();
			rs.next();
	    return ( new Deduction(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getDouble(7) ));		
	}
	

	public Deduction getDeduction (String dedCode) throws SQLException {
		Deduction deduction = null;
		String query = "select * from DEDUCTION where DED_CODE=?";
		preparedstatement = con.prepareStatement(query);
		preparedstatement.setString(1, dedCode);
		ResultSet rs = preparedstatement.executeQuery();
		
		while(rs.next()) {
			deduction = new Deduction(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getDouble(7));
		}
		
		return deduction;
	}
}
