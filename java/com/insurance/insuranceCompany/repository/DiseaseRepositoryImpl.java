package com.insurance.insuranceCompany.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.insuranceCompany.contract.DiseaseDAOInterface;
import com.insurance.insuranceCompany.contract.DiseaseRepositoryInterface;
import com.insurance.insuranceCompany.model.Disease;

@Repository
public class DiseaseRepositoryImpl implements DiseaseRepositoryInterface {
	@Autowired
	DiseaseDAOInterface ddi;

	@Override
	public ArrayList<Disease> getAllDisease() {
		return ddi.getAllDisease();
	}

	@Override
	public String addDisease(String name, String iscCode, String desc, String status) {
		return ddi.addDisease(name,iscCode,desc,status);
	}

	@Override
	public String editDisease(String name, String ICDCode, String desc, String status) {
		// TODO Auto-generated method stub
		return ddi.editDisease(name, ICDCode, desc,status);
	}

	@Override
	public String deleteDisease(String name) {
		// TODO Auto-generated method stub
		return ddi.deleteDisease(name);
	}

}
