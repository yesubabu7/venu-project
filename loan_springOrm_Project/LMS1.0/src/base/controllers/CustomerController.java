package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import base.models.LoanApplicant;
import base.models.LoanApplicationForm;
import base.services.CustomerService;

@Controller
public class CustomerController {

	CustomerService customerservice;
	java.util.List<LoanApplicant> loan;

	@Autowired
	public CustomerController(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	@RequestMapping(value = "/submitLoanApplication", method = RequestMethod.POST)
	public String SubmitLoanApplication(LoanApplicationForm loanApplication, Model model) {
		customerservice.createEntries(loanApplication);
		System.out.println(loanApplication.toString() + "name");
		model.addAttribute("message", "Login successful!");
		model.addAttribute("customerName", loanApplication.getFirstname());
		model.addAttribute("lastName", loanApplication.getLastname());
		model.addAttribute("panNumber", loanApplication.getPan());
		model.addAttribute("nomineeRelation", loanApplication.getNomineerelation());

		loan = customerservice.getLoanApplicantData();

		model.addAttribute("loanList", loan);
		model.addAttribute("cibilScore", loan.get(0).getCibilScore());
		model.addAttribute("status", loan.get(0).getStatus());
		System.out.println(loanApplication.toString() + "name");
		return "data"; // Redirect to a success page

	}

	@RequestMapping(value = "/acceptOrReject", method = RequestMethod.POST)
	public String acceptOrReject(@RequestParam("applicantId") Long applicantId, @RequestParam("action") String action) {

		if (action.equals("Accept")) {
			loan = customerservice.getLoanApplicantData();

			boolean b = customerservice.loanStatusService(loan, applicantId);

		} else if (action.equals("Reject")) {

		}
		return "ok";

	}

}