package com.insurance.insuranceCompany.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.CoveredDiseases;


public class DiseasesRowMapper implements RowMapper<CoveredDiseases> {

	@Override
	public CoveredDiseases mapRow(ResultSet rs, int rowNum) throws SQLException {
		CoveredDiseases coveredDisease = new CoveredDiseases();
		coveredDisease.setDiseasesName(rs.getString("disc_name"));
		coveredDisease.setICDCode(rs.getString("disc_icdcode"));
		coveredDisease.setDescription(rs.getString("disc_desc"));
		coveredDisease.setStatus(rs.getString("disc_status"));
		return coveredDisease;
	}

}
