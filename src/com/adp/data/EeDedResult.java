package com.adp.data;

public class EeDedResult {
	
	String employeeCode;
	String payFrequency;
	String taxYear;
	int payPeriodNo;
	String dedCode;
	double eeDedAmt;
	String dedTaxability;
	public EeDedResult( String employeeCode, String payFrequency,
			String taxYear, int payPeriodNo, String dedCode, double eeDedAmt,
			String dedTaxability) {
		super();
		this.employeeCode = employeeCode;
		this.payFrequency = payFrequency;
		this.taxYear = taxYear;
		this.payPeriodNo = payPeriodNo;
		this.dedCode = dedCode;
		this.eeDedAmt = eeDedAmt;
		this.dedTaxability = dedTaxability;
	}
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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
	public String getDedCode() {
		return dedCode;
	}
	public void setDedCode(String dedCode) {
		this.dedCode = dedCode;
	}
	public double getEeDedAmt() {
		return eeDedAmt;
	}
	public void setEeDedAmt(double eeDedAmt) {
		this.eeDedAmt = eeDedAmt;
	}
	public String getDedTaxability() {
		return dedTaxability;
	}
	public void setDedTaxability(String dedTaxability) {
		this.dedTaxability = dedTaxability;
	}
	
	@Override
	public String toString() {
		return "EeDedResult [dedCode=" + dedCode + ", dedTaxability="
				+ dedTaxability + ", eeDedAmt=" + eeDedAmt + ", employeeCode="
				+ employeeCode + ", payFrequency="
				+ payFrequency + ", payPeriodNo=" + payPeriodNo + ", taxYear="
				+ taxYear + "]";
	}
	
	
}
