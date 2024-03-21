package com.xworkz.vmanagement.repository;

public interface AdminRepository {
	//List<AdminEntity> findAllEntity();
	boolean findEmailAndPassword(String email,String password);

}
