package com.xworkz.vmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vmanagement.entity.AdminEntity;
import com.xworkz.vmanagement.entity.VendorEntity;
import com.xworkz.vmanagement.repository.AdminRepository;
import com.xworkz.vmanagement.repository.VendorRepository;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private AdminRepository repo;

//	@Autowired
//	private PasswordEncoder encoder;

	@Override
	public boolean findEmailAndPassword(String email, String password) {

		AdminEntity en = repo.findByEmail(email);
		if (en != null && en.getEmail() != null) {
			if (en.getEmail().equals(email) && password.equals(en.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<VendorEntity> getAllUsers() {

		return vendorRepository.findAll();
	}

	@Override
	public List<VendorEntity> findByName(String name) {
		return vendorRepository.findByName(name);
	}

	@Override
	public VendorEntity updateStatusById(int id) {
		System.out.println("Invoking updateVendorStatusById : " + id);
		return vendorRepository.updateStatusById(id);
	}
}
