package com.xworkz.vmanagement.repository;

import java.util.List;

import com.xworkz.vmanagement.dto.VendorEntity;

public interface VendorRepository {
	public boolean save(VendorEntity entity);
	
	public VendorEntity isExist(String gstNo,Long contactNo,String email,String website);
	
	List<String> findAllByGstNo(String gstNo);
	
	List<Long> findAllByContactNo(Long contactNo);
	
	List<Long> findAllByAlternativeNo(Long alternativeNo);
	
	List<String> findAllByEmail(String email);
	
	List<String> findAllByWebsite(String website);

	
	
}
