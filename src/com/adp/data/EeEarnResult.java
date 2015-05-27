package com.adp.data;

public class EeEarnResult {

	private String employeeCode;
	private String payFrequency;
	private String taxYear;
	private int payPeriodNo;
	private String earnCode;
	private double eeEarnAmt;
	private String eeTaxability;
	public EeEarnResult(String employeeCode, String payFrequency, String taxYear,
			int payPeriodNo, String earnCode, double eeEarnAmt,
			String eeTaxability) {
		super();
		this.employeeCode = employeeCode;
		this.payFrequency = payFrequency;
		this.taxYear = taxYear;
		this.payPeriodNo = payPeriodNo;
		this.earnCode = earnCode;
		this.eeEarnAmt = eeEarnAmt;
		this.eeTaxability = eeTaxability;
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
	public String getEarnCode() {
		return earnCode;
	}
	public void setEarnCode(String earnCode) {
		this.earnCode = earnCode;
	}
	public double getEeEarnAmt() {
		return eeEarnAmt;
	}
	public void setEeEarnAmt(double eeEarnAmt) {
		this.eeEarnAmt = eeEarnAmt;
	}
	public String getEeTaxability() {
		return eeTaxability;
	}
	public void setEeTaxability(String eeTaxability) {
		this.eeTaxability = eeTaxability;
	}
	@Override
	public String toString() {
		return "EeEarnResult [earnCode=" + earnCode + ", eeEarnAmt="
				+ eeEarnAmt + ", eeTaxability=" + eeTaxability
				+ ", employeeCode=" + employeeCode + ", payFrequency="
				+ payFrequency + ", payPeriodNo=" + payPeriodNo + ", taxYear="
				+ taxYear + "]";
	}
	
}
