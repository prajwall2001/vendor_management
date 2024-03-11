package com.xworkz.vmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vmanagement.dto.VendorEntity;
import com.xworkz.vmanagement.repository.VendorRepository;
import com.xworkz.vmanagement.util.EmailSender;
import com.xworkz.vmanagement.util.OtpGenerator;

@Service
public class VendorLoginServiceImpl implements VendorLoginService {

	@Autowired
	private VendorRepository repository;

	@Autowired
	private EmailSender emailSender;

	public VendorLoginServiceImpl() {
		System.out.println("invoking the Login Service");
	}

	@Override
	public String emailLoginAjax(String email) {
		System.out.println("invoking emailLoginAjax in LoginServiceImpl");
		List<VendorEntity> entity = this.repository.findAll();
		for (VendorEntity entt : entity) {
			if (entt.getEmail().equals(email)) {
				System.out.println("Email is Verified");
				return "";
			}
		}
		return "*Please Register a Account";
	}

	@Override
	public String loginOtpEmailMsg(String email) {
		System.out.println("invoking the loginUsingEmailAndOtp in vendorLoginServiceImpl");

		String otp = OtpGenerator.genarateOTP();

		String subject = "One Time Password";
		String text = "Your OTP for login : " + otp;
		String to = email;
		String from = "prajwalpoojary28@outlook.com";

		boolean emailOtp = this.emailSender.emailSender(to, from, subject, text);
		this.repository.updatedOtpByEmail(email, otp);
		if (emailOtp) {
			return "OTP Sent Successfully";
		}

		return null;
	}

	@Override
	public String loginOtpAjax(String otp) {
		System.out.println("invoking the loginOtpAjax in LoginImpl");
		List<VendorEntity> entity = this.repository.findAll();
		for (VendorEntity ent : entity) {
			if (ent.getOtp().equals(otp)) {
				System.out.println("checking for " + otp);
				return "OTP matched";
			}
			else {
				return "OTP not matched";
			}
		}

		return null;

	}

	
}
