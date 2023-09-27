package com.insurance.insuranceCompany.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.insuranceCompany.Dao.InsuranceDAO;
import com.insurance.insuranceCompany.model.InsurancePolicy;
import com.insurance.insuranceCompany.model.InsurancePolicySchedule;

@Repository
public class InsuranceRepositorySch {
	@Autowired
	private InsuranceDAO insuranceDAO;

	public List<InsurancePolicy> ListAllPolicy() {
		List<InsurancePolicy> pack = insuranceDAO.getAllPolicies();
		return pack;
	}

	public List<InsurancePolicySchedule> ListAllPolicySchedulesById(int id) {
		List<InsurancePolicySchedule> s = insuranceDAO.getAllScheduleById(id);
		return s;
	}

	public List<InsurancePolicySchedule> ListAllPolicySchedules() {
		List<InsurancePolicySchedule> s = insuranceDAO.getAllSchedule();
		return s;
	}

	public int createNewPolicy(InsurancePolicy u) {
		return insuranceDAO.addPolicy(u);
	}

	public int updateNewPolicy(InsurancePolicy u) {
		return insuranceDAO.updateStatus(u);
	}

	public InsurancePolicy getPolicyeById(int id) {
		return insuranceDAO.getPolicyById(id);
	}

	public int ListNonStatusPayments(int id) {
		return insuranceDAO.getNonPaymentStatus(id);
	}

	public List<Integer> findDistinctIds() {
		return insuranceDAO.findDistinctIplcIds();
	}

}
