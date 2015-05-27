package com.adp.data;

public class EmpLogin {
	
	private String employeeCode;
	private String pwd;
	
	public EmpLogin(String employeeCode, String pwd) {
		super();
		this.employeeCode = employeeCode;
		this.pwd = pwd;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
