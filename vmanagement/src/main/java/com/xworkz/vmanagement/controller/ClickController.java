package com.xworkz.vmanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;

public class ClickController {
	public ClickController() {
		System.out.println("Created ClickController....");
	}

	@PostMapping("/info")
	public String clicking() {
		System.out.println("Invoking clicking()....");
		return "index";
	}
}
