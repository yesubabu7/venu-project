package com.insurance.insuranceCompany.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.insuranceCompany.contract.PaymentDAOInterface;
import com.insurance.insuranceCompany.model.PaymentModel;
import com.insurance.insuranceCompany.rowMapper.PaymentRowMapper;

@Component
public class PaymentDAOImpl implements PaymentDAOInterface {
	@Autowired
	JdbcTemplate jd;

	@Override
	public ArrayList<PaymentModel> getAllTransaction() {
		String Sql = "select * from InsurancePolicyPayments";
		return (ArrayList<PaymentModel>) jd.query(Sql, new PaymentRowMapper());
	}
}
