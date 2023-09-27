package com.insurance.insuranceCompany.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.LoginClass;

public class LoginClassMapper implements RowMapper<LoginClass> {

	@Override
	public LoginClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoginClass lc = new LoginClass();
		lc.setUserId(rs.getInt(1));
		lc.setUser_name(rs.getString(2));
		lc.setRoleid(rs.getInt(4));
		return lc;
	}

}
