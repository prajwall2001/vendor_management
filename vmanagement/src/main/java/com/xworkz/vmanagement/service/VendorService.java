package com.xworkz.vmanagement.service;

import java.util.List;

import com.xworkz.vmanagement.dto.VendorDto;
import com.xworkz.vmanagement.entity.VendorEntity;

public interface VendorService {
	
	public boolean validateAndSave(VendorDto dto);

	boolean sendEmail(String email);

	String isExistByGstNoContactNoEmailWebsite(String gstNo, Long contactNo, String email, String website);

	String findAllByGstNo(String gstNo);

	String findByContactNo(Long contactNo);

	String findByAlternativeNo(Long alternativeNo);
	
	String findEmail(String email);
	
	String findByWebsite(String website);
	
	String isExist(String email,String otp);
	
	VendorEntity findByEmail (String email);
  
	void updateVendorStatusById(int id);


}
