package com.xworkz.vmanagement.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.vmanagement.service.VendorLoginService;
import com.xworkz.vmanagement.service.VendorService;

@RestController
@RequestMapping("/")
@EnableWebMvc
public class VendorLoginAjaxController {
	@Autowired
	private VendorLoginService serviceLogin;

	public VendorLoginAjaxController() {
		System.out.println("Invoking VendorLoginAjaxController");
	}

	@GetMapping(value = "/loginMailAjax/{email}")
	public String loginEmailAjax(@PathVariable String email) {
		System.out.println("Checking for mail :"+email);
		System.out.println("Invoking the ajaxEmailLogin()..");
		return this.serviceLogin.emailLoginAjax(email);

	}

	@GetMapping(value = "/loginOtpEmailMsg/{email}")
	public String loginOtpMsg(@PathVariable String email) {
		System.out.println("Invoking the loginOtpMsg()..");
		System.out.println("Login details send successfully");
		return this.serviceLogin.loginOtpEmailMsg(email);
	}

	@GetMapping(value = "/loginOtpAjax/{otp}")
	public String loginOtpAjax(@PathVariable String otp) {
		System.out.println("Invoking loginOtpAjax()..");
		return this.serviceLogin.loginOtpAjax(otp);
	}
}
