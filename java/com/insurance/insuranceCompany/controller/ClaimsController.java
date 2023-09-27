package com.insurance.insuranceCompany.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.insuranceCompany.model.Claims;
import com.insurance.insuranceCompany.model.LoginClass;
import com.insurance.insuranceCompany.model.Settlements;
import com.insurance.insuranceCompany.repository.ClaimsRepository;
import com.insurance.insuranceCompany.repository.NetworkHospitalRepository;
import com.insurance.insuranceCompany.repository.PackagesRepository;
import com.insurance.insuranceCompany.repository.PermissionRepository;

@Controller
public class ClaimsController {

	ClaimsRepository clr;
	NetworkHospitalRepository nhr;
	PackagesRepository pr;
	HttpSession session;
	PermissionRepository perrep;
	@Autowired
	public ClaimsController(ClaimsRepository clr, NetworkHospitalRepository nhr, PackagesRepository pr,
			HttpSession session,PermissionRepository perrep) {
		this.clr = clr;
		this.nhr = nhr;
		this.pr = pr;
		this.session = session;
		this.perrep=perrep;
	}

	@GetMapping("/claims")
	public String getApprovedClaims(Model model) {
		Object lc = session.getAttribute("login");
		if ( lc==null ||(int)lc == 0 ) {
			model.addAttribute("noaccess", "you need to login first");
			model.addAttribute("login", new LoginClass());
			return "loginPage";
		}
		int access = perrep.checkAccess((int)lc, "/claims");
		if (access == 1) {
			List<Claims> claims = clr.getApprovedClaims();
			List<Settlements> stmts = clr.getProcessedPayments();
			model.addAttribute("claims", claims);
			model.addAttribute("settlements", stmts);
			return "SettlementsPage";
		}
		model.addAttribute("noaccess", "you dont have access to the settlement section");
		model.addAttribute("hospitalCount", nhr.getHospitalsCount());
		model.addAttribute("packageCount", pr.getPackagesCount());
		return "dashboard";
	}
	@GetMapping("/settlement/{claimId}")
	public String getSettlementPage(@PathVariable int claimId, Model model) {
		Claims claim = clr.getClaimById(claimId);

		if (claim == null) {
			return "claimNotFound";
		}
		model.addAttribute("claim", claim);
		return "Settlements";
	}

	@RequestMapping(value = "/makePayment", method = RequestMethod.GET)
	public String confirmProcess(@RequestParam Integer claim_id, String transId) throws ParseException {
		clr.addTransaction(claim_id, transId);
		clr.updatePayStatus(claim_id);
		clr.addPayment(claim_id);
		return "redirect:/claims";
	}
	
}