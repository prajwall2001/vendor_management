package com.xworkz.vmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vmanagement.dto.VendorEntity;
import com.xworkz.vmanagement.service.VendorService;

@Component
@RequestMapping("/")
public class ViewController {
	public ViewController() {
		System.out.println("Invoking ViewController");
	}

	@Autowired
	private VendorService service;

	@PostMapping("/views")
	public String showing(@Valid VendorEntity entity, @PathVariable String email, Model model) {
		System.out.println("Invoking showing()....");

		String entity1 = service.findEmail(email);
		model.addAttribute("entities", entity1);

		return "view";
	}
}
