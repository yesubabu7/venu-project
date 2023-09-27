package com.insurance.insuranceCompany.rowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.InsurancePolicy;


public class InsurancePolicyRowMapper implements RowMapper<InsurancePolicy> {

	@Override
	public InsurancePolicy mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		InsurancePolicy policy = new InsurancePolicy();
		policy.setIplc_id(resultSet.getInt("iplc_id"));
		policy.setIplc_cust_id(resultSet.getInt("iplc_cust_id"));
		policy.setIplc_cdate(resultSet.getDate("iplc_cdate"));
		policy.setIplc_sum_assured(resultSet.getDouble("iplc_sum_assured"));
		policy.setIplc_applicable_date(resultSet.getDate("iplc_applicable_date"));
		policy.setIplc_nom_insured(resultSet.getInt("iplc_nom_insured"));
		policy.setIplc_insp_id(resultSet.getInt("iplc_insp_id"));
		policy.setIplc_yrly_prem_amount(resultSet.getDouble("iplc_yrly_prem_amount"));
		policy.setIplc_paymode_count(resultSet.getInt("iplc_paymode_count"));
		policy.setIplc_expdate(resultSet.getDate("iplc_expdate"));
		policy.setIplc_agnt_id(resultSet.getInt("iplc_agnt_id"));
		policy.setIplc_status(resultSet.getString("iplc_status"));
		return policy;
	}
}

