package com.xworkz.vmanagement.service;

public interface AdminLoginService {
	/*
	 * public String emailAdminLoginAjax(String email);
	 * 
	 * public String passwordAdminLoginAjax(String password);
	 */

	boolean findEmailAndPassword(String email, String password);
}
