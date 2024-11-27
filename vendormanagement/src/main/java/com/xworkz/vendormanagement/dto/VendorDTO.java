package com.xworkz.vendormanagement.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class VendorDTO {
	@Id
	private int id;
	@NotNull
	@Size(min = 3, max = 30, message = "OwnerName must be between 3-30 characters")
	private String ownerName;
	@NotNull
	@Email
	private String email;
	@NotNull(message="ContactNo cannot be empty")
	private Long contactNo;
	@NotNull(message = "Alternative number cannot be empty")
	private Long alternativeNo;
	@NotNull
	@Size(min = 3, max = 30, message = "VendorName must be between 3-30 characters")
	private String vendorName;
	@NotNull
	@Size(min = 3, max = 30, message = "GstNo must be between 3-30 characters")
	private String gstNo;
	@NotNull
	@Size(min = 3, max = 30, message = "Address must be between 3-30 characters")
	private String address;
	private Date companyStartDate;
	@NotNull
	@Size(min = 3, message = "Website link must be min 300 characters")
	private String website;
	@NotNull(message="pincode cannot be empty")
	private Long pincode;
	private String otp;
	private String imagePath;
	private MultipartFile imageFile;
}
