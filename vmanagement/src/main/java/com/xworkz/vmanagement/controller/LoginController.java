package com.xworkz.vmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vmanagement.dto.AdminEntity;
import com.xworkz.vmanagement.dto.VendorEntity;
import com.xworkz.vmanagement.repository.VendorRepository;
import com.xworkz.vmanagement.service.AdminLoginService;
import com.xworkz.vmanagement.service.VendorService;

@Component
@RequestMapping("/")
public class LoginController {
	@Autowired
	private VendorService service;

	@Autowired
	private AdminLoginService adminService;
	@Autowired
	private VendorRepository repository;

	public LoginController() {
		System.out.println("Creating the LoginController()");
	}

	@RequestMapping("/sendOTP")
	public String loginUsingEmailAndOtp(String email, String otp, Model model, HttpSession session) {
		System.out.println("Creating the loginUsingEmailAndOtp()...");
		service.findEmail(email);
//		model.addAttribute("ent", entity);
		String userEmail = email;
		session.setAttribute("loggedInEmail", email);
//		String userExist = this.service.isExist(email, otp);
//		if (userExist != null) {
//			model.addAttribute("msg", userExist);
//			this.repository.updatedOtpByEmail(email, OtpGenerator.genarateOTP());
//			return "login";
//		} else { 
//			this.repository.updatedOtpByEmail(email, OtpGenerator.genarateOTP());
//		}
		return "loginSuccess";
	}

	@GetMapping("/views")
	public String getViewPage(@RequestParam String email, Model model) {

		System.out.println("Creating the loginUsingEmailAndOtp()...");

		VendorEntity entity = this.service.findByEmail(email);
		model.addAttribute("entity", entity);
		return "view";
	}

	// admin login
	/*
	 * @RequestMapping("/adminPortal") public String
	 * loginUsingEmailAndPssword(String email, String password, Model model,
	 * HttpSession session) {
	 * System.out.println("Creating the loginUsingEmailAndPassword()...");
	 * adminService.emailAdminLoginAjax(email);
	 * adminService.passwordAdminLoginAjax(password);
	 * 
	 * 
	 * return "adminSuccess"; }
	 */

}
