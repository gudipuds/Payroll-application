package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import com.adp.data.Earning;

/**
 * 
 * @author Team5
 * This class includes various functionalities for Earning entity
 *
 */
public class EarningDao {
	ConnectionFactory conFactory;
	   Connection con;
	   PreparedStatement preparedstatement;
	   public EarningDao(ConnectionFactory conFactory) throws ClassNotFoundException, SQLException, NamingException {
		this.conFactory = conFactory;
		con = conFactory.getConnection();
	   }
	   public boolean addEarning(Earning earning) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String insertquery="insert into EARNING values(?,?,?,?,?,?)";

		   preparedstatement=con.prepareStatement(insertquery);

		   preparedstatement.setString(1,earning.getEarnCode());

		   preparedstatement.setString(2,earning.getEarnDesc());

		   preparedstatement.setDate(3,new java.sql.Date((earning.getEarnStartDate()).getTime()));

		   preparedstatement.setDate(4,new java.sql.Date((earning.getEarnEndDate()).getTime()));
		   preparedstatement.setString(5,earning.getEarnTaxability());

		   preparedstatement.setDouble(6,earning.getEarnDfltAmount());

		   ans=preparedstatement.executeUpdate();

		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	   public boolean deleteEarning(String earnCode) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String deletequery="delete from EARNING where EARN_CODE=?";
		   preparedstatement=con.prepareStatement(deletequery);
		   preparedstatement.setString(1,earnCode);
		    ans=preparedstatement.executeUpdate();
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	   public boolean updateEarning(Earning earning) throws SQLException{
			 
		   int ans;
		   boolean state=false;
		   String updatequery="update EARNING set EARN_DESC=?,EARN_START_DATE=?,EARN_END_DATE=?, EARN_TAXABILITY=?,EARN_DFLT_AMOUNT=? where EARN_CODE=?";
		   preparedstatement=con.prepareStatement(updatequery);
		 
		   preparedstatement.setString(1,earning.getEarnDesc());
		   preparedstatement.setDate(2,new java.sql.Date((earning.getEarnStartDate()).getTime()));
		   preparedstatement.setDate(3,new java.sql.Date((earning.getEarnEndDate()).getTime()));
		   preparedstatement.setString(4,earning.getEarnTaxability());
		   preparedstatement.setDouble(5,earning.getEarnDfltAmount());
		   preparedstatement.setString(6,earning.getEarnCode());
		   ans=preparedstatement.executeUpdate();
		   
		
		   if(ans>0){
		    state=true;
		   }
		   return state;
	   }
	   public ArrayList<String> getEarnCodes() throws SQLException {
			String selectQuery = "SELECT EARN_CODE FROM EARNING ";
			preparedstatement= con.prepareStatement(selectQuery);
			 ResultSet rs = preparedstatement.executeQuery();
			 ArrayList<String> earnCodes= new ArrayList<String>();
			 while(rs.next())
				{
					earnCodes.add(rs.getString(1));
				}
				
			return earnCodes;
		}
	   public Earning displayEarning(String earnCode) throws SQLException{
			 
		  		   String query="select * from EARNING where EARN_CODE=?";
		   preparedstatement=con.prepareStatement(query);
		   preparedstatement.setString(1,earnCode);
		    ResultSet rs=preparedstatement.executeQuery();
		    Earning earning=null;
		    if(rs.next())
		    {
		    	earning=new Earning(rs.getString((1)),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getDouble(6));
		   
		   }
		    
		   return earning;
	   }
	   
	   public Earning getEarningDetailsByEarnCode(String earncode) throws SQLException {
			ResultSet rs ;
			String query = "SELECT * FROM EARNING WHERE EARN_CODE = ?" ;
			preparedstatement= con.prepareStatement(query);
			preparedstatement.setString(1, earncode);
		    rs = preparedstatement.executeQuery();
				rs.next();
		    return ( new Earning(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getDouble(6) ));
				}
		
	   public Earning getEarning (String earnCode) throws SQLException {
			Earning earning = null;
			String query = "select * from EARNING where EARN_CODE=?";
			preparedstatement = con.prepareStatement(query);
			preparedstatement.setString(1, earnCode);
			ResultSet rs = preparedstatement.executeQuery();
			
			while(rs.next()) {
				earning = new Earning(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getDouble(6));
			}
			
			return earning;
		}
	 
	
}
