package com.insurance.insuranceCompany.repository;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.insuranceCompany.Dao.CustomerDAOInterface;
import com.insurance.insuranceCompany.model.InsCompCustomer;
import com.insurance.insuranceCompany.model.InsCompPolicy;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryInterface{
	
	@Autowired
	CustomerDAOInterface cdao;
	
	@Override
	public ArrayList<InsCompCustomer> getAllCustomers() {
		return cdao.getAllCustomers();
	}

	@Override
	public InsCompCustomer getCustomerId(int Id) {
		return cdao.getCustomerById(Id);
	}

	@Override
	public String updateStatus(int Id, String status) {
		return cdao.updateStatus(Id, status);
	}

	@Override
	public ArrayList<InsCompPolicy> getPolicies(String id) {
		return cdao.getPolicies(id);
	}
}