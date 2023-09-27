package com.insurance.insuranceCompany.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.ClaimHistory;


public class ClaimHistoryMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClaimHistory ch = new ClaimHistory();
		ch.setCf_id(rs.getInt(1));
		ch.setCf_clam_id(rs.getInt(2));
		ch.setCf_clam_status(rs.getString(3));
		ch.setCf_clam_remarks(rs.getString(4));
		ch.setCf_clam_date(rs.getDate(6));
		ch.setCf_clam_processed_by(rs.getInt(7));
		return ch;
	}

}