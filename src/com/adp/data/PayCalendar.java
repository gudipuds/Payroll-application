package com.adp.data;

import java.util.Date;

public class PayCalendar {
	private String payFrequency;
	private String taxYear;
	private int payPeriodNo;
	private String taxYearStart;			
	private String taxYearEnd;
	private Date payPeriodStart;
	private Date payPeriodEnd;
	private Date payDate;
	private Date payProcessDate;
	public PayCalendar(String payFrequency, String taxYear, int payPeriodNo,
			String taxYearStart, String taxYearEnd, Date payPeriodStart,
			Date payPeriodEnd, Date payDate, Date payProcessDate) {
		super();
		this.payFrequency = payFrequency;
		this.taxYear = taxYear;
		this.payPeriodNo = payPeriodNo;
		this.taxYearStart = taxYearStart;
		this.taxYearEnd = taxYearEnd;
		this.payPeriodStart = payPeriodStart;
		this.payPeriodEnd = payPeriodEnd;
		this.payDate = payDate;
		this.payProcessDate = payProcessDate;
	}
	
	
	
	
	
	public PayCalendar() {
		super();
		this.payFrequency = "";
		this.taxYear = "";
		this.payPeriodNo = 0;
		this.taxYearStart = "";
		this.taxYearEnd = "";
		this.payPeriodStart = new Date();
		this.payPeriodEnd = new Date();
		this.payDate = new Date();
		this.payProcessDate = new Date();
	}





	public String getPayFrequency() {
		return payFrequency;
	}
	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}
	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	public int getPayPeriodNo() {
		return payPeriodNo;
	}
	public void setPayPeriodNo(int payPeriodNo) {
		this.payPeriodNo = payPeriodNo;
	}
	public String getTaxYearStart() {
		return taxYearStart;
	}
	public void setTaxYearStart(String taxYearStart) {
		this.taxYearStart = taxYearStart;
	}
	public String getTaxYearEnd() {
		return taxYearEnd;
	}
	public void setTaxYearEnd(String taxYearEnd) {
		this.taxYearEnd = taxYearEnd;
	}
	public Date getPayPeriodStart() {
		return payPeriodStart;
	}
	public void setPayPeriodStart(Date payPeriodStart) {
		this.payPeriodStart = payPeriodStart;
	}
	public Date getPayPeriodEnd() {
		return payPeriodEnd;
	}
	public void setPayPeriodEnd(Date payPeriodEnd) {
		this.payPeriodEnd = payPeriodEnd;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getPayProcessDate() {
		return payProcessDate;
	}
	public void setPayProcessDate(Date payProcessDate) {
		this.payProcessDate = payProcessDate;
	}
	
	

}
