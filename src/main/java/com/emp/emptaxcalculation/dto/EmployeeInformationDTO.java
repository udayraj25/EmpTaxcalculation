package com.emp.emptaxcalculation.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_DEFAULT)
public class EmployeeInformationDTO {

	private Long empId;
	private String fName;
	private String lName;
	private String emailId;
	private String contactNumber;
	private String altContactNumber;
	private String dateOfJoining;
	private Double salary;
	private Double finalTax;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAltContactNumber() {
		return altContactNumber;
	}

	public void setAltContactNumber(String altContactNumber) {
		this.altContactNumber = altContactNumber;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getFinalTax() {
		return finalTax;
	}

	public void setFinalTax(Double finalTax) {
		this.finalTax = finalTax;
	}

	@Override
	public String toString() {
		return "EmployeeInformationDTO [empId=" + empId + ", fName=" + fName + ", lName=" + lName + ", emailId="
				+ emailId + ", contactNumber=" + contactNumber + ", altContactNumber=" + altContactNumber
				+ ", dateOfJoining=" + dateOfJoining + ", salary=" + salary + ", finalTax=" + finalTax + "]";
	}

}
