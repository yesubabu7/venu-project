package com.insurance.insuranceCompany.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.Claim;


public class RowMap implements RowMapper<Claim> {
	public Claim mapRow(ResultSet rs, int rowNum) throws SQLException {
		Claim clam = new Claim();

		clam.setClamId(rs.getInt("clam_id"));
		return clam;
	}
}
