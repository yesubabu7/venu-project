package com.insurance.insuranceCompany.contract;

import java.util.ArrayList;

import com.insurance.insuranceCompany.model.Disease;

public interface DiseaseDAOInterface {
	public ArrayList<Disease> getAllDisease();

	public String addDisease(String name,String iscCode,String desc,String status);

	public String editDisease(String name, String ICDCode, String desc, String status);

	public String deleteDisease(String name);
}
