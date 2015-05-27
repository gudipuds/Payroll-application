package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.adp.data.EmpLogin;

public class EmpLoginDAO {
	ConnectionFactory conf ;
	Connection con ;
	PreparedStatement pst ;

	public EmpLoginDAO( ConnectionFactory conf) throws ClassNotFoundException, SQLException, NamingException {
		this.conf = conf ;
		con = conf.getConnection() ;
	}
	
	public boolean validateLogin(EmpLogin elogin) throws SQLException {
		String query = "Select * from empLogin where EMPLOYEE_CODE=?";
		boolean ans = false ;
		
		pst = con.prepareStatement(query) ;
		pst.setString(1,elogin.getEmployeeCode()) ;
		
		ResultSet rs = pst.executeQuery() ;
		if(rs.next()){
			if((elogin.getPwd()).equals(rs.getString(2)))
				ans = true;
		}		
		return ans ;
	}
	
	public boolean createAccount(EmpLogin elogin) throws SQLException{
		boolean ans = false;
		String query = "insert into empLogin values(?,?)";
		
		pst = con.prepareStatement(query) ;
		pst.setString(1, elogin.getEmployeeCode());
		pst.setString(2, elogin.getPwd());
		
		int a = pst.executeUpdate();
		if( a > 0 )
			ans = true;
		
		return ans;
	}

}
