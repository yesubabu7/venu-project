package com.insurance.insuranceCompany.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.insuranceCompany.Dao.NetworkHospitalDao;
import com.insurance.insuranceCompany.model.InsurancePackage;
import com.insurance.insuranceCompany.model.NetworkHospitals;

@Repository
public class NetworkHospitalRepository {

	@Autowired
	private NetworkHospitalDao nhdao;

	public ArrayList<NetworkHospitals> getAllHospitals() {
		return nhdao.getAllHopitals();
	}

	public int deleteHospital(int hid) {
		return nhdao.deleteHospital(hid);

	}

	public int addHospital(NetworkHospitals netHsp) {
		return nhdao.addHospital(netHsp);
	}

	public int getHospitalsCount() {
		return nhdao.getHospCount();
	}

	public int editHospital(NetworkHospitals netHsp) {

		return nhdao.editHospital(netHsp);
	}

	public ArrayList<InsurancePackage> getRelatedPackages(int hspid) {

		return nhdao.getRelatedPackages(hspid);
	}

	public int addPackage(String title, String desc, String status, long rangeStart, long rangeEnd,
			Integer ageLimitStart, Integer ageLimitEnd, int hospid) {

		return nhdao.addPackage(title, desc, status, rangeStart, rangeEnd, ageLimitStart, ageLimitEnd, hospid);
	}

	public int deletePackage(int did, int hospid) {

		return nhdao.deletePackage(did, hospid);
	}

	public String editPackage(String id, String title, String description, String status, String rangeStart,
			String rangeEnd, String ageLimitStrt, String ageLimitEnd) {
		return nhdao.updatePackage(id, title, description, status, rangeStart, rangeEnd, ageLimitStrt, ageLimitEnd);
	}

	public ArrayList<NetworkHospitals> getSearchHospitals(String search) {

		return nhdao.getSearcHospitals(search);
	}

}
