package com.insurance.insuranceCompany.repository;



import java.util.ArrayList;


import com.insurance.insuranceCompany.model.InsCompCustomer;
import com.insurance.insuranceCompany.model.InsCompPolicy;



public interface CustomerRepositoryInterface {

	ArrayList<InsCompCustomer> getAllCustomers();

	InsCompCustomer getCustomerId(int Id);

	String updateStatus(int Id, String status);

	ArrayList<InsCompPolicy> getPolicies(String id);
}