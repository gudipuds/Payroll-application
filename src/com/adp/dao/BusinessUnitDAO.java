package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.adp.data.BusinessUnit;

public class BusinessUnitDAO {

	ConnectionFactory conf ;
	Connection con ;
	PreparedStatement pst ;

	public BusinessUnitDAO( ConnectionFactory conf) throws ClassNotFoundException, SQLException, NamingException {
		this.conf = conf ;
		con = conf.getConnection() ;
	}

	public boolean insert(BusinessUnit businessunit) throws SQLException {
		
		boolean ans = false;
		String query = "INSERT INTO BUSINESS_UNIT VALUES(?,?,?,?,?,?)" ;
		
		pst = con.prepareStatement(query) ;
		pst.setString(1,businessunit.getBuCode());
		pst.setString(2,businessunit.getBuName());
		pst.setDate(3,new java.sql.Date((businessunit.getBuEfficientFrom()).getTime()) );
		pst.setDate(4,new java.sql.Date((businessunit.getBuEfficientTo()).getTime()));
		pst.setString(5,businessunit.getBuType());
		pst.setString(6,businessunit.getBuParent());


		
		int result = pst.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
						
	}

	public String getBuCodeByName(String buName) throws SQLException {
		String selectQuery = "SELECT BU_CODE FROM BUSINESS_UNIT WHERE BU_NAME = ?";
		 pst= con.prepareStatement(selectQuery);
		 pst.setString(1,buName);
		 ResultSet rs = pst.executeQuery();
		 rs.next();
		 String res = rs.getString(1);
	     return res;
	}
	
	public boolean Update(BusinessUnit businessunit) throws SQLException {
		
		boolean ans = false;
		String query = "UPDATE BUSINESS_UNIT SET BU_NAME = ? , BU_EFFECTIVE_FROM = ? , BU_EFFECTIVE_TO = ? , BU_TYPE = ? , BU_TYPE = ? , BU_PARENT = ? WHERE BU_CODE = ?" ;
		
		pst = con.prepareStatement(query) ;
		
		pst.setString(1,businessunit.getBuName());
		pst.setDate(2,new java.sql.Date((businessunit.getBuEfficientFrom()).getTime()) );
		pst.setDate(3,new java.sql.Date((businessunit.getBuEfficientTo()).getTime()));
		pst.setString(4,businessunit.getBuType());
		pst.setString(5,businessunit.getBuParent());

		pst.setString(6,businessunit.getBuCode());

		
		int result = pst.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
						
	}
	
	
	
	public ArrayList<String> getAllBUNames(String buName) throws SQLException {
		 String selectQuery = "SELECT BU_NAME FROM BUSINESS_UNIT";
		 pst= con.prepareStatement(selectQuery);
		 ResultSet rs = pst.executeQuery();
		 
	     ArrayList<String> res = null;
	     while(rs.next())
	    	 res.add(rs.getString("BU_NAME"));  
		
	     return res;
	}
}
