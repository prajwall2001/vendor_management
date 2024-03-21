package com.xworkz.vmanagement.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vmanagement.dto.VendorEntity;

@Component
@RequestMapping("/")
public class LoginSuccessController {
	public LoginSuccessController() {
		System.out.println("Created LoginSuccessController....");
	}

	@PostMapping("/lSuccess")
	public String view(@Valid VendorEntity entity, Model model) {
		System.out.println("Invoking view()....");

		return "loginSuccess";

	}
}
