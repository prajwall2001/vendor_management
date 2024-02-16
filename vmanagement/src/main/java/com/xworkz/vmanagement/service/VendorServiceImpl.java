package com.xworkz.vmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vmanagement.dto.VendorDTO;
import com.xworkz.vmanagement.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository repo;
	public VendorServiceImpl() {
		System.out.println("Invoking VendorServiceImpl...");
	}

	@Override
	public boolean validateAndSave(VendorDTO dto) {
		System.out.println("Invoking validateAndSave....");
		System.out.println("DTO passed:" + dto);
		this.repo.save(dto);
		return true;
	}

}
