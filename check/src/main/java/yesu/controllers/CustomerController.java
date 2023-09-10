package yesu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.*;

import yesu.models.Customer;
import yesu.models.CustomerCustomerID;
import yesu.models.LoanApplicant;
import yesu.models.LoanApplicationForm;
import yesu.services.CustomerService;

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

		

		
		System.out.println(loanApplication.toString() + "name");
		return "success"; // Redirect to a success page

	}

	@RequestMapping(value = "/acceptOrReject", method = RequestMethod.POST)
	public String acceptOrReject(@RequestParam("applicantId") Long applicantId,
			@RequestParam("customerId") int customerId,@RequestParam("action") String action) {

		if (action.equals("Accept")) {
			loan = customerservice.getLoanApplicantData();

			boolean b = customerservice.loanStatusService(loan, applicantId,action);
			

		} else if (action.equals("Reject")) {
			
			boolean b1 = customerservice.loanStatusService(loan, applicantId,action);


		}
		return "ok";

	}
	

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	
	public String userCheck(@RequestParam("username") String username, @RequestParam("password") String password,Model model) {
		loan = customerservice.getLoanApplicantData();
		
		 model.addAttribute("loanApplicants", loan);

		 List<Customer> customerIds = customerservice. getAllCustomerUsersService(username,password);
		 
		 model.addAttribute("CustomerLists", customerIds);
		 
		 
		 return "SpecificUserData";
	

	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	
	public String adminCheck(@RequestParam("username") String username, @RequestParam("password") String password,
			LoanApplicationForm loanApplication,Customer cust,Model model)
	{
		if(username.equals("yesu")&& password.equals("Yesu babu7")) {
			loan = customerservice.getLoanApplicantData();
			model.addAttribute("loanList", loan);
			model.addAttribute("loanApplication",loanApplication);
			model.addAttribute("customer",cust);
			
			

			model.addAttribute("cibilScore", loan.get(0).getCibilScore());
			model.addAttribute("status", loan.get(0).getStatus());
			
			
			return "data";
		}
		else {
			return "adminCredintial";
		}
	
	}
	
@RequestMapping(value = "/emiSchedule", method = RequestMethod.POST)
	
	public String emiScheduleCheck(@RequestParam("customerId") int customerId ,LoanApplicationForm loanApplication,Customer cust,Model model)
	{
			
			loan = customerservice.getLoanApplicantData();
			model.addAttribute("loanList", loan);
			return "emi";
	}
			
	
	
	
	
	
	
	
	
	
	
}
	
	