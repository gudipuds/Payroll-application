package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.NamingException;

import com.adp.data.PayCalendar;

public class PayCalendarDAO {
	ConnectionFactory connectionfactory;
	Connection connection;
	PreparedStatement pst;

	public PayCalendarDAO( ConnectionFactory connectionfactory) throws ClassNotFoundException, SQLException, NamingException {
		this.connectionfactory = connectionfactory ;
		connection = connectionfactory.getConnection() ;
	}
	
	public boolean insertPayCalendar(PayCalendar paycalendar) throws SQLException
	{	
		boolean ans = false;
		String insertQuery = "INSERT INTO PAY_CALENDAR VALUES(?,?,?,?,?,?,?,?,?)";
		pst=connection.prepareStatement(insertQuery);
		pst.setString(1, paycalendar.getPayFrequency());
		pst.setString(2, paycalendar.getTaxYear());
		pst.setInt(3, paycalendar.getPayPeriodNo());
		pst.setString(4, paycalendar.getTaxYearStart());
		pst.setString(5, paycalendar.getTaxYearEnd());
		pst.setDate(6, new java.sql.Date(paycalendar.getPayPeriodStart().getTime()));
		pst.setDate(7, new java.sql.Date(paycalendar.getPayPeriodEnd().getTime()));
		pst.setDate(8, new java.sql.Date(paycalendar.getPayDate().getTime()));
		pst.setDate(9,new java.sql.Date(paycalendar.getPayProcessDate().getTime()));
		int rst = pst.executeUpdate();
		if(rst > 0)
			ans = true;
		return ans;
	  }
	
	  public ResultSet displayPayCalendar(String payFrequency , String taxYear) throws SQLException
	  {
		 String selectQuery = "SELECT PAY_PERIOD_NO,PAY_PERIOD_START,PAY_PERIOD_END,PAY_DATE,PAY_PROCESS_DATE FROM PAY_CALENDAR WHERE PAY_FREQUENCY = ? and TAX_YEAR = ?";
		 pst= connection.prepareStatement(selectQuery);
		 pst.setString(1, payFrequency);
		 pst.setString(2,taxYear);
		 ResultSet rs = pst.executeQuery();
		return rs;
		  
	  }
	  
	  public boolean deletePayCalendar() throws SQLException {
		  boolean ans = false;
		  
		  String deleteQuery  = "delete from PAY_CALENDAR";
		  pst = connection.prepareStatement(deleteQuery);
		  
		  if( pst.executeUpdate() != -1)
		  {
			  ans = true;
		  }
		  
		  return ans;
	  }
	  public ArrayList<Date> getDates(int num) throws SQLException {
			System.out.println("100000000000");
			ArrayList<Date> arrDate = new ArrayList<Date>();
			String query = "select PAY_PERIOD_START,PAY_PERIOD_END from PAY_CALENDAR where PAY_PERIOD_NO=?";
			pst = connection.prepareStatement(query);
			pst.setInt(1, num);
			ResultSet rs = pst.executeQuery();
			System.out.println("12222222222");
			if(rs.next()) {
				arrDate.add(rs.getDate(1));
				arrDate.add(rs.getDate(2));
			}
			return arrDate;
		}
	
	
}
