package com.adp.data;

import java.util.Date;

public class Appointment {
	private String employeeCode;
	private String apptNo;
	private Date apptStartDate;
	private Date apptEndDate;
	private String reportsTo;
	private String posnId;
	private String jobCode;
	private String buCode;
	
	public Appointment() {
		
	}

	public Appointment(String employeeCode, String apptNo,
			Date effectiveFrom, Date effectiveTo, String reportsTo,
			String posnId, String jobCode, String buCode) {
		super();
		this.employeeCode = employeeCode;
		this.apptNo = apptNo;
		this.apptStartDate = effectiveFrom;
		this.apptEndDate = effectiveTo;
		this.reportsTo = reportsTo;
		this.posnId = posnId;
		this.jobCode = jobCode;
		this.buCode = buCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getapptNo() {
		return apptNo;
	}

	public void setapptNo(String apptNo) {
		this.apptNo = apptNo;
	}

	public Date getApptStartDate() {
		return apptStartDate;
	}

	public void setApptStartDate(Date apptStartDate) {
		this.apptStartDate = apptStartDate;
	}

	public Date getApptEndDate() {
		return apptEndDate;
	}

	public void setApptEndDate(Date apptEndDate) {
		this.apptEndDate = apptEndDate;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getPosnId() {
		return posnId;
	}

	public void setPosnId(String posnId) {
		this.posnId = posnId;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getBuCode() {
		return buCode;
	}

	public void setBuCode(String buCode) {
		this.buCode = buCode;
	}

	@Override
	public String toString() {
		return "Appointment [apptEndDate=" + apptEndDate + ", apptStartDate="
				+ apptStartDate + ", apptNo=" + apptNo + ", buCode=" + buCode
				+ ", employeeCode=" + employeeCode + ", jobCode=" + jobCode
				+ ", posnId=" + posnId + ", reportsTo=" + reportsTo + "]";
	}
	
	
	
	
	

}
