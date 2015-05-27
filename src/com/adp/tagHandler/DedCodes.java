package com.adp.tagHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.DeductionDao;

public class DedCodes extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		ConnectionFactory conFactory = new ConnectionFactory();
		System.out.println("hsdfasdfi");

		
		 try {
			DeductionDao ddao = new DeductionDao(conFactory); 

			ArrayList<String> dedCodes = ddao.getDedCodes();
			

			for(String c : dedCodes)
			 {
				System.out.println("hi");
				 out.print("<option>"+c+"</option>");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return super.doStartTag();
	}
	
}
