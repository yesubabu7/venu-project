package com.insurance.insuranceCompany.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.insuranceCompany.Dao.DaoLayer;
import com.insurance.insuranceCompany.model.LoginClass;

@Repository
public class RepositoryAdmin {
	@Autowired
	DaoLayer dao;

	public LoginClass checkCredentials(LoginClass lc) {
		return dao.checkCredentials(lc);
	}

	public int resetpwd(String email, String pwd) {
		return dao.resetpwd(email, pwd);
	}

}
