package com.insurance.insuranceCompany.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.insuranceCompany.model.NetworkHospitals;
import com.insurance.insuranceCompany.repository.NetworkHospitalRepository;

@RestController
public class NetworkHospitalRestController {

	@Autowired
	private NetworkHospitalRepository nr;

	@GetMapping("/jsonhsp")
	public ArrayList<NetworkHospitals> getAllHospitals() {
		return nr.getAllHospitals();

	}
}
