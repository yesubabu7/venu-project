package com.insurance.insuranceCompany.model;


import java.sql.Date;

public class InsurancePolicy {
	private int iplc_id;
	private int iplc_cust_id;
	private Date iplc_cdate;
	private double iplc_sum_assured;
	private Date iplc_applicable_date;
	private int iplc_nom_insured;
	private int iplc_insp_id;
	private double iplc_yrly_prem_amount;
	private int iplc_paymode_count;
	private Date iplc_expdate;
	private int iplc_agnt_id;
	private String iplc_status;

	public InsurancePolicy() {
		super();
	}

	public InsurancePolicy(int iplc_id, int iplc_cust_id, Date iplc_cdate, double iplc_sum_assured,
			Date iplc_applicable_date, int iplc_nom_insured, int iplc_insp_id, double iplc_yrly_prem_amount,
			int iplc_paymode_count, Date iplc_expdate, int iplc_agnt_id, String iplc_status) {
		super();
		this.iplc_id = iplc_id;
		this.iplc_cust_id = iplc_cust_id;
		this.iplc_cdate = iplc_cdate;
		this.iplc_sum_assured = iplc_sum_assured;
		this.iplc_applicable_date = iplc_applicable_date;
		this.iplc_nom_insured = iplc_nom_insured;
		this.iplc_insp_id = iplc_insp_id;
		this.iplc_yrly_prem_amount = iplc_yrly_prem_amount;
		this.iplc_paymode_count = iplc_paymode_count;
		this.iplc_expdate = iplc_expdate;
		this.iplc_agnt_id = iplc_agnt_id;
		this.iplc_status = iplc_status;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [iplc_id=" + iplc_id + ", iplc_cust_id=" + iplc_cust_id + ", iplc_cdate=" + iplc_cdate
				+ ", iplc_sum_assured=" + iplc_sum_assured + ", iplc_applicable_date=" + iplc_applicable_date
				+ ", iplc_nom_insured=" + iplc_nom_insured + ", iplc_insp_id=" + iplc_insp_id
				+ ", iplc_yrly_prem_amount=" + iplc_yrly_prem_amount + ", iplc_paymode_count=" + iplc_paymode_count
				+ ", iplc_expdate=" + iplc_expdate + ", iplc_agnt_id=" + iplc_agnt_id + ", iplc_status=" + iplc_status
				+ "]";
	}

	public int getIplc_id() {
		return iplc_id;
	}

	public void setIplc_id(int iplc_id) {
		this.iplc_id = iplc_id;
	}

	public int getIplc_cust_id() {
		return iplc_cust_id;
	}

	public void setIplc_cust_id(int iplc_cust_id) {
		this.iplc_cust_id = iplc_cust_id;
	}

	public Date getIplc_cdate() {
		return iplc_cdate;
	}

	public void setIplc_cdate(Date iplc_cdate) {
		this.iplc_cdate = iplc_cdate;
	}

	public double getIplc_sum_assured() {
		return iplc_sum_assured;
	}

	public void setIplc_sum_assured(double iplc_sum_assured) {
		this.iplc_sum_assured = iplc_sum_assured;
	}

	public Date getIplc_applicable_date() {
		return iplc_applicable_date;
	}

	public void setIplc_applicable_date(Date iplc_applicable_date) {
		this.iplc_applicable_date = iplc_applicable_date;
	}

	public int getIplc_nom_insured() {
		return iplc_nom_insured;
	}

	public void setIplc_nom_insured(int iplc_nom_insured) {
		this.iplc_nom_insured = iplc_nom_insured;
	}

	public int getIplc_insp_id() {
		return iplc_insp_id;
	}

	public void setIplc_insp_id(int iplc_insp_id) {
		this.iplc_insp_id = iplc_insp_id;
	}

	public double getIplc_yrly_prem_amount() {
		return iplc_yrly_prem_amount;
	}

	public void setIplc_yrly_prem_amount(double iplc_yrly_prem_amount) {
		this.iplc_yrly_prem_amount = iplc_yrly_prem_amount;
	}

	public int getIplc_paymode_count() {
		return iplc_paymode_count;
	}

	public void setIplc_paymode_count(int iplc_paymode_count) {
		this.iplc_paymode_count = iplc_paymode_count;
	}

	public Date getIplc_expdate() {
		return iplc_expdate;
	}

	public void setIplc_expdate(Date iplc_expdate) {
		this.iplc_expdate = iplc_expdate;
	}

	public int getIplc_agnt_id() {
		return iplc_agnt_id;
	}

	public void setIplc_agnt_id(int iplc_agnt_id) {
		this.iplc_agnt_id = iplc_agnt_id;
	}

	public String getIplc_status() {
		return iplc_status;
	}

	public void setIplc_status(String iplc_status) {
		this.iplc_status = iplc_status;
	}

}