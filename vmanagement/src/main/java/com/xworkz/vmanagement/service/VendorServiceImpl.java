package com.xworkz.vmanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vmanagement.dto.VendorEntity;
import com.xworkz.vmanagement.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository repo;

	public VendorServiceImpl() {
		System.out.println("Invoking VendorServiceImpl...");
	}

	@Override
	public boolean validateAndSave(VendorEntity entity) {
		System.out.println("Invoking validateAndSave....");
		System.out.println("Entity passed:" + entity);
		this.repo.save(entity);
		return true;
	}

	@Override
	public String isExistByNameEmailWebsite(String name, String email, String website) {
		VendorEntity ref = repo.isExist(name, email, website);
		if (ref != null) {
			if (ref.getName().equals(name)) {
				return "Name already exist";

			}

			else if (ref.getEmail().equals(email)) {
				return "Email already exist";

			} else if (ref.getWebsite().equals(website)) {
				return "Website already exist";

			} 
				System.out.println("Deatils not found....Save the details");

		}
		return null;

	}
}
