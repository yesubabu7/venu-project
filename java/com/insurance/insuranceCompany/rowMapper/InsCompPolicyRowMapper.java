package com.insurance.insuranceCompany.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.InsCompPolicy;

public class InsCompPolicyRowMapper implements RowMapper<InsCompPolicy> {
    @Override
    public InsCompPolicy mapRow(ResultSet rs, int rowNum) throws SQLException {
    	InsCompPolicy policy = new InsCompPolicy();
        policy.setIplcId(rs.getInt("iplc_id"));
        policy.setIplcCustId(rs.getInt("iplc_cust_id"));
        policy.setIplcCDate(rs.getDate("iplc_cdate"));
        policy.setIplcSumAssured(rs.getDouble("iplc_sum_assured"));
        policy.setIplcApplicableDate(rs.getDate("iplc_applicable_date"));
        policy.setIplcInspId(rs.getInt("iplc_insp_id"));
        policy.setIplcYrlyPremAmount(rs.getDouble("iplc_yrly_prem_amount"));
        policy.setIplcExpDate(rs.getDate("iplc_expdate"));
        policy.setIplcAgntId(rs.getInt("iplc_agnt_id"));
        policy.setIplcMode(rs.getInt("iplc_mode"));
        policy.setIplcStatus(rs.getString("iplc_status"));
        return policy;
    }
}
