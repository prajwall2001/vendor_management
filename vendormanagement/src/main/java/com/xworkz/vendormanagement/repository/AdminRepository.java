package com.xworkz.vendormanagement.repository;

import com.xworkz.vendormanagement.entity.AdminEntity;

public interface AdminRepository {
	boolean findEmailAndPassword(String email,String password);

	AdminEntity findByEmail(String email);
}
