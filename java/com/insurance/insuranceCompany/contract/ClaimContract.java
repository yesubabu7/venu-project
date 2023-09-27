package com.insurance.insuranceCompany.contract;

import java.text.ParseException;
import java.util.List;

import com.insurance.insuranceCompany.model.Claims;
import com.insurance.insuranceCompany.model.Settlements;

public interface ClaimContract {

	List<Claims> getApprovedClaims();

	Claims getClaimById(int claimId);

	void updatePayStatus(int claim_id);

	void addPayment(int claim_id);

	public void addTransaction(int claim_id, String transId) throws ParseException;

	List<Settlements> getProcessedPayments();
	
}