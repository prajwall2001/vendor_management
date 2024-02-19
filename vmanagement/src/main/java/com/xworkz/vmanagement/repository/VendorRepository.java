package com.xworkz.vmanagement.repository;

import com.xworkz.vmanagement.dto.VendorEntity;

public interface VendorRepository {
	public boolean save(VendorEntity entity);
	
	public VendorEntity isExist(String name,String email,String website);
		
	
}
