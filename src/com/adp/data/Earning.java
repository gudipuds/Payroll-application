package com.adp.data;

import java.util.Date;

public class Earning {
	
	private String earnCode;
	private String earnDesc;
	private Date earnStartDate;
	private Date earnEndDate;
	private String earnTaxability;
	private double earnDfltAmount;
	
	public Earning()
	{
		earnCode = "";
		earnDesc = "";
		earnStartDate = new Date();
		earnEndDate = new Date();
		earnTaxability = "";
		earnDfltAmount = 0;
	}
	public Earning(String earnCode, String earnDesc, Date earnStartDate,
			Date earnEndDate, String earnTaxability, double earnDfltAmount2) {
		super();
		this.earnCode = earnCode;
		this.earnDesc = earnDesc;
		this.earnStartDate = earnStartDate;
		this.earnEndDate = earnEndDate;
		this.earnTaxability = earnTaxability;
		this.earnDfltAmount = earnDfltAmount2;
	}
 
	
	public String getEarnCode() {
		return earnCode;
	}

	public void setEarnCode(String earnCode) {
		this.earnCode = earnCode;
	}

	public String getEarnDesc() {
		return earnDesc;
	}

	public void setEarnDesc(String earnDesc) {
		this.earnDesc = earnDesc;
	}

	public Date getEarnStartDate() {
		return earnStartDate;
	}

	public void setEarnStartDate(Date earnStartDate) {
		this.earnStartDate = earnStartDate;
	}

	public Date getEarnEndDate() {
		return earnEndDate;
	}

	public void setEarnEndDate(Date earnEndDate) {
		this.earnEndDate = earnEndDate;
	}

	public String getEarnTaxability() {
		return earnTaxability;
	}

	public void setEarnTaxability(String earnTaxability) {
		this.earnTaxability = earnTaxability;
	}

	public double getEarnDfltAmount() {
		return earnDfltAmount;
	}

	public void setEarnDfltAmount(double earnDfltAmount) {
		this.earnDfltAmount = earnDfltAmount;
	}


	@Override
	public String toString() {
		return "Earning [earnCode=" + earnCode + ", earnDesc=" + earnDesc
				+ ", earnDfltAmount=" + earnDfltAmount + ", earnEndDate="
				+ earnEndDate + ", earnStartDate=" + earnStartDate
				+ ", earnTaxability=" + earnTaxability + "]";
	}
	

}
