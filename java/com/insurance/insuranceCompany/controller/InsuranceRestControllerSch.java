package com.insurance.insuranceCompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.insuranceCompany.model.InsurancePolicy;
import com.insurance.insuranceCompany.model.InsurancePolicySchedule;
import com.insurance.insuranceCompany.repository.InsuranceRepositorySch;

@RestController

public class InsuranceRestControllerSch {

	@Autowired
	private InsuranceRepositorySch insuranceRepository;

	@GetMapping("/policy")
	public List<InsurancePolicy> getAllPolicy() {
		return insuranceRepository.ListAllPolicy();
	}

	@GetMapping("/policySchedule")
	public List<InsurancePolicySchedule> getAllPolicySchedule() {
		return insuranceRepository.ListAllPolicySchedules();
	}

	@PostMapping(value = "/createpolicy")
	public ResponseEntity<Object> createPolicy(@RequestBody InsurancePolicy u) {
		insuranceRepository.createNewPolicy(u);
		return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/updatepolicy")
	public ResponseEntity<Object> updatePolicy(@RequestBody InsurancePolicy p) {
		int result = insuranceRepository.createNewPolicy(p);
		if (result > 0) {
			return new ResponseEntity<>("Package is updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Package update failed", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getpolicyid")
	public String getCustomerDetails(@RequestParam("Id") String Id, Model model) {
		model.addAttribute("customer", insuranceRepository.getPolicyeById(Integer.parseInt(Id)));
		return "customerDetails";
	}

}