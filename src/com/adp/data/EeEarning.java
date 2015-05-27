package com.adp.data;

import java.util.Date;

public class EeEarning {

	private String employeeCode;
	private String earnCode;
	private Date eeEarnStartDate;
	private Date eeEarnEndDate;
	private String eeEarnStatusCode;
	private double eeEarnDfltAmt;
	public EeEarning(String employeeCode, String earnCode,
			Date eeEarnStartDate, Date eeEarnEndDate,
			String eeEarnStatusCode, double eeEarnDfltAmt) {
		super();
		this.employeeCode = employeeCode;
		this.earnCode = earnCode;
		this.eeEarnStartDate = eeEarnStartDate;
		this.eeEarnEndDate = eeEarnEndDate;
		this.eeEarnStatusCode = eeEarnStatusCode;
		this.eeEarnDfltAmt = eeEarnDfltAmt;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEarnCode() {
		return earnCode;
	}
	public void setEarnCode(String earnCode) {
		this.earnCode = earnCode;
	}
	public Date getEeEarnStartDate() {
		return eeEarnStartDate;
	}
	public void setEeEarnStartDate(Date eeEarnStartDate) {
		this.eeEarnStartDate = eeEarnStartDate;
	}
	public Date getEeEarnEndDate() {
		return eeEarnEndDate;
	}
	public void setEeEarnEndDate(Date eeEarnEndDate) {
		this.eeEarnEndDate = eeEarnEndDate;
	}
	public String getEeEarnStatusCode() {
		return eeEarnStatusCode;
	}
	public void setEeEarnStatusCode(String eeEarnStatusCode) {
		this.eeEarnStatusCode = eeEarnStatusCode;
	}
	public double getEeEarnDfltAmt() {
		return eeEarnDfltAmt;
	}
	public void setEeEarnDfltAmt(double eeEarnDfltAmt) {
		this.eeEarnDfltAmt = eeEarnDfltAmt;
	}
	
	@Override
	public String toString() {
		return "EeEarning [earnCode=" + earnCode + ", eeEarnDfltAmt="
				+ eeEarnDfltAmt + ", eeEarnEndDate=" + eeEarnEndDate
				+ ", eeEarnStartDate=" + eeEarnStartDate
				+ ", eeEarnStatusCode=" + eeEarnStatusCode + ", employeeCode="
				+ employeeCode + "]";
	}
	
	
	
}
