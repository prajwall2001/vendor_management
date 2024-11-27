package com.xworkz.vmanagement.service;

import java.util.List;

import com.xworkz.vmanagement.entity.VendorEntity;

public interface AdminLoginService {
	/*
	 * public String emailAdminLoginAjax(String email);
	 * 
	 * public String passwordAdminLoginAjax(String password);
	 */

	boolean findEmailAndPassword(String email, String password);
	
	public List<VendorEntity> getAllUsers();
	
	List<VendorEntity> findByName(String name);
   
	VendorEntity updateStatusById(int id);
	
	
}
