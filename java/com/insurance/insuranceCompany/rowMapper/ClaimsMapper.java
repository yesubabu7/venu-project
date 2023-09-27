package com.insurance.insuranceCompany.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.Claims;

public class ClaimsMapper implements RowMapper<Claims> {

	@Override
	public Claims mapRow(ResultSet rs, int rowNum) throws SQLException {
		Claims claim = new Claims();
		claim.setClam_id(rs.getInt(1));
		claim.setClam_source(rs.getString(2));
		claim.setClam_type(rs.getString(3));
		claim.setClam_date(rs.getDate(4));
		claim.setClam_amount_requested(rs.getDouble(5));
		claim.setClam_iplc_id(rs.getInt(6));
		claim.setClam_processed_amount(rs.getDouble(7));
		claim.setClam_processed_Date(rs.getDate(8));
		claim.setClam_processed_by(rs.getInt(9));
		claim.setClam_remarks(rs.getString(10));
		claim.setClam_status(rs.getString(11));
		claim.setPay_status(rs.getString(12));
		return claim;
	}

}