package yesu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yesu.models.LoanApplicationForm;
import yesu.services.LoanServices;

@Controller
public class LoanController {

	LoanServices loanserv;

	@Autowired
	public LoanController(LoanServices loanserv) {
		this.loanserv = loanserv;

	}

	// Handle the POST request from the form submission
	@RequestMapping(value = "/loansubmit", method = RequestMethod.POST) // Replace with your actual mapping
	public String submitLoanApplication(LoanApplicationForm loanApplicationForm) {

		System.out.println("success" + loanApplicationForm.toString());

		boolean b = loanserv.sendDataToService(loanApplicationForm);
		System.out.println(b + "bbb");
		return "y"; // You should create a "confirmation.html" view for this
	}

	@RequestMapping(value = "/yesu", method = RequestMethod.GET)

	public String getApplicationForm() {
		System.out.println("");
		return "LoanData";
	}

}