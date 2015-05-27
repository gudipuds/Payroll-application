package com.adp.data;

import java.util.Date;

public class Employment {

	private String employeeCode;
	private Date emplHireDate;
	private Date emplTermDate;
	private String eeStatus;
	private String fullPartTime;
	private String permanentTemp;
	private String leavingReason;
	private int noticePeriod;
	private String noticePeriodUnit;
	private int probPeriod;
	private String probPeriodUnit;
	private String payFrequency;
	private String employerCode;
	public Employment(String employeeCode, Date emplHireDate,
			Date emplTermDate, String eeStatus, String fullPartTime,
			String permanentTemp, String leavingReason, int noticePeriod,
			String noticePeriodUnit, int probPeriod, String probPeriodUnit,
			String payFrequency, String employerCode) {
		super();
		this.employeeCode = employeeCode;
		this.emplHireDate = emplHireDate;
		this.emplTermDate = emplTermDate;
		this.eeStatus = eeStatus;
		this.fullPartTime = fullPartTime;
		this.permanentTemp = permanentTemp;
		this.leavingReason = leavingReason;
		this.noticePeriod = noticePeriod;
		this.noticePeriodUnit = noticePeriodUnit;
		this.probPeriod = probPeriod;
		this.probPeriodUnit = probPeriodUnit;
		this.payFrequency = payFrequency;
		this.employerCode = employerCode;
	}
	public Employment() {
		super();
		this.employeeCode = "";
		this.emplHireDate = new Date();
		this.emplTermDate = new Date();
		this.eeStatus = "";
		this.fullPartTime = "";
		this.permanentTemp = "";
		this.leavingReason = "";
		this.noticePeriod = 0;
		this.noticePeriodUnit = "";
		this.probPeriod = 0;
		this.probPeriodUnit = "";
		this.payFrequency = "";
		this.employerCode = "";
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public Date getEmplHireDate() {
		return emplHireDate;
	}
	public void setEmplHireDate(Date emplHireDate) {
		this.emplHireDate = emplHireDate;
	}
	public Date getEmplTermDate() {
		return emplTermDate;
	}
	public void setEmplTermDate(Date emplTermDate) {
		this.emplTermDate = emplTermDate;
	}
	public String getEeStatus() {
		return eeStatus;
	}
	public void setEeStatus(String eeStatus) {
		this.eeStatus = eeStatus;
	}
	public String getFullPartTime() {
		return fullPartTime;
	}
	public void setFullPartTime(String fullPartTime) {
		this.fullPartTime = fullPartTime;
	}
	public String getPermanentTemp() {
		return permanentTemp;
	}
	public void setPermanentTemp(String permanentTemp) {
		this.permanentTemp = permanentTemp;
	}
	public String getLeavingReason() {
		return leavingReason;
	}
	public void setLeavingReason(String leavingReason) {
		this.leavingReason = leavingReason;
	}
	public int getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public String getNoticePeriodUnit() {
		return noticePeriodUnit;
	}
	public void setNoticePeriodUnit(String noticePeriodUnit) {
		this.noticePeriodUnit = noticePeriodUnit;
	}
	public int getProbPeriod() {
		return probPeriod;
	}
	public void setProbPeriod(int probPeriod) {
		this.probPeriod = probPeriod;
	}
	public String getProbPeriodUnit() {
		return probPeriodUnit;
	}
	public void setProbPeriodUnit(String probPeriodUnit) {
		this.probPeriodUnit = probPeriodUnit;
	}
	public String getPayFrequency() {
		return payFrequency;
	}
	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}
	public String getEmployerCode() {
		return employerCode;
	}
	public void setEmployerCode(String employerCode) {
		this.employerCode = employerCode;
	}
	
	
	
	
}
