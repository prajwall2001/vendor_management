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

import com.xworkz.vmanagement.constants.VmanConstants;
import com.xworkz.vmanagement.dto.VendorDto;
import com.xworkz.vmanagement.service.VendorService;

@Component
@RequestMapping("/")
public class RegistrationController {

	@Autowired
	private VendorService service;

	public RegistrationController() {
		System.out.println("Invoking RegistrationController....");

	}

	@PostMapping("/info")
	public String clicking() {
		System.out.println("Invoking clicking()....");
		return "index";
	}
	
	@PostMapping("/vendorM")
	public String save(@Valid  VendorDto dto, BindingResult errors, Model model) {
		System.out.println("Invoking save");
		System.out.println("Is VendorDto is valid:" + errors.hasErrors());
		model.addAttribute("dto", dto);
		if (errors.hasErrors()) {
			List<ObjectError> objectErrors = errors.getAllErrors();
			objectErrors.forEach(e -> System.err.println(e.getObjectName() + ":meassage " + e.getDefaultMessage()));
			model.addAttribute("errors", objectErrors);
			return "registration";
		} else {
			// dto.setCreatedBy=ddto.getOwneranme;

			String uniqueError = service.isExistByGstNoContactNoEmailWebsite(dto.getGstNo(),dto.getContactNo(), dto.getEmail(), dto.getWebsite());
			if (uniqueError != null) {
				model.addAttribute("uniqueError", uniqueError);
				return "registration";
			}else {
				model.addAttribute("msg", "Vendor information saved successfully");

			}
			dto.setStatus(VmanConstants.PENDING.toString());
			this.service.validateAndSave(dto);
			this.service.sendEmail(dto.getEmail());
			return "registration";
		}
	}
	
}
