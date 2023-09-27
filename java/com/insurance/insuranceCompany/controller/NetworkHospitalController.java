package com.insurance.insuranceCompany.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.insuranceCompany.model.InsurancePackage;
import com.insurance.insuranceCompany.model.NetworkHospitals;
import com.insurance.insuranceCompany.repository.NetworkHospitalRepository;

@Controller
public class NetworkHospitalController {

	@Autowired
	private NetworkHospitalRepository nr;

	@GetMapping(value = "/hospitals")
	public String getAllHospitals(HttpServletRequest request, Model model) {
		int hospitalCount = nr.getAllHospitals().size();

		model.addAttribute("networkHospital", new NetworkHospitals());
		model.addAttribute("hospitals", nr.getAllHospitals());
		model.addAttribute("hospitalCount", hospitalCount);
		return "networkHospitals";
	}

	@PostMapping("/addhospital")
	public String addhospital(Model model, @RequestBody NetworkHospitals netHsp) {
		System.out.println(netHsp);
		int x = nr.addHospital(netHsp);
		model.addAttribute("networkHospital", new NetworkHospitals());
		model.addAttribute("hospitals", nr.getAllHospitals());
		if (x == 1)
			model.addAttribute("msg", "hospital added successfully");
		else
			model.addAttribute("msg", "error occurred while adding hospital");
		return "networkHospitals";
	}

	@PostMapping("/editHospital")
	public String editHospital(Model model, @ModelAttribute("networkHospital") NetworkHospitals netHsp) {
		System.out.println("edit " + netHsp);

		int x = nr.editHospital(netHsp);
		model.addAttribute("networkHospital", new NetworkHospitals());
		model.addAttribute("hospitals", nr.getAllHospitals());
		if (x == 1)
			model.addAttribute("msg", "hospital updated successfully");
		else
			model.addAttribute("msg", "error occurred while updating hospital");

		return "networkHospitals";

	}

	@PostMapping(value = "/deleteHospital")
	@ResponseBody
	public String deleteHospital(@ModelAttribute("hospitalId") String hid) {
		System.out.println(hid);
		int x = nr.deleteHospital(Integer.parseInt(hid));
		if (x == 1)
			return "hospital deleted successfully...!";
		return "error occured";
	}

	@GetMapping("/getPackages")
	public String getPackages(@RequestParam(name = "hspid") int hspid, Model model) {
		model.addAttribute("hospid", hspid);

		ArrayList<InsurancePackage> ip = nr.getRelatedPackages(hspid);
		model.addAttribute("packages", ip);
		System.out.println(ip);
		System.out.println(hspid);
		return "hptlRelatedPack";
	}

	@PostMapping("/addPackage")
	@ResponseBody
	public String addInsurancePackage(@RequestParam String title, @RequestParam String desc,
			@RequestParam String status, @RequestParam long rangeStart, @RequestParam long rangeEnd,
			@RequestParam Integer ageLimitStart, @RequestParam Integer ageLimitEnd, @RequestParam String hospid) {
		int message = nr.addPackage(title, desc, status, rangeStart, rangeEnd, ageLimitStart, ageLimitEnd,
				Integer.parseInt(hospid));

		System.out.println(message);
		if (message == 1)
			return "record added successfully";
		else
			return "error occured while adding record";
	}

	@PostMapping("/deletePackages")
	@ResponseBody
	public String deletePackages(@RequestParam String did, String hospid) {

		int message = nr.deletePackage(Integer.parseInt(did), Integer.parseInt(hospid));
		System.out.println("hosp id" + hospid);
		System.out.println("did" + did);

		System.out.println(message);
		if (message == 1)
			return "record added successfully";
		else
			return "error occured while adding record";
	}

	@PostMapping("/editPackage")
	@ResponseBody
	public String editPackage(@RequestParam String Id, String title, String Description, String status,
			String rangeStart, String rangeEnd, String ageLimitStrt, String ageLimitEnd, Model model) {
		String message = nr.editPackage(Id, title, Description, status, rangeStart, rangeEnd, ageLimitStrt,
				ageLimitEnd);
		return message;
	}

	@GetMapping("/searchbyname")
	public String search(@ModelAttribute("search") String search, Model model) {
		int hospitalCount = nr.getAllHospitals().size();

		model.addAttribute("networkHospital", new NetworkHospitals());
		model.addAttribute("hospitals", nr.getSearchHospitals(search));
		model.addAttribute("hospitalCount", hospitalCount);
		return "networkHospitals";
	}

}
