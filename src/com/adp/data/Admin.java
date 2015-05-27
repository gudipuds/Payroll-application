package com.adp.data;

public class Admin {

	private String usr_nm;
	private String pwd;
	public Admin(String usrNm, String pwd) {
		super();
		usr_nm = usrNm;
		this.pwd = pwd;
	}
	public String getUsr_nm() {
		return usr_nm;
	}
	public void setUsr_nm(String usrNm) {
		usr_nm = usrNm;
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
