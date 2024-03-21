package com.xworkz.vmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vmanagement.dto.AdminEntity;
import com.xworkz.vmanagement.repository.AdminRepository;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminRepository repo;
	/*
	 * @Override public String emailAdminLoginAjax(String email) {
	 * System.out.println("invoking emailAdminLoginAjax in AdminLoginServiceImpl");
	 * List<AdminEntity> entity = this.repo.findAllEntity(); for (AdminEntity ent :
	 * entity) { if (ent.getEmail().equals(email)) {
	 * System.out.println("Email is Verified"); return ""; } } return
	 * "Incorrect email"; }
	 * 
	 * @Override public String passwordAdminLoginAjax(String password) {
	 * System.out.println("invoking passwordAdminLoginAjax in AdminLoginServiceImpl"
	 * ); List<AdminEntity> entity = this.repo.findAllEntity(); for (AdminEntity ent
	 * : entity) { if (ent.getPassword().equals(password)) {
	 * System.out.println("Password is Verified"); return ""; } } return
	 * "Incorrect Password"; }
	 */
	
	
	@Override
	public boolean findEmailAndPassword(String email, String password) {
		boolean en=repo.findEmailAndPassword(email, password);
		return en;
	}
}
