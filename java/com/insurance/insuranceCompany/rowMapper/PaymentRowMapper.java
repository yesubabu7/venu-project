package com.insurance.insuranceCompany.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.PaymentModel;

public class PaymentRowMapper implements RowMapper<PaymentModel> {
	@Override
	public PaymentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaymentModel payment = new PaymentModel();
		payment.setInpp_id(rs.getInt("inpp_id"));
		payment.setInpp_iplc_id(rs.getInt("inpp_iplc_id"));
		payment.setInpp_trans_id(rs.getString("inpp_trans_id"));
		payment.setInpp_amount(rs.getDouble("inpp_amount"));
		payment.setInpp_paymode(rs.getString("inpp_paymode"));
		payment.setInpp_date(rs.getDate("inpp_date"));
		return payment;
	}
}