package com.insurance.insuranceCompany.contract;

import java.util.ArrayList;
import java.util.List;

import com.insurance.insuranceCompany.model.*;
import com.insurance.insuranceCompany.model.Claim;
import com.insurance.insuranceCompany.model.ClaimApplication;
import com.insurance.insuranceCompany.model.ClaimBills;
import com.insurance.insuranceCompany.model.CoveredDiseases;


public interface ClaimsDao {

	ArrayList<Claim> getAllClaims();

	ArrayList<Claim> getFilteredClaims(String status);

	Claim getClaimById(int clamId);

	ArrayList<Claim> viewAllClaims();

	Claim viewClaimById(int clamId);

	int editClaimById(int clamId, String clamRemarks, String clamStatus);

	void addClaim(ClaimBills claim);

	void setClaim(int i, double requestAmount);

	Claim getClaimByid(int clamIplcId);

	void setDocs(String f, String filePath, int cid, int amt);

	ArrayList<ClaimBills> getDocs(int clamId);

	ClaimBills getDocBills(int billIndex);

	void addClaimApplication(ClaimApplication application);

	List<ClaimApplication> getAllApplications();

	Claim getClaimByPolicy(int id);

	void updateClaimBill(CB bill,int cid);

	List<CoveredDiseases> getAllCoveredDiseases(int id);
	void updateClaimBill(int clamId, String clamRemarks, String clamStatus, String clamProcessedAmount);

	void updateDate(int clamId);

	ClaimBills updt(int billIndex);

	List<ClaimHistory> getHistory(int cid);

}