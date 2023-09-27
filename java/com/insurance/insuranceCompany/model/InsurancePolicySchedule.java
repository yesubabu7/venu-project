package com.insurance.insuranceCompany.model;


import java.util.Date;

public class InsurancePolicySchedule {
	private int iplcId;
	private short iplcSindex;
	private Date iplcDate;
	private double iplcPremium;
	private Date iplcPaidDate;

	public int getIplcId() {
		return iplcId;
	}

	public void setIplcId(int iplcId) {
		this.iplcId = iplcId;
	}

	public short getIplcSindex() {
		return iplcSindex;
	}

	public void setIplcSindex(short iplcSindex) {
		this.iplcSindex = iplcSindex;
	}

	public Date getIplcDate() {
		return iplcDate;
	}

	public void setIplcDate(Date iplcDate) {
		this.iplcDate = iplcDate;
	}

	public double getIplcPremium() {
		return iplcPremium;
	}

	public void setIplcPremium(double iplcPremium) {
		this.iplcPremium = iplcPremium;
	}

	public Date getIplcPaidDate() {
		return iplcPaidDate;
	}

	public void setIplcPaidDate(Date iplcPaidDate) {
		this.iplcPaidDate = iplcPaidDate;
	}

	@Override
	public String toString() {
		return "InsurancePolicySchedule [iplcId=" + iplcId + ", iplcSindex=" + iplcSindex + ", iplcPremium="
				+ iplcPremium + "]";
	}

	public InsurancePolicySchedule(int iplcId, short iplcSindex, Date iplcDate, double iplcPremium, Date iplcPaidDate) {
		super();
		this.iplcId = iplcId;
		this.iplcSindex = iplcSindex;
		this.iplcDate = iplcDate;
		this.iplcPremium = iplcPremium;
		this.iplcPaidDate = iplcPaidDate;
	}

	public InsurancePolicySchedule() {
		super();
	}

}