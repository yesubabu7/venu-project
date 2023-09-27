package com.insurance.insuranceCompany.Dao;

import java.util.List;

import com.insurance.insuranceCompany.model.InsurancePolicy;
import com.insurance.insuranceCompany.model.InsurancePolicySchedule;

public interface InsuranceDAO {
	List<InsurancePolicySchedule> getAllSchedule();

	List<InsurancePolicySchedule> getAllScheduleById(int id);

	int getNonPaymentStatus(int id);

	List<Integer> findDistinctIplcIds();

	List<InsurancePolicy> getAllPolicies();

	int addPolicy(InsurancePolicy e);

	int updateStatus(InsurancePolicy e);

	InsurancePolicy getPolicyById(int id);

}
