package com.insurance.insuranceCompany.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.insuranceCompany.Dao.DaoLayer;
@Repository
public class PermissionRepository {
	@Autowired
	public DaoLayer cc;
	public int checkAccess(int lc, String string) {
		int x = cc.checkAccess(lc, string);
		System.out.println("is access at repository"+x);
		return x;
	}
}
