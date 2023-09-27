package com.insurance.insuranceCompany.model;

import java.sql.Date;

public class PaymentModel {
	int inpp_id;
	int inpp_iplc_id;
	String inpp_trans_id;

	public int getInpp_id() {
		return inpp_id;
	}

	public void setInpp_id(int inpp_id) {
		this.inpp_id = inpp_id;
	}

	public int getInpp_iplc_id() {
		return inpp_iplc_id;
	}

	public void setInpp_iplc_id(int inpp_iplc_id) {
		this.inpp_iplc_id = inpp_iplc_id;
	}

	public String getInpp_trans_id() {
		return inpp_trans_id;
	}

	public void setInpp_trans_id(String inpp_trans_id) {
		this.inpp_trans_id = inpp_trans_id;
	}

	public double getInpp_amount() {
		return inpp_amount;
	}

	public void setInpp_amount(double inpp_amount) {
		this.inpp_amount = inpp_amount;
	}

	public String getInpp_paymode() {
		return inpp_paymode;
	}

	public void setInpp_paymode(String inpp_paymode) {
		this.inpp_paymode = inpp_paymode;
	}

	public Date getInpp_date() {
		return inpp_date;
	}

	public void setInpp_date(Date inpp_date) {
		this.inpp_date = inpp_date;
	}

	double inpp_amount;
	String inpp_paymode;
	Date inpp_date;

}
