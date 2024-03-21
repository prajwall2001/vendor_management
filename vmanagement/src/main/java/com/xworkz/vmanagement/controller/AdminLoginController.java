package com.xworkz.vmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vmanagement.service.AdminLoginService;

@Component
@RequestMapping("/")
public class AdminLoginController {
	public AdminLoginController() {
		System.out.println("Invoking AdminLoginController");
	}

	@Autowired
	private AdminLoginService adminLoginService;

	@PostMapping("/adminPortal")
	public String findByEmailAndPassword(@RequestParam String email, String password, Model model) {
		boolean find = adminLoginService.findEmailAndPassword(email, password);
		if (find) {
			System.out.println("Login successfully..");
		} else {
			System.out.println("Login failed...");
		}
	return "adminSuccess";
	}
	
}
