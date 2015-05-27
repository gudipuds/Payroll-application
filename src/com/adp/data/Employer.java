package com.adp.data;

import java.util.Date;

public class Employer {

	private String employerCode;
	private String employerName;
	private Date erStartDate;
	private Date erEndDate;
	private String erAddLn1;
	private String erAddLn2;
	private String erAddLn3;
	private String erTown;
	private String erState;
	private String erCountry;
	private String erPostCode;
	private String erPhone;
	
	
	
	public Employer(String employerCode, String employerName,
			Date erStartDate, Date erEndDate, String erAddLn1,
			String erAddLn2, String erAddLn3, String erTown, String erState,
			String erCountry, String erPostCode, String erPhone) {
		super();
		this.employerCode = employerCode;
		this.employerName = employerName;
		this.erStartDate = erStartDate;
		this.erEndDate = erEndDate;
		this.erAddLn1 = erAddLn1;
		this.erAddLn2 = erAddLn2;
		this.erAddLn3 = erAddLn3;
		this.erTown = erTown;
		this.erState = erState;
		this.erCountry = erCountry;
		this.erPostCode = erPostCode;
		this.erPhone = erPhone;
	}
	
	
	public Employer() {
		super();
		this.employerCode = "";
		this.employerName = "";
		this.erStartDate = new Date();
		this.erEndDate = new Date();
		this.erAddLn1 = "";
		this.erAddLn2 = "";
		this.erAddLn3 = "";
		this.erTown = "";
		this.erState = "";
		this.erCountry = "";
		this.erPostCode = "";
		this.erPhone = "";
	}


	public String getEmployerCode() {
		return employerCode;
	}
	public void setEmployerCode(String employerCode) {
		this.employerCode = employerCode;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public Date getErStartDate() {
		return erStartDate;
	}
	public void setErStartDate(Date erStartDate) {
		this.erStartDate = erStartDate;
	}
	public Date getErEndDate() {
		return erEndDate;
	}
	public void setErEndDate(Date erEndDate) {
		this.erEndDate = erEndDate;
	}
	public String getErAddLn1() {
		return erAddLn1;
	}
	public void setErAddLn1(String erAddLn1) {
		this.erAddLn1 = erAddLn1;
	}
	public String getErAddLn2() {
		return erAddLn2;
	}
	public void setErAddLn2(String erAddLn2) {
		this.erAddLn2 = erAddLn2;
	}
	public String getErAddLn3() {
		return erAddLn3;
	}
	public void setErAddLn3(String erAddLn3) {
		this.erAddLn3 = erAddLn3;
	}
	public String getErTown() {
		return erTown;
	}
	public void setErTown(String erTown) {
		this.erTown = erTown;
	}
	public String getErState() {
		return erState;
	}
	public void setErState(String erState) {
		this.erState = erState;
	}
	public String getErCountry() {
		return erCountry;
	}
	public void setErCountry(String erCountry) {
		this.erCountry = erCountry;
	}
	public String getErPostCode() {
		return erPostCode;
	}
	public void setErPostCode(String erPostCode) {
		this.erPostCode = erPostCode;
	}
	public String getErPhone() {
		return erPhone;
	}
	public void setErPhone(String erPhone) {
		this.erPhone = erPhone;
	}
	
	
}
