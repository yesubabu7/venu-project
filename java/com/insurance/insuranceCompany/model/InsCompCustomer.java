package com.insurance.insuranceCompany.model;

import java.util.Date;

public class InsCompCustomer {
	private int custId;
	private String custFName;
	private String custLName;
	private Date custDob;
	private String custAddress;
	private char custGender;
	private Date custCDate;
	private int custUserId;
	private long custAadhar;
	private String custStatus;
	private Date custLuUDate;
	private int custLuUser;

	public InsCompCustomer() {
		super();
	}

	public InsCompCustomer(int custId, String custFName, String custLName, Date custDob, String custAddress,
			char custGender, Date custCDate, int custUserId, long custAadhar, String custStatus, Date custLuUDate,
			int custLuUser) {
		super();
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.custDob = custDob;
		this.custAddress = custAddress;
		this.custGender = custGender;
		this.custCDate = custCDate;
		this.custUserId = custUserId;
		this.custAadhar = custAadhar;
		this.custStatus = custStatus;
		this.custLuUDate = custLuUDate;
		this.custLuUser = custLuUser;
	}

	@Override
	public String toString() {
		return "InsCompCustomer [custId=" + custId + ", custFName=" + custFName + ", custLName=" + custLName
				+ ", custDob=" + custDob + ", custAddress=" + custAddress + ", custGender=" + custGender
				+ ", custCDate=" + custCDate + ", custUserId=" + custUserId + ", custAadhar=" + custAadhar
				+ ", custStatus=" + custStatus + ", custLuUDate=" + custLuUDate + ", custLuUser=" + custLuUser + "]";
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustFName() {
		return custFName;
	}

	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}

	public String getCustLName() {
		return custLName;
	}

	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}

	public Date getCustDob() {
		return custDob;
	}

	public void setCustDob(Date custDob) {
		this.custDob = custDob;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public char getCustGender() {
		return custGender;
	}

	public void setCustGender(char custGender) {
		this.custGender = custGender;
	}

	public Date getCustCDate() {
		return custCDate;
	}

	public void setCustCDate(Date custCDate) {
		this.custCDate = custCDate;
	}

	public int getCustUserId() {
		return custUserId;
	}

	public void setCustUserId(int custUserId) {
		this.custUserId = custUserId;
	}

	public long getCustAadhar() {
		return custAadhar;
	}

	public void setCustAadhar(long custAadhar) {
		this.custAadhar = custAadhar;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public Date getCustLuUDate() {
		return custLuUDate;
	}

	public void setCustLuUDate(Date custLuUDate) {
		this.custLuUDate = custLuUDate;
	}

	public int getCustLuUser() {
		return custLuUser;
	}

	public void setCustLuUser(int custLuUser) {
		this.custLuUser = custLuUser;
	}
}