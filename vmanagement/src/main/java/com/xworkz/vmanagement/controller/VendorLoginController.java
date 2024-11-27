package com.xworkz.vmanagement.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vmanagement.entity.VendorEntity;
import com.xworkz.vmanagement.repository.VendorRepository;
import com.xworkz.vmanagement.service.AdminLoginService;
import com.xworkz.vmanagement.service.VendorService;

@Component
@RequestMapping("/")
public class VendorLoginController {
	@Autowired
	private VendorService service;

	@Autowired
	private AdminLoginService adminService;
	
	@Autowired
	private VendorRepository repository;

	public VendorLoginController() {
		System.out.println("Creating the LoginController()");
	}
	
	@PostMapping("/lSuccess")
	public String view(@Valid VendorEntity entity, Model model) {
		System.out.println("Invoking view()....");

		return "loginSuccess";

	}

	@RequestMapping("/sendOTP")
	public String loginUsingEmailAndOtp(String email, String otp, Model model, HttpSession session) {
		System.out.println("Creating the loginUsingEmailAndOtp()...");
		service.findEmail(email);
//		model.addAttribute("ent", entity);
		String userEmail = email;
		session.setAttribute("loggedInEmail", email);
		return "loginSuccess";
	}

	@GetMapping("/views")
	public String getViewPage(@RequestParam String email, Model model) {
		System.out.println("Creating the loginUsingEmailAndOtp()...");
		VendorEntity entity = this.service.findByEmail(email);
		model.addAttribute("entity", entity);
		return "view";
	}

}
