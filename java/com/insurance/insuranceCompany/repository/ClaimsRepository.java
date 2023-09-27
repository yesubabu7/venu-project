package com.insurance.insuranceCompany.repository;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.insuranceCompany.contract.ClaimContract;
import com.insurance.insuranceCompany.model.Claims;
import com.insurance.insuranceCompany.model.Settlements;

@Repository
public class ClaimsRepository {
	@Autowired
	public ClaimContract cc;

	public List<Claims> getApprovedClaims() {
		return cc.getApprovedClaims();
	}

	public Claims getClaimById(int claimId) {
		return cc.getClaimById(claimId);
	}

	public void updatePayStatus(int claim_id) {
		cc.updatePayStatus(claim_id);
	}

	public void addPayment(int claim_id) {
		cc.addPayment(claim_id);
	}

	public void addTransaction(int claim_id, String transId) throws ParseException {
		cc.addTransaction(claim_id, transId);
	}

	public List<Settlements> getProcessedPayments() {
		// TODO Auto-generated method stub
		return cc.getProcessedPayments();
	}

}
