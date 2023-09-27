package com.insurance.insuranceCompany.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.insuranceCompany.repository.CustomerRepositoryInterface;



@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepositoryInterface cri;
	
	@GetMapping("/getCustomers")
	public String getCustomers(Model model) {
		model.addAttribute("customers", cri.getAllCustomers());
		return "customerList";
	}
	
	@GetMapping("/getCustomerDetails")
	public String getCustomerDetails(@RequestParam("IdVal") String Id, Model model) {
		model.addAttribute("customer", cri.getCustomerId(Integer.parseInt(Id)));
		model.addAttribute("policies", cri.getPolicies(Id));
		return "customerDetails";
	}
	
	@PostMapping("/updateCStatus")
	@ResponseBody
	public String updateStatus(@RequestParam String Id, String Status) {
		String message = cri.updateStatus(Integer.parseInt(Id), Status);
		return message;
	}
}
