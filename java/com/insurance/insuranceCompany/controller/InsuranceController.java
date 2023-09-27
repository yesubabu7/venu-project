package com.insurance.insuranceCompany.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.insurance.insuranceCompany.model.LoginClass;
import com.insurance.insuranceCompany.model.OTPclass;
import com.insurance.insuranceCompany.repository.NetworkHospitalRepository;
import com.insurance.insuranceCompany.repository.PackagesRepository;
import com.insurance.insuranceCompany.repository.RepositoryAdmin;

@Controller
public class InsuranceController {
	RepositoryAdmin rep;
	NetworkHospitalRepository nhr;
	PackagesRepository pr;
	HttpSession session;

	@Autowired
	public InsuranceController(RepositoryAdmin rep, NetworkHospitalRepository nhr, PackagesRepository pr,
			HttpSession session) {
		this.rep = rep;
		this.nhr = nhr;
		this.pr = pr;
		this.session = session;
	}

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("login", new LoginClass());
		return "loginPage";
	}

	@PostMapping("/adminLogin")
	public String adminlogin(@ModelAttribute("login") LoginClass lc, Model model) {
		LoginClass check = rep.checkCredentials(lc);
		if (check != null) {
			System.out.println("role id" + check.getRoleid());
			session.setAttribute("login", check.getRoleid());
			model.addAttribute("hospitalCount", nhr.getHospitalsCount());
			model.addAttribute("packageCount", pr.getPackagesCount());
			return "dashboard";
		}

		model.addAttribute("user_name", "lc.getUser_name()");
		model.addAttribute("password", "lc.getPassword()");
		model.addAttribute("errorMessage", "incorrect credentials");
		return "loginPage";
	}

	@GetMapping("/dash")
	public String firstpage() {
		System.out.println("hiiiiiiiiisfdfgiusdhus");
		return "dashboard";
	}

	@GetMapping("/forgotpassword")
	public String forgotpassword(Model model) {
		model.addAttribute("to", "");
		model.addAttribute("login", new OTPclass());
		model.addAttribute("enotp", "");
		model.addAttribute("otp", "");

		return "forgotPasswordPage";
	}

	@GetMapping("/signout")
	public String signout(Model model) {
		session.setAttribute("login", 0);
		model.addAttribute("login", new LoginClass());
		return "loginPage";
	}
}
