package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.adp.data.Appointment;

public class AppoinmentDAO {

	ConnectionFactory conf ;
	Connection con ;
	PreparedStatement pstm ;

	public AppoinmentDAO( ConnectionFactory conf) throws ClassNotFoundException, SQLException, NamingException {
		this.conf = conf ;
		con = conf.getConnection() ;
	}

	public boolean insertAppoinment(Appointment appoinment) throws SQLException {
		
		boolean ans = false;
		String query = "INSERT INTO APPOINMENT VALUES(?,?,?,?,?,?,?,?)" ;
		
		pstm = con.prepareStatement(query) ;
		pstm.setString(1,appoinment.getEmployeeCode());
		pstm.setString(2,appoinment.getapptNo());
		pstm.setDate(3,new java.sql.Date((appoinment.getApptStartDate()).getTime()));
		pstm.setDate(4,new java.sql.Date((appoinment.getApptEndDate()).getTime()));
		pstm.setString(5,appoinment.getBuCode());
		pstm.setString(6,appoinment.getJobCode());
		pstm.setString(7,appoinment.getPosnId());
		pstm.setString(8,appoinment.getReportsTo());
	
		pstm = con.prepareStatement(query) ;
		
		

		int result = pstm.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
						
	}
	
	
	public boolean UpdateAppoinment(Appointment appoinment) throws SQLException {
		
		boolean ans = false;
		
		String query = "UPDATE APPOINMENT SET APPT_START_DATE = ? , APPT_END_DATE = ? , BU_CODE = ? , JOB_CODE = ? , POSN_ID = ? , REPORTS_TO = ? WHERE EMPLOYEE_CODE = ? AND APPT_NO = ?" ;
		
		pstm = con.prepareStatement(query) ;
	
		pstm.setDate(1,new java.sql.Date((appoinment.getApptStartDate()).getTime()));
		pstm.setDate(2,new java.sql.Date((appoinment.getApptEndDate()).getTime()));
		pstm.setString(3,appoinment.getBuCode());
		pstm.setString(4,appoinment.getJobCode());
		pstm.setString(5,appoinment.getPosnId());
		pstm.setString(6,appoinment.getReportsTo());
		pstm.setString(7,appoinment.getEmployeeCode());
		pstm.setString(8,appoinment.getapptNo());
		pstm = con.prepareStatement(query) ;
		
		

		int result = pstm.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
						
	}
	
	
	
}
