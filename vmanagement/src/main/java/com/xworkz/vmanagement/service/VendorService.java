package com.xworkz.vmanagement.service;

import com.xworkz.vmanagement.dto.VendorEntity;

public interface VendorService {
	public boolean validateAndSave(VendorEntity entity);

	boolean sendEmail(String email);

	String isExistByGstNoContactNoEmailWebsite(String gstNo, Long contactNo, String email, String website);

	String findAllByGstNo(String gstNo);

	String findByContactNo(Long contactNo);

	String findByAlternativeNo(Long alternativeNo);
	
	String findByEmail(String email);
	
	String findByWebsite(String website);


}
