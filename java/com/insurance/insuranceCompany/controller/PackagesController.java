package com.insurance.insuranceCompany.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.insuranceCompany.model.Disease;
import com.insurance.insuranceCompany.model.InsurancePackage;
import com.insurance.insuranceCompany.repository.PackagesRepository;

@Controller
public class PackagesController {
	
	@Autowired
	private PackagesRepository pr;
	
	@GetMapping("/packages")
	public String getAllPackages(Model model) {
		model.addAttribute("packages",pr.getAllPackages()) ;
		model.addAttribute("insurancePackage",new InsurancePackage());
		return "packages";
	}
	
	@PostMapping("/addpackage")
	public String addhospital(Model model,@ModelAttribute("insurancePackage") InsurancePackage insp) {
		System.out.println(insp);
		int x=pr.addPackage(insp);
		model.addAttribute("packages",pr.getAllPackages()) ;
		model.addAttribute("insurancePackage",new InsurancePackage());
		if(x==1) model.addAttribute("msg", "hospital added successfully");
		else model.addAttribute("msg", "error occurred while adding hospital");
		return "packages";
	}
	
	@PostMapping(value="/deletePackage")
	@ResponseBody
	public String deleteHospital(@ModelAttribute("packageId") String pid) {
		System.out.println(pid);
		int x=pr.deletePackage(Integer.parseInt(pid));
		if(x==1) return "Package deleted successfully...!";
		return "error occured";
		
	}
	
	@GetMapping(value="/showDiseases")
	public String showDiseases(@ModelAttribute("packageId") String pid,Model model) {
		System.out.println(pid);
		ArrayList<Disease> x=pr.showDiseases(Integer.parseInt(pid));
		 System.out.println(x.get(0));
		model.addAttribute("diseaseslist",x);
		return "diseases";
		
	}

}
