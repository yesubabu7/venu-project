package com.insurance.insuranceCompany.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.insuranceCompany.model.LoginClass;
import com.insurance.insuranceCompany.rowMapper.LoginClassMapper;

@Component
public class DaoLayer {
	@Autowired
	JdbcTemplate jdbc;

	public LoginClass checkCredentials(LoginClass lc) {
		String sql = "SELECT COUNT(*) FROM logintable WHERE username = '" + lc.getUser_name() + "' and password='"
				+ lc.getPassword() + "'";
		int count = jdbc.queryForObject(sql, Integer.class);
		if (count == 0)
			return null;
		String sql1 = "SELECT * FROM logintable WHERE username = '" + lc.getUser_name() + "' and password='"
				+ lc.getPassword() + "'";
		ArrayList<LoginClass> llist = (ArrayList<LoginClass>) jdbc.query(sql1, new LoginClassMapper());
		return llist.get(0);
	}

	public int resetpwd(String email, String pwd) {
		return jdbc.update("update logintable set password='" + pwd + "' where username='" + email + "'");
	}

	public int checkMail(String email) {
		String sql = "SELECT COUNT(*) FROM logintable WHERE username = ?";
		return jdbc.queryForObject(sql, Integer.class, email);
	}
	
	public int checkAccess(int lc, String string) {
		String sql = "SELECT COUNT(*) FROM roleprivelegetable AS rp INNER JOIN privelegestable AS p ON rp.priv_id = p.priv_id WHERE rp.role_id ="
				+ lc + "AND p.priv_pattern = '" + string + "'";
		return jdbc.queryForObject(sql, Integer.class);
	}
}
