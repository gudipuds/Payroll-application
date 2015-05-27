package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.adp.data.Admin;

public class AdminDAO {
	ConnectionFactory conf ;
	Connection con ;
	PreparedStatement pst ;

	public AdminDAO( ConnectionFactory conf) throws ClassNotFoundException, SQLException, NamingException {
		this.conf = conf ;
		con = conf.getConnection() ;
	}
	
	public boolean validateLogin(Admin admin) throws SQLException {
		String query = "Select * from admin where usr_nm=?" ;
		boolean ans = false ;
		
		pst = con.prepareStatement(query) ;
		pst.setString(1,admin.getUsr_nm()) ;
		
		ResultSet rs = pst.executeQuery() ;
		if(rs.next()){
			if((admin.getPwd()).equals(rs.getString(2)))
				ans = true;
		}		
		return ans ;
	}
	
	public boolean createEmployer(Admin admin) throws SQLException{
		boolean ans = false;;
		String query="insert into admin values(?,?)";
		pst = con.prepareStatement(query);
		pst.setString(1, admin.getUsr_nm());
		pst.setString(2, admin.getPwd());
		int a = pst.executeUpdate();
		if(a > 0)
			ans = true;
		
		return ans;
	}
	public boolean showUsers() throws SQLException{
		boolean ans = false;
		String query="select * from admin";
		pst=con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
			ans = true;
		
		return ans;
	}
}