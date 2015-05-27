package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.adp.data.Employer;

public class EmployerDAO {
	ConnectionFactory connectionfactory;
	Connection connection;
	PreparedStatement pst;

	public EmployerDAO( ConnectionFactory connectionfactory) throws ClassNotFoundException, SQLException, NamingException {
		this.connectionfactory = connectionfactory ;
		connection = connectionfactory.getConnection() ;
	}
	
	public boolean insertEmployer(Employer employer) throws SQLException 
	{
		boolean ans = false;;
		String insertQuery="INSERT INTO EMPLOYER VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(insertQuery);
		pst.setString(1, employer.getEmployerCode());
		pst.setString(2, employer.getEmployerName());
		pst.setDate(3, new java.sql.Date((employer.getErStartDate()).getTime()) );
		pst.setDate(4, new java.sql.Date((employer.getErEndDate()).getTime()));
		pst.setString(5, employer.getErAddLn1());
		pst.setString(6, employer.getErAddLn2());
		pst.setString(7, employer.getErAddLn3());
		pst.setString(8, employer.getErTown());
		pst.setString(9, employer.getErState());
		pst.setString(10, employer.getErCountry());
		pst.setString(11, employer.getErPostCode());
		pst.setString(12, employer.getErPhone());
		int rst = pst.executeUpdate();
		if(rst > 0)
			ans = true;
		return ans;
		
	}
	
	public boolean updateEmployer(Employer employer) throws SQLException
	{
		boolean ans = false;
		String updateQuery="Update EMPLOYER set EMPLOYER_NAME = ? ,ER_START_DATE = ? ,ER_END_DATE= ? ,ER_ADD_LN1 = ? , ER_ADD_LN2 = ? ,ER_ADD_LN3 =?,ER_TOWN = ? , ER_STATE=? ,ER_COUNTRY = ? ,ER_POSTCODE=? ,ER_PHONE= ? where EMPLOYER_CODE = ?";
		pst = connection.prepareStatement(updateQuery);
		pst.setString(1, employer.getEmployerName());
		pst.setDate(3, new java.sql.Date((employer.getErStartDate()).getTime()) );
		pst.setDate(4, new java.sql.Date((employer.getErEndDate()).getTime()));
		pst.setString(4, employer.getErAddLn1());
		pst.setString(5, employer.getErAddLn2());
		pst.setString(6, employer.getErAddLn3());
		pst.setString(7, employer.getErTown());
		pst.setString(8, employer.getErState());
		pst.setString(9, employer.getErCountry());
		pst.setString(10, employer.getErPostCode());
		pst.setString(11, employer.getErPhone());
		pst.setString(12, employer.getEmployerCode());
		int rst = pst.executeUpdate();

		if(rst > 0)
			ans = true;
		return ans;
		
	
	}
	
	public Employer showAllDetails() throws SQLException {
				
		String selectQuery  = "select * from EMPLOYER";
		pst = connection.prepareStatement(selectQuery);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return (new Employer(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
		
	}
	
	
	

}
