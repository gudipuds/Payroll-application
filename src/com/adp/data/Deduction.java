package com.adp.data;

import java.util.Date;

public class Deduction {
	
	private String dedCode;
	private String dedDesc;
	private Date dedStartDate;
	private Date dedEndDate;
	private String eeErCode;
	private String dedTaxability;
	private double dedDfltAmount;
	
	public Deduction(String dedCode, String dedDesc, Date dedStartDate,
			Date dedEndDate, String eeErCode, String  dedTaxability,
			double defaultamt) {
		super();
		this.dedCode = dedCode;
		this.dedDesc = dedDesc;
		this.dedStartDate = dedStartDate;
		this.dedEndDate = dedEndDate;
		this.eeErCode = eeErCode;
		this.dedTaxability = dedTaxability;
		this.dedDfltAmount = defaultamt;
	}
	
	
	
	
	public Deduction() {
		super();
		this.dedCode = "";
		this.dedDesc = "";
		this.dedStartDate = new Date() ;
		this.dedEndDate = new Date();
		this.eeErCode = "";
		this.dedTaxability = "";
		this.dedDfltAmount = 0;
		
		
	}




	public String getDedCode() {
		return dedCode;
	}
	public void setDedCode(String dedCode) {
		this.dedCode = dedCode;
	}
	public String getDedDesc() {
		return dedDesc;
	}
	public void setDedDesc(String dedDesc) {
		this.dedDesc = dedDesc;
	}
	public Date getDedStartDate() {
		return dedStartDate;
	}
	public void setDedStartDate(Date dedStartDate) {
		this.dedStartDate = dedStartDate;
	}
	public Date getDedEndDate() {
		return dedEndDate;
	}
	public void setDedEndDate(Date dedEndDate) {
		this.dedEndDate = dedEndDate;
	}
	public String getEeErCode() {
		return eeErCode;
	}
	public void setEeErCode(String eeErCode) {
		this.eeErCode = eeErCode;
	}
	public String  getDedTaxability() {
		return dedTaxability;
	}
	public void setDedTaxability(String  dedTaxability) {
		this.dedTaxability = dedTaxability;
	}
	public double getDedDfltAmount() {
		return dedDfltAmount;
	}
	public void setDedDfltAmount(double dedDfltAmount) {
		this.dedDfltAmount = dedDfltAmount;
	}
	@Override
	public String toString() {
		return "Deduction [dedCode=" + dedCode + ", dedDesc=" + dedDesc
				+ ", dedDfltAmount=" + dedDfltAmount + ", dedEndDate="
				+ dedEndDate + ", dedStartDate=" + dedStartDate
				+ ", dedTaxability=" + dedTaxability + ", eeErCode=" + eeErCode
				+ "]";
	}
	
	
}
