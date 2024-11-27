package com.xworkz.vmanagement.repository;

import com.xworkz.vmanagement.entity.AdminEntity;

public interface AdminRepository {
	boolean findEmailAndPassword(String email,String password);

	AdminEntity findByEmail(String email);
}
