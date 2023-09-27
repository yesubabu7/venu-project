package com.insurance.insuranceCompany.model;

import java.util.Date;

public class InsCompPolicy {
	private int iplcId;
    private int iplcCustId;
    private Date iplcCDate;
    private double iplcSumAssured;
    private Date iplcApplicableDate;
    private int iplcInspId;
    private double iplcYrlyPremAmount;
    private Date iplcExpDate;
    private int iplcAgntId;
    private int iplcMode;
    private String iplcStatus;
    
	public InsCompPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsCompPolicy(int iplcId, int iplcCustId, Date iplcCDate, double iplcSumAssured, Date iplcApplicableDate,
			int iplcInspId, double iplcYrlyPremAmount, Date iplcExpDate, int iplcAgntId, int iplcMode,
			String iplcStatus) {
		super();
		this.iplcId = iplcId;
		this.iplcCustId = iplcCustId;
		this.iplcCDate = iplcCDate;
		this.iplcSumAssured = iplcSumAssured;
		this.iplcApplicableDate = iplcApplicableDate;
		this.iplcInspId = iplcInspId;
		this.iplcYrlyPremAmount = iplcYrlyPremAmount;
		this.iplcExpDate = iplcExpDate;
		this.iplcAgntId = iplcAgntId;
		this.iplcMode = iplcMode;
		this.iplcStatus = iplcStatus;
	}

	@Override
	public String toString() {
		return "InsCompPolicy [iplcId=" + iplcId + ", iplcCustId=" + iplcCustId + ", iplcCDate=" + iplcCDate
				+ ", iplcSumAssured=" + iplcSumAssured + ", iplcApplicableDate=" + iplcApplicableDate + ", iplcInspId="
				+ iplcInspId + ", iplcYrlyPremAmount=" + iplcYrlyPremAmount + ", iplcExpDate=" + iplcExpDate
				+ ", iplcAgntId=" + iplcAgntId + ", iplcMode=" + iplcMode + ", iplcStatus=" + iplcStatus + "]";
	}

	public int getIplcId() {
		return iplcId;
	}

	public void setIplcId(int iplcId) {
		this.iplcId = iplcId;
	}

	public int getIplcCustId() {
		return iplcCustId;
	}

	public void setIplcCustId(int iplcCustId) {
		this.iplcCustId = iplcCustId;
	}

	public Date getIplcCDate() {
		return iplcCDate;
	}

	public void setIplcCDate(Date iplcCDate) {
		this.iplcCDate = iplcCDate;
	}

	public double getIplcSumAssured() {
		return iplcSumAssured;
	}

	public void setIplcSumAssured(double iplcSumAssured) {
		this.iplcSumAssured = iplcSumAssured;
	}

	public Date getIplcApplicableDate() {
		return iplcApplicableDate;
	}

	public void setIplcApplicableDate(Date iplcApplicableDate) {
		this.iplcApplicableDate = iplcApplicableDate;
	}

	public int getIplcInspId() {
		return iplcInspId;
	}

	public void setIplcInspId(int iplcInspId) {
		this.iplcInspId = iplcInspId;
	}

	public double getIplcYrlyPremAmount() {
		return iplcYrlyPremAmount;
	}

	public void setIplcYrlyPremAmount(double iplcYrlyPremAmount) {
		this.iplcYrlyPremAmount = iplcYrlyPremAmount;
	}

	public Date getIplcExpDate() {
		return iplcExpDate;
	}

	public void setIplcExpDate(Date iplcExpDate) {
		this.iplcExpDate = iplcExpDate;
	}

	public int getIplcAgntId() {
		return iplcAgntId;
	}

	public void setIplcAgntId(int iplcAgntId) {
		this.iplcAgntId = iplcAgntId;
	}

	public int getIplcMode() {
		return iplcMode;
	}

	public void setIplcMode(int iplcMode) {
		this.iplcMode = iplcMode;
	}

	public String getIplcStatus() {
		return iplcStatus;
	}

	public void setIplcStatus(String iplcStatus) {
		this.iplcStatus = iplcStatus;
	}
}
