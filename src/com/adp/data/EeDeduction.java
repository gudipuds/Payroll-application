package com.adp.data;

import java.util.Date;

public class EeDeduction {

	private String employeeCode;
	private String dedCode;
	private Date eeDedStartDate;
	private Date eeDedEndDate;
	private String eeDedStatusCode;
	private double eeDedDfltAmt;
	
	public EeDeduction(String employeeCode, String dedCode,
			Date eeDedStartDate, Date eeDedEndDate, String eeDedStatusCode,
			double eeDedDfltAmt) {
		super();
		this.employeeCode = employeeCode;
		this.dedCode = dedCode;
		this.eeDedStartDate = eeDedStartDate;
		this.eeDedEndDate = eeDedEndDate;
		this.eeDedStatusCode = eeDedStatusCode;
		this.eeDedDfltAmt = eeDedDfltAmt;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDedCode() {
		return dedCode;
	}

	public void setDedCode(String dedCode) {
		this.dedCode = dedCode;
	}

	public Date getEeDedStartDate() {
		return eeDedStartDate;
	}

	public void setEeDedStartDate(Date eeDedStartDate) {
		this.eeDedStartDate = eeDedStartDate;
	}

	public Date getEeDedEndDate() {
		return eeDedEndDate;
	}

	public void setEeDedEndDate(Date eeDedEndDate) {
		this.eeDedEndDate = eeDedEndDate;
	}

	public String getEeDedStatusCode() {
		return eeDedStatusCode;
	}

	public void setEeDedStatusCode(String eeDedStatusCode) {
		this.eeDedStatusCode = eeDedStatusCode;
	}

	public double getEeDedDfltAmt() {
		return eeDedDfltAmt;
	}

	public void setEeDedDfltAmt(double eeDedDfltAmt) {
		this.eeDedDfltAmt = eeDedDfltAmt;
	}

	@Override
	public String toString() {
		return "EeDeduction [dedCode=" + dedCode + ", eeDedDfltAmt="
				+ eeDedDfltAmt + ", eeDedEndDate=" + eeDedEndDate
				+ ", eeDedStartDate=" + eeDedStartDate + ", eeDedStatusCode="
				+ eeDedStatusCode + ", employeeCode=" + employeeCode + "]";
	}
	
	
	
}
