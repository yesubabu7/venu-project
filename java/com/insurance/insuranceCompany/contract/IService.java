package com.insurance.insuranceCompany.contract;

import java.util.ArrayList;
import java.util.List;

import com.insurance.insuranceCompany.model.CB;
import com.insurance.insuranceCompany.model.Claim;
import com.insurance.insuranceCompany.model.ClaimApplication;
import com.insurance.insuranceCompany.model.ClaimBills;
import com.insurance.insuranceCompany.model.ClaimHistory;
import com.insurance.insuranceCompany.model.CoveredDiseases;

public interface IService {

	ArrayList<Claim> getAllClaims();

	ArrayList<Claim> getFilteredClaims(String status);

	Claim getClaimById(int clamId);

	ArrayList<Claim> viewAllClaims();

	Claim viewClaimById(int clamId);

	int editClaimById(int clamId, String clamRemarks, String clamStatus);

	void addClaim(int i, double requestAmount);

	Claim getClaimByid(int clamIplcId);

	void addClaimBills(String f, String filePath, int cid, int amount);

	ArrayList<ClaimBills> viewClaimDocsById(int clamId);

	ClaimBills viewdocBills(int billIndex);

	void addClaimApplication(ClaimApplication application);

	List<ClaimApplication> getAllApplicantions();

	Claim getCliamByPolicy(int id);

	void updateClaimBill(CB bill, int cid);

	List<CoveredDiseases> getAllDiseasesCovered(int id);
	
	void editClaimById(int clamId, String clamRemarks, String clamStatus, String clamProcessedAmount);

	void updateClaimDate(int clamId);

	ClaimBills updatedate(int billIndex);

	List<ClaimHistory> getHistory(int cid);

}