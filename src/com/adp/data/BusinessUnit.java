package com.adp.data;

import java.util.Date;

public class BusinessUnit {
	
	
	private String buCode;
	private String buName;
	private Date buEfficientFrom;
	private Date buEfficientTo;
	private String buType;
	private String buParent;
	public  BusinessUnit(){
	}
	
	public BusinessUnit(String buCode, String buName, Date effectiveFrom,
			Date effectiveTo, String buType, String buParent) {
		super();
		this.buCode = buCode;
		this.buName = buName;
		this.buEfficientFrom = effectiveFrom;
		this.buEfficientTo = effectiveTo;
		this.buType = buType;
		this.buParent = buParent;
	}
	

	

	public String getBuCode() {
		return buCode;
	}
	public void setBuCode(String buCode) {
		this.buCode = buCode;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public Date getBuEfficientFrom() {
		return buEfficientFrom;
	}
	public void setBuEfficientFrom(Date buEfficientFrom) {
		this.buEfficientFrom = buEfficientFrom;
	}
	public Date getBuEfficientTo() {
		return buEfficientTo;
	}
	public void setBuEfficientTo(Date buEfficientTo) {
		this.buEfficientTo = buEfficientTo;
	}
	public String getBuType() {
		return buType;
	}
	public void setBuType(String buType) {
		this.buType = buType;
	}
	public String getBuParent() {
		return buParent;
	}
	public void setBuParent(String buParent) {
		this.buParent = buParent;
	}
	@Override
	public String toString() {
		return "BusinessUnit [buCode=" + buCode + ", buEfficientFrom="
				+ buEfficientFrom + ", buEfficientTo=" + buEfficientTo
				+ ", buName=" + buName + ", buParent=" + buParent + ", buType="
				+ buType + "]";
	}
	
	

}
