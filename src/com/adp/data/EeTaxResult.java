package com.adp.data;

public class EeTaxResult {
	private String employeeCode;
	private String payFrequency;
	private String taxYear;
	private int payPeriodNo;
	private double taxableWageAmt;
	private double taxAmt;
	public EeTaxResult(String employeeCode, String payFrequency,
			String taxYear, int payPeriodNo, double taxableWageAmt,
			double taxAmt) {
		super();
		this.employeeCode = employeeCode;
		this.payFrequency = payFrequency;
		this.taxYear = taxYear;
		this.payPeriodNo = payPeriodNo;
		this.taxableWageAmt = taxableWageAmt;
		this.taxAmt = taxAmt;
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
	public double getTaxableWageAmt() {
		return taxableWageAmt;
	}
	public void setTaxableWageAmt(double taxableWageAmt) {
		this.taxableWageAmt = taxableWageAmt;
	}
	public double getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(double taxAmt) {
		this.taxAmt = taxAmt;
	}
	

}
