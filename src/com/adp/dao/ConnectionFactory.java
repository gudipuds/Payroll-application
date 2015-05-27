package com.adp.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.* ;
import javax.sql.DataSource;


public class ConnectionFactory {

	Connection con;
	DataSource ds;
	Context ctx;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {

		ctx = new InitialContext();
		if ( ctx == null ) {
			throw new RuntimeException("JNDI Context could not be found.");
			}

		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ADPDB2");
		con = ds.getConnection() ;
		if ( ds == null ) {
			throw new RuntimeException("DataSource could not be found.");
			}

		return con;
	}

}