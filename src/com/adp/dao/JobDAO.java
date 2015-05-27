package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.adp.data.Job;

public class JobDAO {

	ConnectionFactory conf ;
	Connection con ;
	PreparedStatement pstm ;

	public JobDAO( ConnectionFactory conf) throws ClassNotFoundException, SQLException, NamingException {
		this.conf = conf ;
		con = conf.getConnection() ;
	}

	public boolean insertJob(Job job) throws SQLException {
		
		boolean ans = false;
		String query = "INSERT INTO JOB VALUES(?,?,?)" ;
		
		pstm = con.prepareStatement(query) ;
		pstm.setString(1,job.getJobCode());
		pstm.setString(2,job.getJobTitle());
		pstm.setString(3,job.getJobDescription());
		

		int result = pstm.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
						
	}
	
	public ResultSet selectAllJob() throws SQLException {
		
		ResultSet rs ;
		String query = "select * from JOB " ;
		pstm= con.prepareStatement(query);
	    	rs = pstm.executeQuery();
			
	        return rs;
						
	}

	public String getJobCodeByTitle(String jobTitle) throws SQLException {
		String selectQuery = "SELECT JOB_CODE FROM JOB WHERE JOB_TITLE = ?";
		 pstm= con.prepareStatement(selectQuery);
		 pstm.setString(1,jobTitle);
		 ResultSet rs = pstm.executeQuery();
		 rs.next();
		 String res = rs.getString(1);
	     return res;		
	}
	
}

