package com.insurance.insuranceCompany.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.ClaimBills;

public class DateRowMapper implements RowMapper<ClaimBills>{
	@Override
	public ClaimBills mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClaimBills claimBill = new ClaimBills();
		claimBill.setProcessedDate(rs.getDate(1));
		return claimBill;
	}
}
