package com.adp.data;

public class Position {
	
	
	private String posnId;
	private String posnTitle;
	private String posnStartDate;
	private String posnEndDate;
	private String posnStatusCode;
	private String jobCode;
	private String buCode;

	
	public Position(){
		
	}
	
	public Position(String posnId, String posnTitle, String posnStartDate,
			String posnEndDate, String posnStatusCode, String jobCode,
			String buCode) {
		super();
		this.posnId = posnId;
		this.posnTitle = posnTitle;
		this.posnStartDate = posnStartDate;
		this.posnEndDate = posnEndDate;
		this.posnStatusCode = posnStatusCode;
		this.jobCode = jobCode;
		this.buCode = buCode;
	}

	public String getPosnId() {
		return posnId;
	}

	public void setPosnId(String posnId) {
		this.posnId = posnId;
	}

	public String getPosnTitle() {
		return posnTitle;
	}

	public void setPosnTitle(String posnTitle) {
		this.posnTitle = posnTitle;
	}

	public String getPosnStartDate() {
		return posnStartDate;
	}

	public void setPosnStartDate(String posnStartDate) {
		this.posnStartDate = posnStartDate;
	}

	public String getPosnEndDate() {
		return posnEndDate;
	}

	public void setPosnEndDate(String posnEndDate) {
		this.posnEndDate = posnEndDate;
	}

	public String getPosnStatusCode() {
		return posnStatusCode;
	}

	public void setPosnStatusCode(String posnStatusCode) {
		this.posnStatusCode = posnStatusCode;
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
		return "Position [buCode=" + buCode + ", jobCode=" + jobCode
				+ ", posnEndDate=" + posnEndDate + ", posnId=" + posnId
				+ ", posnStartDate=" + posnStartDate + ", posnStatusCode="
				+ posnStatusCode + ", posnTitle=" + posnTitle + "]";
	}

	
	
	

}
