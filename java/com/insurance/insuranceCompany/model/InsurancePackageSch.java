package com.insurance.insuranceCompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "InsurancePackages")
public class InsurancePackageSch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "insp_id")
	private Long id;

	@Column(name = "insp_title", length = 60)
	private String title;

	@Column(name = "insp_desc", length = 255)
	private String description;

	@Column(name = "insp_status", length = 2)
	private String status;

	@Column(name = "insp_range_start")
	private Double rangeStart;

	@Column(name = "insp_range_end")
	private Double rangeEnd;

	@Column(name = "insp_agelimit_start")
	private Integer ageLimitStart;

	@Column(name = "insp_agelimit_end")
	private Integer ageLimitEnd;

	public InsurancePackageSch() {
		super();
	}

	public InsurancePackageSch(Long id, String title, String description, String status, Double rangeStart,
			Double rangeEnd, Integer ageLimitStart, Integer ageLimitEnd) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.rangeStart = rangeStart;
		this.rangeEnd = rangeEnd;
		this.ageLimitStart = ageLimitStart;
		this.ageLimitEnd = ageLimitEnd;
	}

	@Override
	public String toString() {
		return "InsurancePackageSch [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", rangeStart=" + rangeStart + ", rangeEnd=" + rangeEnd + ", ageLimitStart=" + ageLimitStart
				+ ", ageLimitEnd=" + ageLimitEnd + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getRangeStart() {
		return rangeStart;
	}

	public void setRangeStart(Double rangeStart) {
		this.rangeStart = rangeStart;
	}

	public Double getRangeEnd() {
		return rangeEnd;
	}

	public void setRangeEnd(Double rangeEnd) {
		this.rangeEnd = rangeEnd;
	}

	public Integer getAgeLimitStart() {
		return ageLimitStart;
	}

	public void setAgeLimitStart(Integer ageLimitStart) {
		this.ageLimitStart = ageLimitStart;
	}

	public Integer getAgeLimitEnd() {
		return ageLimitEnd;
	}

	public void setAgeLimitEnd(Integer ageLimitEnd) {
		this.ageLimitEnd = ageLimitEnd;
	}

}