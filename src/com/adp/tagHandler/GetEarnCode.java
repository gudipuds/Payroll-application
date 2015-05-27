package com.adp.tagHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.adp.dao.ConnectionFactory;
import com.adp.dao.EarningDao;


public class GetEarnCode extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		ConnectionFactory conFactory = new ConnectionFactory();
	

		
		 try {
			EarningDao edao = new EarningDao(conFactory);
			

			ArrayList<String> earnCodes = edao.getEarnCodes();
			

			for(String c : earnCodes)
			 {
				
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
