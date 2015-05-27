package com.adp.data;

public class Job {
	private String jobCode;
	private String jobTitle;
	private String jobDescription;
	public Job(){
		
	}
	
	public Job(String jobCode, String jobTitle, String jobDescription) {
		super();
		this.jobCode = jobCode;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
	}

	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	@Override
	public String toString() {
		return "JobCode [jobCode=" + jobCode + ", jobDescription="
				+ jobDescription + ", jobTitle=" + jobTitle + "]";
	}
	
	
	

}
