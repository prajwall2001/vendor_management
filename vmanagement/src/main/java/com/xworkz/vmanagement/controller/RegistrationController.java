package com.xworkz.vmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vmanagement.dto.VendorDTO;
import com.xworkz.vmanagement.service.VendorService;

@Component
@RequestMapping("/")
public class RegistrationController {

	@Autowired
	private VendorService service;

	public RegistrationController() {
		System.out.println("Invoking RegistrationController....");

	}

	@PostMapping("/vendorM")
	public String save(@Valid VendorDTO dto, BindingResult errors, Model model) {
		System.out.println("Invoking save");
		System.out.println("Is Vendor DTO is valid:" + errors.hasErrors());
		model.addAttribute("dto", dto);
		if (errors.hasErrors()) {
			List<ObjectError> objectErrors = errors.getAllErrors();
			objectErrors.forEach(e -> System.err.println(e.getObjectName() + ":meassage " + e.getDefaultMessage()));
			model.addAttribute("errors", objectErrors);
			return "registration";
		} else {			
			//dto.setCreatedBy=ddto.getOwneranme;
			
			boolean saved=this.service.validateAndSave(dto);
			if(saved) {
				model.addAttribute("msg", "Vendor information saved successfully");
			}
			else {
				model.addAttribute("msg", "Vendor information not saved");
			}
			
		}
		return "registration";
	}
}
