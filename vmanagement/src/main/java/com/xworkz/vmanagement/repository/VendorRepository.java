package com.xworkz.vmanagement.repository;

import java.util.List;

import com.xworkz.vmanagement.entity.VendorEntity;

public interface VendorRepository {
	public boolean save(VendorEntity entity);
	

	public VendorEntity isExist(String gstNo, Long contactNo, String email, String website);
	
	public VendorEntity isExistByEmailOtp(String email,String otp);

	List<VendorEntity> findAll();

	public void updatedOtpByEmail(String email, String otp);
	
	VendorEntity findByEmail(String email);
	
	List<VendorEntity> findByName(String name);

	VendorEntity updateStatusById(int id);
	

}
