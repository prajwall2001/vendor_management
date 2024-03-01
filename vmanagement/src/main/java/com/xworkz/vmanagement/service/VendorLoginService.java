package com.xworkz.vmanagement.service;

public interface VendorLoginService {
	public String emailLoginAjax(String email);

	public String loginOtpEmailMsg(String email);

	public String loginOtpAjax(String otp);

}
