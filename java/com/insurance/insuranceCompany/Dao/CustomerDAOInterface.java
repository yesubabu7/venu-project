package com.insurance.insuranceCompany.Dao;


import java.util.ArrayList;

import com.insurance.insuranceCompany.model.InsCompCustomer;
import com.insurance.insuranceCompany.model.InsCompPolicy;



public interface CustomerDAOInterface {

	ArrayList<InsCompCustomer> getAllCustomers();

	InsCompCustomer getCustomerById(int id);

	String updateStatus(int id, String status);

	ArrayList<InsCompPolicy> getPolicies(String id);
}
