package com.xworkz.vmanagement.service;

import com.xworkz.vmanagement.dto.VendorEntity;

public interface VendorService {
	public boolean validateAndSave(VendorEntity entity);

	
	String isExistByNameEmailWebsite(String name,String email,String website);
}
