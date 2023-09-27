package com.insurance.insuranceCompany.controller;

import java.time.LocalTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.insuranceCompany.model.LoginClass;
import com.insurance.insuranceCompany.repository.EmailRepository;
import com.insurance.insuranceCompany.repository.RepositoryAdmin;

@Controller
public class EmailController {
	@Autowired
	RepositoryAdmin repadmin;

	private EmailRepository mailService;
	private HttpSession httpSession;

	@Autowired
	public EmailController(EmailRepository mailService, HttpSession httpSession) {
		this.mailService = mailService;
		this.httpSession = httpSession;
	}

	@GetMapping("/email")
	@ResponseBody
	public String email(@RequestParam("to") String to_mail) {
		String email = to_mail;

		if (mailService.checkMail(email) == 1) {
			httpSession.setAttribute("email", email);
			// storing generated otp
			int OTP = mailService.sendmail(to_mail);
			LocalTime currentTime = LocalTime.now();
			System.out.println(currentTime);
			httpSession.setAttribute("time", currentTime.plusMinutes(5));
			httpSession.setAttribute("OTP", OTP);

			return "Email Sent Successfully";
		} else
			return "Email not registered";

	}

	@PostMapping(value = "/validateOTP")
	public ModelAndView validateOTP(@RequestParam("otp") String otp, Model model) {
		model.addAttribute("to", "");
		int OTP = Integer.parseInt(otp);
		ModelAndView mav = new ModelAndView();
		int originalOtp = (Integer) httpSession.getAttribute("OTP");
		String email = (String) httpSession.getAttribute("email");
		LocalTime time = (LocalTime) httpSession.getAttribute("time");
		int comp = time.compareTo(LocalTime.now());
		// checking the otp sent by the user if true returning reset page else need to stay in the same page with error
		// msg
		if (originalOtp == OTP && comp > 0) {
			mav.setViewName("reset");
			mav.addObject("email", email);
			return mav;
		}
		mav.setViewName("forgotPasswordPage");
		if (comp < 0)
			mav.addObject("msg", "OTP expired, please try again..");
		else
			mav.addObject("msg", "Invalid OTP, please try again..");
		mav.addObject("to", email);
		return mav;
	}

	@PostMapping("/reset")
	public String reset(Model model, @RequestParam("email") String email, @RequestParam("pwd") String pwd,
			@RequestParam("cnfpwd") String cnfpwd) {
		System.out.println(email + " " + pwd + " " + cnfpwd);
		int x = repadmin.resetpwd(email, pwd);
		if (x == 1)
			model.addAttribute("message", "password changed");
		else
			model.addAttribute("message", "error while password changing");
		model.addAttribute("login", new LoginClass());
		return "loginPage";
	}
}
