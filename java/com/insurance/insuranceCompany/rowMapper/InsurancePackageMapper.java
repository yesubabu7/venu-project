package com.insurance.insuranceCompany.rowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.InsurancePackageSch;


public class InsurancePackageMapper implements RowMapper<InsurancePackageSch> {

	public InsurancePackageSch mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		InsurancePackageSch insurancePackage = new InsurancePackageSch();
		insurancePackage.setId(resultSet.getLong("insp_id"));
		insurancePackage.setTitle(resultSet.getString("insp_title"));
		insurancePackage.setDescription(resultSet.getString("insp_desc"));
		insurancePackage.setStatus(resultSet.getString("insp_status"));
		insurancePackage.setRangeStart(resultSet.getDouble("insp_range_start"));
		insurancePackage.setRangeEnd(resultSet.getDouble("insp_range_end"));
		insurancePackage.setAgeLimitStart(resultSet.getInt("insp_agelimit_start"));
		insurancePackage.setAgeLimitEnd(resultSet.getInt("insp_agelimit_end"));
		return insurancePackage;
	}
}

