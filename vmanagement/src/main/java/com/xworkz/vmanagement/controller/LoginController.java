package com.xworkz.vmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vmanagement.dto.VendorEntity;
import com.xworkz.vmanagement.repository.VendorRepository;
import com.xworkz.vmanagement.service.VendorService;
import com.xworkz.vmanagement.util.OtpGenerator;

@Component
@RequestMapping("/")
public class LoginController {
	@Autowired
	private VendorService service;

	@Autowired
	private VendorRepository repository;

	public LoginController() {
		System.out.println("Creating the LoginController()");
	}

	@RequestMapping("/sendOTP")
	public String loginUsingEmailAndOtp(VendorEntity entity, String email, String otp, Model model) {
		System.out.println("Creating the loginUsingEmailAndOtp()...");
		System.out.println("Entity is not null");
		model.addAttribute("ent", entity);
		String userExist = this.service.isExist(email, otp);
		if (userExist != null) {
			model.addAttribute("msg", userExist);
			this.repository.updatedOtpByEmail(email, OtpGenerator.genarateOTP());
			return "login";
		} else { 
			this.repository.updatedOtpByEmail(email, OtpGenerator.genarateOTP());
		}
		return "login";
	}
}
