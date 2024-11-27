package com.xworkz.vmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vmanagement.entity.VendorEntity;
import com.xworkz.vmanagement.service.AdminLoginService;
import com.xworkz.vmanagement.service.VendorService;

@Component
@RequestMapping("/")
@Controller
public class AdminLoginController {
	public AdminLoginController() {
		System.out.println("Invoking AdminLoginController");
	}

	@Autowired
	private AdminLoginService adminLoginService;
	
	@Autowired
	private VendorService service;

	@PostMapping("/views")
	public String showing(@Valid VendorEntity entity, @PathVariable String email, Model model) {
		System.out.println("Invoking showing()....");

		String entity1 = service.findEmail(email);
		model.addAttribute("entities", entity1);

		return "view";
	}
	
	@PostMapping("/adminPortal")
	public String findByEmailAndPassword(@RequestParam String email, String password,Model model,HttpSession session) {
		adminLoginService.getAllUsers();
		String userEmail = email;
		session.setAttribute("loggedInEmail", email);
		boolean find=adminLoginService.findEmailAndPassword(userEmail, password);
	
		if (find) {
			System.out.println("Login success..");
			return "adminSuccess";
		} else {
			System.out.println("Login failed...");
		}
		return "admin";
	}
	
	@PostMapping("/search")
	public String searchByName(@RequestParam String name,Model model) {
			List<VendorEntity> entities=adminLoginService.findByName(name);
		    model.addAttribute("users", entities);
			return "adminSuccess";
		
	}
	
	@PostMapping("/viewAll")
	public String viewAll(Model model) {
		List<VendorEntity> allUsers = adminLoginService.getAllUsers();
		model.addAttribute("users", allUsers);
			return "adminSuccess";		
	}
	
	 @PostMapping("/updateStatus")
	    public String updateStatus(@RequestParam("id") int id,Model model) {
		 System.out.println("Updating entity with id : "+id);
		  VendorEntity ent= adminLoginService.updateStatusById(id);
		  List<VendorEntity> allUsers = adminLoginService.getAllUsers();
			model.addAttribute("users", allUsers);
			return "adminSuccess";	        
 }
	 

}
