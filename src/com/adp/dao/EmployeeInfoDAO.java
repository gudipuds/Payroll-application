package com.adp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.adp.data.EmployeeInfo;

public class EmployeeInfoDAO {

	ConnectionFactory conf ;
	Connection con ;
	PreparedStatement pstm ;

	public EmployeeInfoDAO( ConnectionFactory conf) throws ClassNotFoundException, SQLException, NamingException {
		this.conf = conf ;
		con = conf.getConnection() ;
	}

	public boolean insertEmployeeInfo(EmployeeInfo employeeinfo) throws SQLException {
	
		boolean ans = false;
		String query = "INSERT INTO EMPLOYEE_INFO VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
		
		pstm = con.prepareStatement(query) ;
		pstm.setString(1,employeeinfo.getEmployeeCode());
		pstm.setString(2,employeeinfo.getLastName());
		pstm.setString(3,employeeinfo.getMiddleName());
		pstm.setString(4,employeeinfo.getFirstName());
		pstm.setString(5,employeeinfo.getTitle());
     	pstm.setDate(6,new java.sql.Date((employeeinfo.getBirthDate()).getTime()));
    	pstm.setString(7,employeeinfo.getGender());
		pstm.setString(8,employeeinfo.getMaritalStatus());
		pstm.setString(9,employeeinfo.getNationality());
		pstm.setString(10,employeeinfo.getAddLn1());
		pstm.setString(11,employeeinfo.getAddLn2());
		pstm.setString(12,employeeinfo.getTown());
		pstm.setString(13,employeeinfo.getState());
		pstm.setString(14,employeeinfo.getPostCode());
		pstm.setString(15,employeeinfo.getPhone());

		
		
		
		
        int result;
		result = pstm.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
						
	}
	
	
	public boolean UpdateEmployeeInfo(EmployeeInfo employeeinfo) throws SQLException {
		
		boolean ans = false;
		
		String query = "UPDATE EMPLOYEE_INFO SET LAST_NAME = ? , MIDDLE_NAME = ? , FIRST_NAME = ? , TITLE = ? , BIRTH_DATE = ? , GENDER = ? , MARTIAL_STATUS = ? , NATIONALITY= ? , ADD_LN1 = ? , Add_LN2 = ? , TOWN = ? ,STATE = ? , POSTCODE = ? ,PHONE = ? WHERE EMPLOYEE_CODE = ?" ;
		
		pstm = con.prepareStatement(query) ;
	
		pstm.setString(1,employeeinfo.getLastName());
		pstm.setString(2,employeeinfo.getMiddleName());
		pstm.setString(3,employeeinfo.getFirstName());
		pstm.setString(4,employeeinfo.getTitle());
     	pstm.setDate(5,new java.sql.Date((employeeinfo.getBirthDate()).getTime()));
     	pstm.setString(6,employeeinfo.getGender());
		pstm.setString(7,employeeinfo.getMaritalStatus());
		pstm.setString(8,employeeinfo.getNationality());
		pstm.setString(9,employeeinfo.getAddLn1());
		pstm.setString(10,employeeinfo.getAddLn2());
		pstm.setString(11,employeeinfo.getTown());
		pstm.setString(12,employeeinfo.getState());
		pstm.setString(13,employeeinfo.getPostCode());
		pstm.setString(14,employeeinfo.getPhone());
		
		pstm.setString(15,employeeinfo.getEmployeeCode());


		int result = pstm.executeUpdate() ;
		if(result > 0)
			ans = true;
		
		return ans;
						
	}
	
	public EmployeeInfo selectAllEmployeeInfo() throws SQLException {
		
		ResultSet rs ;
		String query = "SELECT * FROM EMPLOYEE_INFO " ;
		pstm= con.prepareStatement(query);
	    rs = pstm.executeQuery();
			
	    return (new EmployeeInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
						
	}
	
	public EmployeeInfo getEmployeeInfoByCode(String ecode) throws SQLException {
		
		ResultSet rs ;
		String query = "SELECT * FROM EMPLOYEE_INFO WHERE EMPLOYEE_CODE = ?" ;
		pstm= con.prepareStatement(query);
		pstm.setString(1, ecode);
	    rs = pstm.executeQuery();
			rs.next();
	    return (new EmployeeInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
						
	}

	
	public EmployeeInfo selectEmployeeInfoByID(String employeeCode) throws SQLException {
		
		ResultSet rs ;
		String query = "SELECT * FROM  EMPLOYEE_INFO WHERE EMPLOYEE_CODE = ?" ;
		pstm= con.prepareStatement(query);
		pstm.setString(1,employeeCode);
	    rs = pstm.executeQuery();
			
	    return (new EmployeeInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
		
						
	}
	
	public boolean deleteEmployeeInfo(String employeeCode) throws SQLException {
		int ans;
		boolean state=false;
		String query = "DELETE  FROM  EMPLOYEE_INFO WHERE EMPLOYEE_CODE = ?" ;
		pstm= con.prepareStatement(query);
		pstm.setString(1,employeeCode);
	    ans=pstm.executeUpdate() ;
        if(ans>0)
        {
        	state=true;
        }
	    return state;
	}
	
	public ArrayList<String> getEmpCodes() throws SQLException {
		String selectQuery = "SELECT EMPLOYEE_CODE FROM EMPLOYEE_INFO ";
		 pstm= con.prepareStatement(selectQuery);
		 ResultSet rs = pstm.executeQuery();
		 ArrayList<String> empCodes= new ArrayList<String>();
		 while(rs.next())
			{
				empCodes.add(rs.getString(1));
			}
			
		return empCodes;
	}
}
