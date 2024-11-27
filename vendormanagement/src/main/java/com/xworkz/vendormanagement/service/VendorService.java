package com.xworkz.vendormanagement.service;

import java.util.List;

import com.xworkz.vendormanagement.dto.VendorDTO;
import com.xworkz.vendormanagement.entity.VendorEntity;

public interface VendorService {

	public boolean validateAndSave(VendorDTO vendorDTO);

	// boolean sendEmail(String email, String ownerName);

	List<VendorDTO> getAllVendors();
	
	String isExistByGstNoContactNoEmailWebsite(String gstNo, Long contactNo, String email, String website);

	// Ajax
	String isExistByGstNoAjax(String gstNo);

	String isExistByContactNoAjax(Long contactNo);

	String isExistByAlternativeNoAjax(Long alternativeNo);

	String isExistByEmailAjax(String email);

	String isExistByWebsiteAjax(String website);

	// login

	boolean findByEmail(String email);

	boolean saveOtpByLoginEmailID(String email);

	String validateLoginOTP(String email, String otp);

	// profile

	String findImagePathByEmail(String email);

	// update vendor
	VendorDTO findAllVendorEntityByEmail(String email);

	VendorDTO updateVendorEntityByEmail(VendorDTO dto, String email);
}
