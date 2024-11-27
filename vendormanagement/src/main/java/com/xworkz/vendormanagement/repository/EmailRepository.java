package com.xworkz.vendormanagement.repository;

import com.xworkz.vendormanagement.entity.EmailValidationEntity;

public interface EmailRepository {
	boolean save(EmailValidationEntity emailValidationEntity);
	String findLatestOtpByEmail(String email);
	boolean deleteEmailVerificationDataByEmail(String email);
}
