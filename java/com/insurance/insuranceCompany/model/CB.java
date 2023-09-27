package com.insurance.insuranceCompany.model;

import java.math.BigDecimal;
import java.sql.Date;

public class CB {
	
	
	private int billIndex;
	public int getBillIndex() {
		return billIndex;
	}
	public void setBillIndex(int billIndex) {
		this.billIndex = billIndex;
	}
	private BigDecimal processedAmount;
	private Date processedDate;
	private int processedBy;
	private String remarks;
	private String status;
	public BigDecimal getProcessedAmount() {
		return processedAmount;
	}
	public void setProcessedAmount(BigDecimal processedAmount) {
		this.processedAmount = processedAmount;
	}
	public Date getProcessedDate() {
		return processedDate;
	}
	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}
	public int getProcessedBy() {
		return processedBy;
	}
	public void setProcessedBy(int processedBy) {
		this.processedBy = processedBy;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CB [billIndex=" + billIndex + ", processedAmount=" + processedAmount + ", processedDate="
				+ processedDate + ", processedBy=" + processedBy + ", remarks=" + remarks + ", status=" + status + "]";
	}
	
}
