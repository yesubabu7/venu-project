package com.insurance.insuranceCompany.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.insuranceCompany.Dao.PackagesDao;
import com.insurance.insuranceCompany.model.Disease;
import com.insurance.insuranceCompany.model.InsurancePackage;

@Repository
public class PackagesRepository {
	
	@Autowired
	private PackagesDao pdao;
	
	public ArrayList<InsurancePackage> getAllPackages(){
		 return pdao.getAllPackages();
	}

	public int addPackage(InsurancePackage insp) {
		return pdao.addHospital(insp);
		
	}

	public int deletePackage(int pid) {
		return pdao.deletePackage(pid);
		
	}

	public ArrayList<Disease> showDiseases(int pid) {
		
		return pdao.showDiseases(pid);
	}
	
	public int getPackagesCount() {
		return pdao.getPackCount();
	}
}
