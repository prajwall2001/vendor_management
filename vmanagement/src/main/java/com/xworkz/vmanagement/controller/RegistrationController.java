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
import com.xworkz.vmanagement.dto.VendorEntity;
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
	public String save(@Valid VendorEntity entity, BindingResult errors, Model model) {
		System.out.println("Invoking save");
		System.out.println("Is VendorEntity is valid:" + errors.hasErrors());
		model.addAttribute("entity", entity);
		if (errors.hasErrors()) {
			List<ObjectError> objectErrors = errors.getAllErrors();
			objectErrors.forEach(e -> System.err.println(e.getObjectName() + ":meassage " + e.getDefaultMessage()));
			model.addAttribute("errors", objectErrors);
			return "registration";
		} else {
			// dto.setCreatedBy=ddto.getOwneranme;

			String uniqueError = service.isExistByGstNoContactNoEmailWebsite(entity.getGstNo(),entity.getContactNo(), entity.getEmail(), entity.getWebsite());
			if (uniqueError != null) {
				model.addAttribute("uniqueError", uniqueError);
				return "registration";
			}else {
				model.addAttribute("msg", "Vendor information saved successfully");

			}
			entity.setStatus(VmanConstants.PENDING.toString());
			this.service.validateAndSave(entity);
			this.service.sendEmail(entity.getEmail());
			return "registration";
		}
	}
	
	
}
