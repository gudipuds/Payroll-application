package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.adp.data.Position;

public class PositionDAO {

	ConnectionFactory conf ;
	Connection con ;
	PreparedStatement pst ;

	public PositionDAO( ConnectionFactory conf) throws ClassNotFoundException, SQLException, NamingException {
		this.conf = conf ;
		con = conf.getConnection() ;
	}

	public boolean insert(Position position) throws SQLException {
		
		boolean ans = false;
		String query = "INSERT INTO POSITION VALUES(?,?,?,?,?,?,?)" ;
		
		pst = con.prepareStatement(query) ;
		pst.setString(1,position.getBuCode());
		pst.setString(2,position.getJobCode());
		pst.setString(3,position.getPosnId());
		pst.setString(4,position.getPosnTitle());
		pst.setString(5,position.getPosnStartDate());
		pst.setString(6,position.getPosnEndDate());
		pst.setString(7,position.getPosnStatusCode());

		
		int result = pst.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
	}	
	
	
	public ResultSet selectAllPosition() throws SQLException {
		
		ResultSet rs ;
		String query = "select * from POSITION " ;
		pst= con.prepareStatement(query);
	    rs = pst.executeQuery();
			
	    return rs;
						
	}
	
	

	
}
