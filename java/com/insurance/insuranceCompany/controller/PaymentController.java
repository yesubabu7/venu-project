package com.insurance.insuranceCompany.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.insurance.insuranceCompany.contract.PaymentRepositoryInterface;
import com.insurance.insuranceCompany.model.LoginClass;
import com.insurance.insuranceCompany.repository.ClaimsRepository;
import com.insurance.insuranceCompany.repository.NetworkHospitalRepository;
import com.insurance.insuranceCompany.repository.PackagesRepository;
import com.insurance.insuranceCompany.repository.PermissionRepository;

@Controller
public class PaymentController {
	PaymentRepositoryInterface pri;
	ClaimsRepository clr;
	NetworkHospitalRepository nhr;
	PackagesRepository pr;
	HttpSession session;
	PermissionRepository perrep;
	@Autowired
	public PaymentController(ClaimsRepository clr, NetworkHospitalRepository nhr, PackagesRepository pr,
			HttpSession session,PermissionRepository perrep,PaymentRepositoryInterface pri) {
		this.clr = clr;
		this.nhr = nhr;
		this.pr = pr;
		this.session = session;
		this.perrep=perrep;
		this.pri=pri;
	}
	@GetMapping(value = "/getPayments")
	public String getAllTransaction(Model model) {
		Object lc = session.getAttribute("login");
		if ( lc==null ||(int)lc == 0 ) {
			model.addAttribute("noaccess", "you need to login first");
			model.addAttribute("login", new LoginClass());
			return "loginPage";
		}
		int access = perrep.checkAccess((int)lc, "/getPayments");
		if(access==1) {
		model.addAttribute("payments", pri.getAllTransaction());
		return "ViewPayments";
		} 
		model.addAttribute("noaccess", "you dont have access to the payment section");
		model.addAttribute("hospitalCount", nhr.getHospitalsCount());
		model.addAttribute("packageCount", pr.getPackagesCount());
		return "dashboard";
	}
}
