package com.insurance.insuranceCompany.model;

import java.util.Date;

public class NetworkHospitals {
	private int hospId;
    private String hospTitle;
    private String hospLocation;
    private String hospAddress;
    private String hospContactNumber;
    private int hospPincode;
    private Date hospLuudate;
    private int hospLuuser;
    private String grade;
    private String facilities;
    
    
    public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public int getHospId() {
		return hospId;
	}
	public void setHospId(int hospId) {
		this.hospId = hospId;
	}
	public String getHospTitle() {
		return hospTitle;
	}
	public void setHospTitle(String hospTitle) {
		this.hospTitle = hospTitle;
	}
	public String getHospLocation() {
		return hospLocation;
	}
	public void setHospLocation(String hospLocation) {
		this.hospLocation = hospLocation;
	}
	public String getHospAddress() {
		return hospAddress;
	}
	public void setHospAddress(String hospAddress) {
		this.hospAddress = hospAddress;
	}
	public String getHospContactNumber() {
		return hospContactNumber;
	}
	public void setHospContactNumber(String hospContactNumber) {
		this.hospContactNumber = hospContactNumber;
	}
	public int getHospPincode() {
		return hospPincode;
	}
	public void setHospPincode(int hospPincode) {
		this.hospPincode = hospPincode;
	}
	public Date getHospLuudate() {
		return hospLuudate;
	}
	public void setHospLuudate(Date hospLuudate) {
		this.hospLuudate = hospLuudate;
	}
	public int getHospLuuser() {
		return hospLuuser;
	}
	public void setHospLuuser(int hospLuuser) {
		this.hospLuuser = hospLuuser;
	}
	@Override
	public String toString() {
		return "NetworkHospitals [hospId=" + hospId + ", hospTitle=" + hospTitle + ", hospLocation=" + hospLocation
				+ ", hospAddress=" + hospAddress + ", hospContactNumber=" + hospContactNumber + ", hospPincode="
				+ hospPincode + ", hospLuudate=" + hospLuudate + ", hospLuuser=" + hospLuuser + ", grade=" + grade
				+ ", facilities=" + facilities + "]";
	}
	

}
