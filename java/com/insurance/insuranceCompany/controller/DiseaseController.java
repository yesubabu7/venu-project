package com.insurance.insuranceCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.insuranceCompany.contract.DiseaseRepositoryInterface;

@Controller
public class DiseaseController {
	
	@Autowired
	DiseaseRepositoryInterface dri;
	
	@GetMapping("/getDisease")
	public String getAllDisease(Model model){
		model.addAttribute("diseases", dri.getAllDisease());
		return "Disease";
	}
	
	@PostMapping("/addDisease")
	@ResponseBody
	public String addDisease(@RequestParam String name, String ICDCode, String Description){
		String message = dri.addDisease(name, ICDCode, Description, "Active");
		return message;
	}
	
	@PostMapping("/editDisease")
	@ResponseBody
	public String editDisease(@RequestParam String name, String ICDCode, String Description, String Status, Model model){
		String message = dri.editDisease(name, ICDCode, Description, Status);
		model.addAttribute("diseases", dri.getAllDisease());
		return message;
	}
	
	@PostMapping("/deleteDisease")
	@ResponseBody
	public String deleteDisease(@RequestParam String name){
		String message = dri.deleteDisease(name);
		return message;
	}
}
