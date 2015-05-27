package com.adp.data;


import java.util.Date;


public class EmployeeInfo {
	private String employeeCode;
	private String lastName;
	private String middleName;
	private String firstName;
	private String title;
	private Date birthDate;
	private String gender;
	private String maritalStatus;
	private String nationality;
	private String addLn1;
	private String addLn2;
	private String town;
	private String state;
	private String postCode;
	private String phone;
	
	public EmployeeInfo() {
		
		employeeCode = "";
		lastName = "";
		middleName = "";
		firstName = "";
		title = "";
		birthDate = new Date();
		gender = "";
		maritalStatus = "";
		nationality = "";
		addLn1 = "";
		addLn2 = "";
		town = "";
		state = "";
		postCode = "";
		phone = "";
	}

	public EmployeeInfo(String employeeCode, String lastName,
			String middleName, String firstName, String title,
			Date birthDate, String gender, String maritalStatus,
			String nationality, String addLn1, String addLn2, String town,
			String state, String postCode, String phone) {
		super();
		this.employeeCode = employeeCode;
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
		this.title = title;
		this.birthDate = birthDate;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.nationality = nationality;
		this.addLn1 = addLn1;
		this.addLn2 = addLn2;
		this.town = town;
		this.state = state;
		this.postCode = postCode;
		this.phone = phone;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddLn1() {
		return addLn1;
	}

	public void setAddLn1(String addLn1) {
		this.addLn1 = addLn1;
	}

	public String getAddLn2() {
		return addLn2;
	}

	public void setAddLn2(String addLn2) {
		this.addLn2 = addLn2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {

		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [addLn1=" + addLn1 + ", addLn2=" + addLn2
				+ ", birthDate=" + birthDate + ", employeeCode=" + employeeCode
				+ ", firstName=" + firstName + ", gender=" + gender
				+ ", lastName=" + lastName + ", maritalStatus=" + maritalStatus
				+ ", middleName=" + middleName + ", nationality=" + nationality
				+ ", phone=" + phone + ", postCode=" + postCode + ", state="
				+ state + ", title=" + title + ", town=" + town + "]";
	}
	
    
}
