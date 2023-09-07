package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import base.models.LoanApplicationForm;
import base.services.CustomerService;

@Controller
public class CustomerController {

	CustomerService customerservice;

	@Autowired
	public CustomerController(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	@RequestMapping(value = "/submitLoanApplication", method = RequestMethod.POST)
	public String SubmitLoanApplication(LoanApplicationForm loanApplication) {
		customerservice.createEntries(loanApplication);
		return "dummy";
	}

}